package rt.lewis.convertor;

import com.wangyin.front.adapter.InnerToOuter;
import com.wangyin.front.adapter.OuterToInner;
import com.wangyin.front.message.MessageSpecInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rt.lewis.rainbow.request.BaseInputMsg;
import rt.lewis.rainbow.request.InputContext;
import rt.lewis.rainbow.response.ReturnMessage;
import rt.lewis.api.common.RegUtils;
import rt.lewis.api.exception.RegException;
import rt.lewis.api.message.APIHttpMessage;
import rt.lewis.dict.Dict;
import rt.lewis.util.LogBuild;
import rt.lewis.utils.json.JsonUtil;
import rt.lewis.utils.string.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class AbstractConvertor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected static final String ERROR = "{\"code\":\"01\",\"context\":{},\"message\":\"服务繁忙，请稍后再试。\"}";
	
	protected static final String REGERROR = "{\"code\":\"REGERROR\",\"context\":{},\"message\":\"请求参数不合法。\"}";

	
	@OuterToInner
	public Object cvtOuterToInner(MessageSpecInf outer) throws Exception {
		String methodDesc = "天府手机银行【外部-->内部】,cvtOuterToInner:" + outer.getFuncode();
		logger.debug(LogBuild.getBuilder(methodDesc, "Http外部请求开始").kv("request",  JsonUtil.toJSON(outer)).build());
		APIHttpMessage req = (APIHttpMessage) outer;
		
		String reqMsg = (String) req.getBodyObject();
		logger.info("请求URL:{}, 外部请求参数:{}" , outer.getFuncode(), reqMsg == null ? "null" : reqMsg);
		if(RegUtils.findReg(reqMsg)){
			logger.error("请求URL:{}, 外部请求参数:{},非法字符注入",outer.getFuncode(),reqMsg);
			throw new RegException("REGERROR");
		}
		
		InputContext inputMsg = createInputMsg();
		try {
			inputMsg = JsonUtil.fromJSONToObject(reqMsg, inputMsg.getClass());
			combineHeader(inputMsg, req);
		} catch (Exception e) {
			logger.error("参数转换失败", e);
		}
		logger.info("请求URL:{}, 转换后的请求参数:inputMsg:{}", outer.getFuncode(), inputMsg);
		return inputMsg;
	}
	
	@InnerToOuter
	public MessageSpecInf cvtInnerToOuter(ReturnMessage mapiResp,
			final MessageSpecInf outer, final Throwable t) throws Exception {
		
		APIHttpMessage resp = new APIHttpMessage(200, "application/json", null);
		
		if(t instanceof RegException){
			 logger.error("非法字符注入");
			 resp.setContent(REGERROR.getBytes());
			 return resp;
		}
		
		String methodDesc = "天府手机银行【内部-->外部】,cvtInnerToOuter:" + outer.getFuncode();
		logger.debug(LogBuild.getBuilder(methodDesc, "服务端返回结果").kv("response", mapiResp!=null ? mapiResp.toString() : "null").build());
		
		String result=mapiResp!=null?JsonUtil.toJSON(mapiResp):"";
		
		if (mapiResp == null || result.length() == 0) {
			logger.error("服务调用失败，返回值mapiResp：{}", mapiResp);
			resp.setContent(ERROR.getBytes());
		} else {
			//将防重复提交的token返回客户端
			if (!StringUtils.isBlank(mapiResp.getAtoken())) {
				resp.addHeader(Dict.ATOKEN, mapiResp.getAtoken());
				mapiResp.setAtoken(null);
			}
			resp.setContent(result.getBytes());
		}
		logger.info("服务端返回结果:ATOKEN:{}, 请求URL:{}, 返回结果:{}", resp.getHeader(Dict.ATOKEN), outer.getFuncode(), result);
		return resp;
	}
	
	/**
	 * 创建输入参数
	 * 根据业务不同创建所需输入参数
	 * @return
	 */
	protected abstract InputContext createInputMsg();
	
	/**
	 * 组装header请求参数
	 * @param dto 具体DTO
	 * @param req APIHttpMessage
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public <T> Object combineHeader(T dto, APIHttpMessage req) throws UnsupportedEncodingException {
		if (dto instanceof BaseInputMsg) {
			BaseInputMsg request = (BaseInputMsg)dto;
			request.setClientIp(req.getHeader(Dict.CLIENT_IP));
			request.setAppversion(req.getHeader(Dict.APP_VERSION));
			request.setSystem(req.getHeader(Dict.SYSTEM));
			request.setSystemversion(req.getHeader(Dict.SYSTEM_VERSION));
			request.setImei(req.getHeader(Dict.IMEI));
			request.setAtoken(req.getHeader(Dict.ATOKEN));
			request.setLat(req.getHeader("lat"));
			request.setLon(req.getHeader("lon"));
			request.setDid(req.getHeader("did"));
			String position=req.getHeader("position");
			if(!StringUtils.isBlank(position)){
				request.setPosition(URLDecoder.decode(position,"UTF-8"));
			}
			
			//URL统一去掉根目录
			request.setUrl(req.getRequestUri().substring(req.getRequestUri().indexOf("/", 1)));
			request.setAppID(req.getHeader(Dict.INVOKE_APP_ID));
			request.setAppSecret(req.getHeader(Dict.INVOKE_APP_SECRET));
		}
		return dto;
	}
}
