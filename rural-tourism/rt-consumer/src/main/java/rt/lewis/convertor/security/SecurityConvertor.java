package rt.lewis.convertor.security;

/*import cn.cgnb.request.security.SecurityInputMsg;
import cn.cgnb.response.security.SecurityReturnMsg;
import cn.cgnb.security.dict.SecurityDict;
import com.cgnb.mobile.api.message.APIHttpMessage;
import com.cgnb.mobile.request.BaseInputMsg;
import com.cgnb.mobile.response.ReturnMessage;
import com.cgnb.mobile.wac.mapi.convertor.AbstractConvertor;
import com.wangyin.front.adapter.InnerToOuter;
import com.wangyin.front.adapter.OuterToInner;
import com.wangyin.front.message.MessageSpecInf;
import rt.lewis.api.message.APIHttpMessage;
import rt.lewis.convertor.AbstractConvertor;
import rt.lewis.utils.string.StringUtils;
import org.springframework.stereotype.Component;*/

/*@Component(value = "securityConvertor")*/
public class SecurityConvertor {/*
	
	@OuterToInner
	@Override
	public Object cvtOuterToInner(MessageSpecInf outer) throws Exception {
		APIHttpMessage req = (APIHttpMessage) outer;
		SecurityInputMsg inputMsg = (SecurityInputMsg) createInputMsg();
		inputMsg.setSecurityData(req.getBodyBinary());
		String sessionId  = req.getHeader(SecurityDict.HEADER_SESSION_ID);
		inputMsg.setSessionId(sessionId);
		//组装报文头的内容
		combineHeader(inputMsg, req);
		return inputMsg;
	}
	
	@InnerToOuter
	@Override
	public MessageSpecInf cvtInnerToOuter(ReturnMessage mapiResp,
			MessageSpecInf outer, Throwable t) throws Exception {
		SecurityReturnMsg retMsg = (SecurityReturnMsg) mapiResp;
		APIHttpMessage resp = new APIHttpMessage(retMsg.getStatus(), SecurityDict.CONTENT_TYPE_STREAM, retMsg.getSecurityData());
		String sessionId = retMsg.getSessionId();
		if(!StringUtils.isBlank(sessionId)){
			resp.addHeader(SecurityDict.HEADER_SET_SESSION_ID, sessionId);
		}
		return resp;
	}
	
	@Override
	protected BaseInputMsg createInputMsg() {
		return new SecurityInputMsg();
	}
	*/
}
