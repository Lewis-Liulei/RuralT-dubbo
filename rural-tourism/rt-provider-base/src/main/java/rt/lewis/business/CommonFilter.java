package rt.lewis.business;

//import cn.cgnb.common.ProcessContext;
import cn.cgnb.common.redis.JedisTemplate;
/*import cn.cgnb.utils.json.JsonUtil;
import com.cgnb.business.mq.login.LoginProducer;
import com.cgnb.business.user.StartBiz;
import com.cgnb.mobile.dict.common.CONSMSG;
import com.cgnb.mobile.dict.common.Dict;
import com.cgnb.mobile.dict.common.MvcConstants;
import com.cgnb.mobile.dict.common.UserStatusEnum;
import com.cgnb.mobile.dict.errorcode.ErrorConstants;
import com.cgnb.mobile.dict.redis.RedisConstants;
import com.cgnb.mobile.dict.redis.RedisTypeConstant;
import com.cgnb.mobile.exception.ZSBusinessException;
import com.cgnb.mobile.request.BaseInputMsg;
import com.cgnb.mobile.request.user.login.StartRequest;
import com.cgnb.mobile.response.ReturnMessage;
import com.cgnb.mobile.utils.ECUPUtil;
import com.cgnb.mobile.utils.TokenIdUtil;
import com.cgnb.mobile.utils.date.DateFormatUtil;
import com.cgnb.mobile.utils.string.StringUtil;
import com.cgnb.model.sys.SysMessage;
import com.cgnb.model.user.BaseUser;
import com.cgnb.model.user.TransConfig;
import com.cgnb.service.common.TransCommonContextService;
import com.cgnb.service.common.utils.CodeUtil;
import com.cgnb.service.common.utils.SysParameterUtil;
import com.cgnb.service.sys.MobileSystemLoginService;
import com.cgnb.service.sys.SysDeviceInfoService;
import com.cgnb.service.sys.TransConfigService;
import com.cgnb.service.user.StartRequestService;
import com.cgnb.service.user.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rt.lewis.rainbow.request.BaseInputMsg;
import rt.lewis.rainbow.response.ReturnMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务拦截器
 * 功能校验点：
 * 1、检查是否展示系统消息
 * 2、检查当前请求是否需要排除拦截器判断
 * 3、检查是否需要更新设备信息的URL
 * 4、需要则进行设备信息版本检查
 * 5、防止重复提交token检查
 * 6、检查用户角色是否有url的访问权限
 * 7、用户状态检查（状态是否正常）
 * 8、判断当前请求是否需要实名认证
 * @author cgnb_wangjie
 *
 */
public class CommonFilter {
	
    private Logger logger = LoggerFactory.getLogger(getClass());
	public static final String TOKEN_PREFIX = "ATOKEN";
	
	/**需要检查是否更新设备信息的URL*/
	private List<String> notUpdateList;
	private boolean checkToken;
	private List<String> exceptUrlList;
	private JedisTemplate jedisTemplate;
	//private MobileSystemLoginService mobileSystemLoginService;
	//private SysDeviceInfoService sysDeviceInfoService;
	//private TransCommonContextService transCommonContextService;
	//private TransConfigService transConfigService;
	//private StartBiz startBiz;
	//private StartRequestService startRequestService;
//	private LoginProducerService loginProducerService;
	//private LoginProducer loginProducer;
	//获取角色可访问的url列表
	//private SysUserService sysUserService;
	/**无需刷新防重复提交token的URL列表*/
	private String notFlushTokenUrls;
	/**需要检查重复提交的URL*/
	private String checkUrls;
	private String topicName;

	public void init() {
		/**无需刷新防重复提交token的URL列表*/
		//notFlushTokenUrls = SysParameterUtil.getParamValue( "AccessControl", "NOT_FLUSH_TOKEN_URL_LIST" ).concat(",");
		/**需要检查重复提交的URL*/
		//checkUrls = SysParameterUtil.getParamValue( "AccessControl", "CHECK_TOKEN_URL_LIST" ).concat(",");
	}
	/**
	 * 防止重复提交检查
	 * @return
	 */
	//private boolean isTokenValid(TransConfig transConfig, BaseInputMsg baseInputMsg, ReturnMessage returnMessage) {
		/*String atoken = baseInputMsg.getAtoken();
    	String tokenId = baseInputMsg.getTokenId();
    	String url = baseInputMsg.getUrl() + ",";

		if (!transConfig.getIsFlushToken()) {
			logger.info("checkReqRepeated,{}", "\n==============THIS URL IN WHITE LIST=============\nDO NOT FLUSH TOKEN:" + url);
			return true;
		}

		String reToken = jedisTemplate.get(TOKEN_PREFIX, tokenId);
		String newAToken = ECUPUtil.getUUID();
		resetATokenCache(tokenId, newAToken, url);
		returnMessage.setAtoken(newAToken);

		if (!isCheckToken()) {
			return true;
		}

		if (transConfig.getIsCheckRepeated()) {
			if(null == atoken || !atoken.equals(reToken)){
				logger.error( "checkReqRepeated,{}", "\n====================CHECK_TOKEN_FAILED=====================\n========NEW_TOKEN = " + newAToken + "\n========USER_TOKEN_ID = " + tokenId + "\n========OLD_TOKEN_IN_REDIS = " + reToken + "\n========HEADER_TOKEN = " + atoken + "\n========REQ_URL = " + url + "\n=============" );
				return false;
			}
			logger.info( "checkReqRepeated,{}", "\n====================CHECK_TOKEN=====================\n========NEW_TOKEN = " + newAToken + "\n========USER_TOKEN_ID = " + tokenId + "\n========OLD_TOKEN_IN_REDIS = " + reToken + "\n========HEADER_TOKEN = " + atoken + "\n========REQ_URL = " + url + "\n=============" );
		} else {
			logger.info( "checkReqRepeated,{}", "\n==================NOT_CHECK_TOKEN====================\n========NEW_TOKEN = " + newAToken + "\n========USER_TOKEN_ID = " + tokenId + "\n========OLD_TOKEN_IN_REDIS = " + reToken + "\n========HEADER_TOKEN = " + atoken + "\n========REQ_URL = " + url + "\n============" );
		}
//		if (!StringUtils.isBlank(checkUrls)) {
//			if (checkUrls.contains(url)) {//白名单内的检查
//				return null != atoken && atoken.equals( reToken );
//			} else {
//				logger.info( "checkReqRepeated", "\n==================NOT_CHECK_TOKEN====================\n========NEW_TOKEN = " + newAToken + "\n========USER_TOKEN_ID = " + tokenId + "\n========OLD_TOKEN_IN_REDIS = " + reToken + "\n========HEADER_TOKEN = " + atoken + "\n========REQ_URL = " + url + "\n============" );
//			}
//		} else {
//			logger.debug("checkReqRepeated", "Please set checkUrlList in sysPara!" );
//		}
		logger.debug("checkToken deal end");
		return true;*/
    //}
	
	private void resetATokenCache(String tokenId, String newAToken, String url) {
		//jedisTemplate.del(TOKEN_PREFIX, tokenId);
		//logger.debug("==============DELETE AToken FROM REDIS=============");
		//jedisTemplate.set(TOKEN_PREFIX, tokenId, newAToken, RedisConstants.SESSION_TIMEOUT);
		//logger.debug("==============SET AToken INTO REDIS=============\n========NEW_TOKEN = {}\n========url = {}", newAToken, url);
	}
		
	
//	public void loadContext(BaseInputMsg baseInputMsg) {
//        ProcessContext context = baseInputMsg.getProcessContext();
//		TransConfig transConfig = getTransConfig(transCommonContextService.getLocalTransName(context));
//		//context中设置交易配置信息
//		if (null != transConfig) {
//			transCommonContextService.setTransConfig(context, transConfig);
//			transCommonContextService.setLocalTransCode(context, transConfig.getTransCode());
//		} else {
//			logger.error("请设置交易配置信息：zs_t_trans_config");
//			throw new ZSBusinessException("01", "交易配置信息为空");
//		}
//		transCommonContextService.setAppID(context, baseInputMsg.getAppID());
//		transCommonContextService.setAppSecret(context, baseInputMsg.getAppSecret());
//	}
	
	/*public ReturnMessage loginInfoCheck(BaseInputMsg baseInputMsg, ReturnMessage returnMessage) {
		String url = baseInputMsg.getUrl();
		String imei = baseInputMsg.getImei();
		String tokenId = baseInputMsg.getTokenId();//用户登陆token
		String deviceSystemVersion = baseInputMsg.getSystemversion();
		String system = baseInputMsg.getSystem();//request新增设备类型
		String clientVersion = baseInputMsg.getAppversion();
		String channelType = baseInputMsg.getChannelType();
		if (StringUtils.isBlank(channelType)) {
			baseInputMsg.setChannelType(CONSMSG.CHANNEL_TYPE);
		}
		
        ProcessContext context = baseInputMsg.getProcessContext();
		TransConfig transConfig = transCommonContextService.getTransConfig(context);
		
		//检查版本更新  仅在用户登录时校验
		if ("userLogin".equals(transConfig.getTransCode()) && transConfig.getIsCheckUpdate()) {
			
		}
		
		//系统信息提示
		if (combileSysMessage(returnMessage)) {
			return returnMessage;
		}

		//不检查tokenId
		if (!transConfig.getIsCheckTokenId()) {
			return returnMessage;
		}
		//排除URL 
//		if (exceptUrlList != null && exceptUrlList.contains(url)) {
//			return;
//		}
		String deTokenId = TokenIdUtil.decodeTokenId(tokenId);
		int index = deTokenId.lastIndexOf("_");
		long tokenTime = Long.valueOf(deTokenId.substring(index + 1));
		boolean isLogin = false;
		if(tokenTime - System.currentTimeMillis()  > 0){
			isLogin = true;
		}else{
			isLogin = jedisTemplate.exists(RedisTypeConstant.LOGIN_USER_INFO, deTokenId);
		}
		logger.info("获取tokenId:"+deTokenId+",时间:"+System.currentTimeMillis());
		if (isLogin) {
			//检查重复提交
			if (!isTokenValid(transConfig, baseInputMsg, returnMessage)) {
				retReqRepeated(returnMessage);
				return returnMessage;
			}
			//获取用户信息缓存
			BaseUser user = null;
			try{
				user = sysUserService.getUserInfo(tokenId);
			}catch(ZSBusinessException e){
				if("B31".equals(e.getErrorCode())){
					//游客登录
					logger.info( "###用户未登录,自动登录为游客###" + url + "," + tokenId );
					StartRequest startRep = new StartRequest();
					startRep.setAppversion(baseInputMsg.getAppversion());
					startRep.setSystemversion(baseInputMsg.getSystemversion());
					startRep.setImei(baseInputMsg.getImei());
					startRep.setSystem(baseInputMsg.getSystem());
					startRep.setChannelType(baseInputMsg.getChannelType());
					startRep.setType("");//游客自动登录
					startRep.setLon(baseInputMsg.getLon());
					startRep.setLat(baseInputMsg.getLat());
					startRep.setPosition(baseInputMsg.getPosition());
					startRep.setTokenId(tokenId);
					returnMessage = startBiz.register(startRep);
					//设置timeout，让前端跳到登录页面
					returnMessage.setCode(MvcConstants.MVC_RETURN_TYPE_TIME_OUT);
					returnMessage.setMessage("登录超时，请重新登录");	
					return returnMessage;
				}
			}
			//context添加用户信息
			transCommonContextService.setUser(context, user);

//			if("visitors".equals(user.getUserType())){
//				String autoLoginUrl = SysParameterUtil.getParamValue( "AccessControl", "AUTO_LOGIN_URL" ).concat(",");
//				if(autoLoginUrl.contains(url)){
//					//TODO 自动登录
//				}
//			}
			
			logger.info("用户请求UserInfoId:{}, userAccount:{}", user.getUserID(), user.getUserAccount());
			//检查用户角色是否有url的访问权限
			if (!sysUserService.queryUserUrlByRoleId(user.getRoleId(), baseInputMsg.getUrl())) {
				returnMessage.setCode(MvcConstants.MVC_RETURN_OVER_RIGHT);
				returnMessage.setMessage(user.getDefaultErrorMsg());
				returnMessage.setType(MvcConstants.MVC_RETURN_TYPE_INVALID_ACCESS);
				returnMessage.setTypeDescribe(MvcConstants.MVC_RETURN_TYPE_INVALID_ACCESS_DESCRIBE);
				return returnMessage;
			}
			//判断用户状态
			if (UserStatusEnum.LOCK_STATUS.getCode().equals(user.getStatus())) {
				logger.info( "用户状态为锁定" + url + "," + tokenId + ",user account:" + user.getUserAccount() );
				setErrorMessage( returnMessage );
				return returnMessage;
			}
			
			//判断当前请求是否需要实名认证
			if (transConfig.getIsCheckRealname()) {
				String status = mobileSystemLoginService.getCifStatus(url);
				if (!StringUtils.isBlank(status) && !status.contains(user.getApplyStatus())) {
					logger.info("用户未实名认证，applyStatus：" +  user.getApplyStatus()  + "," + tokenId + ",user account:" + user.getUserAccount() );
					returnMessage.setCode(MvcConstants.MVC_RETURN_RESULT_FAILD_CODE);
					returnMessage.setMessage("请先实名认证");
					return returnMessage;
				}
			}
			
			//重置缓存数据
			resetJedisSession(user, baseInputMsg);

		} else {
			//判断此交易游客是否具有访问权限
//			SystemRoles role = startRequestService.getRolesByRolesCode("visitors");
//			if (!sysUserService.queryUserUrlByRoleId(role.getOid(), baseInputMsg.getUrl())) {
//				logger.info( "###用户未登录,需要重新登录###" + url + "," + tokenId );
//				setErrorMessage(returnMessage);
//				return returnMessage;
//			}
			
			//游客登录
			logger.info( "###用户未登录,自动登录为游客###" + url + "," + tokenId );
			StartRequest startRep = new StartRequest();
			startRep.setAppversion(baseInputMsg.getAppversion());
			startRep.setSystemversion(baseInputMsg.getSystemversion());
			startRep.setImei(baseInputMsg.getImei());
			startRep.setSystem(baseInputMsg.getSystem());
			startRep.setChannelType(baseInputMsg.getChannelType());
			startRep.setType("");//游客自动登录
			startRep.setLon(baseInputMsg.getLon());
			startRep.setLat(baseInputMsg.getLat());
			startRep.setPosition(baseInputMsg.getPosition());
			startRep.setTokenId(tokenId);
			returnMessage = startBiz.register(startRep);
			//设置timeout，让前端跳到登录页面
			returnMessage.setCode(MvcConstants.MVC_RETURN_TYPE_TIME_OUT);
			returnMessage.setMessage("登录超时，请重新登录");
		}
		return returnMessage;
	}

	public ReturnMessage checkAppVersion(BaseInputMsg baseInputMsg){
		ReturnMessage returnMessage = new ReturnMessage();
		String url = baseInputMsg.getUrl();
		String imei = baseInputMsg.getImei();
		String tokenId = baseInputMsg.getTokenId();//用户登陆token
		String deviceSystemVersion = baseInputMsg.getSystemversion();
		String system = baseInputMsg.getSystem();//request新增设备类型
		String clientVersion = baseInputMsg.getAppversion();
		//取得可以更新的最小版本
		logger.debug("检查更新！,当前url:{},获取最小交易版本号：{}", url,"device_" + system);
		//获取系统参数中配置的最小可以登录交易版本号
		String leastVersion = SysParameterUtil.getParamValue("AccessControl", "device_" + system);
		if(StringUtil.isBlank(leastVersion)){//没有配置走老的业务逻辑
			String compareVersion = sysDeviceInfoService.getForcedUpdateVersion(deviceSystemVersion, system, clientVersion, imei);
			if (ECUPUtil.compareVersion(compareVersion, clientVersion) > 0) {
				logger.info("系统类型:{}, 当前版本：{}, 最新版本：{}, tokenid:{}", system, clientVersion, compareVersion, tokenId);
				returnMessage.setCode(ErrorConstants.ERROR_EU_000001);
				returnMessage.setMessage("当前客户端版本太低请更新");
				return returnMessage;
			}
		}else{//配置了最小可以登录交易版本号，当登录用户版本号小于这个版本号时直接提示用户请升级版本
			if (ECUPUtil.compareVersion(leastVersion, clientVersion) > 0) {
				logger.info("系统类型:{}, 当前版本：{}, 系统配置可以登录交易的最低版本：{}, tokenid:{}", system, clientVersion, leastVersion, tokenId);
				returnMessage.setCode(ErrorConstants.ERROR_EU_000001);
                returnMessage.getContext().put("updateUrl",  SysParameterUtil.getParamValue("AccessControl", "device_url_" + system));
				returnMessage.setMessage("当前客户端版本太低请更新");
				return returnMessage;
			}
		}
		returnMessage.setCode("00");
		return returnMessage;
	
	}
	*//**
	 * 重置缓存信息
	 * @param user
	 * @param inputMsg
	 *//*
	private void resetJedisSession(BaseUser user, BaseInputMsg inputMsg) {
		if(user.getUserAccount().length() == 11){
			Map<String,String> params = new HashMap<String,String>();
			params.put("userAccount", user.getUserAccount());
			params.put("tokenId", inputMsg.getTokenId());
			params.put("userId", user.getUserID());
			try {
				SendResult sr = loginProducer.push(topicName, "login_redis", user.getUserID(), JsonUtil.toJSON(params).getBytes("UTF-8"));
				logger.info("sendResult:"+sr);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new ZSBusinessException(e.getMessage());
			}
			logger.info("推送MQ消息成功");
		}
//		if(user.getUserAccount().length() == 11){
//			jedisTemplate.expire( RedisTypeConstant.LOGIN, user.getUserAccount(), RedisConstants.SESSION_TIMEOUT );
//			jedisTemplate.expire( RedisTypeConstant.LOGIN, user.getUserAccount() + inputMsg.getChannelType(), RedisConstants.SESSION_TIMEOUT );
//			jedisTemplate.expire( RedisTypeConstant.LOGIN_USER_INFO, inputMsg.getTokenId(), RedisConstants.SESSION_TIMEOUT );
//			jedisTemplate.expire( RedisTypeConstant.SESSION_TOKEN, user.getUserID(), RedisConstants.SESSION_TIMEOUT );
//			jedisTemplate.expire( RedisTypeConstant.LOGIN_RESOURES, user.getUserAccount(), RedisConstants.SESSION_TIMEOUT );
//		}
	}
	
	*//**
	 * 请求参数校验
	 * @param message
	 *//*
//	private void setErrorParamMessage(ReturnMessage message) {
//		message.setCode( MvcConstants.MVC_RETURN_TYPE_SYS );
//		message.setMessage( MvcConstants.MVC_RETURN_TYPE_SYS_DESCRIBE );
//		message.setType( MvcConstants.MVC_RETURN_TYPE_VALID );
//		message.setTypeDescribe( MvcConstants.MVC_RETURN_TYPE_VALID_DESCRIBE );
//	}
	
	*//**
	 * 非法访问
	 * @param message
	 *//*
	private void setErrorMessage(ReturnMessage message) {
		message.setCode( MvcConstants.MVC_RETURN_TYPE_TIME_OUT );
		message.setMessage( MvcConstants.MVC_RETURN_RESULT_FAILD_MESSAGE );
		message.setType( MvcConstants.MVC_RETURN_TYPE_INVALID_ACCESS );
		message.setTypeDescribe( MvcConstants.MVC_RETURN_TYPE_INVALID_ACCESS_DESCRIBE );
	}
	
	*//**
	 * 重复提交返回消息
	 * 
	 * @param response
	 *//*
	private void retReqRepeated(ReturnMessage message) {
		message.setCode( MvcConstants.MVC_RETURN_TYPE_REQ_REPEATED );
		message.setMessage( MvcConstants.MVC_RETURN_TYPE_REQ_REPEATED_DESCRIBE );
		message.setType( MvcConstants.MVC_RETURN_TYPE_INVALID_ACCESS );
		message.setTypeDescribe( MvcConstants.MVC_RETURN_TYPE_REQ_REPEATED_DESCRIBE );
	}

//	private TransConfig getTransConfig(String transCode) {
//		TransConfig transConfig = transConfigService.getTransConfigByTransCode(transCode);
//		return transConfig;
//	}

	private boolean isCheckToken() {
		return checkToken;
	}

	public boolean combileSysMessage(ReturnMessage returnMessage) {
		String available = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_AVAILABLE);// 是否可用
		String showDate = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_SHOW_DATE);// 时间区间
		logger.debug("available:{},showDate:{}", available, showDate);
		if ("Y".equalsIgnoreCase(available) && checkShowDate(showDate)) {
			// 获取全局系统消息
			String moduleCode = "all";// 消息模块编码
			String title = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_TITLE);// 标题
			String content = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_CONTENT);// 内容
			String showTime = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_SHOW_TIME);// 显示时间长短
			String goNext = CodeUtil.getCodeName(Dict.MOBILE_SYS_MESSAGE, Dict.ALL_GO_NEXT);// 是否可以进行下一步操作

			// 加入有效的系统模块消息
			SysMessage sysMessage = new SysMessage();
			sysMessage.setModuleCode(moduleCode);
			sysMessage.setTitle(title);
			sysMessage.setContent(content);
			sysMessage.setShowDate(showDate);
			sysMessage.setShowTime(showTime);
			sysMessage.setAvailable(available);
			sysMessage.setGoNext(goNext);

			returnMessage.setCode(ErrorConstants.ERROR_A2_MC_00096);
			returnMessage.setMessage(CodeUtil.getCodeName(
					ErrorConstants.ERROR_CODE_MESSAGE_ALL, ErrorConstants.ERROR_A2_MC_00096));
			returnMessage.getContext().put(Dict.SYS_MESSAGE, sysMessage);
			return true;
		}
		return false;
	}
	
	private boolean checkShowDate(String showDate) {
		int d1 = 0;
		int d2 = 0;
		if ( !StringUtils.isBlank( showDate ) && !"N".equalsIgnoreCase( showDate ) ) {
			//获取对应模块消息时间区间比较当前时间大小(日期)
			String [] showDateStrList = showDate.split( "-" );
			String openTime = showDateStrList[ 0 ];
			String cutOffTime = showDateStrList[ 1 ];
			SimpleDateFormat sdf = new SimpleDateFormat(DateFormatUtil.FORMAT_NORMAL_DATE_TIME);

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			Calendar c3 = Calendar.getInstance();

			try {
				c1.setTime( sdf.parse( openTime ) );
				c2.setTime( sdf.parse( cutOffTime ) );
			} catch ( ParseException e ) {
				logger.error("日期格式转换错误");
				throw new ZSBusinessException( ErrorConstants.ERROR_A2_MC_00095, CodeUtil.getCodeName( ErrorConstants.ERROR_CODE_MESSAGE_ALL, ErrorConstants.ERROR_A2_MC_00095 ) );
			}
			d1 = c1.compareTo( c3 );//0:相等 -1:c1小于c3 1:c1大于c3
			d2 = c2.compareTo( c3 );//0:相等 -1:c2小于c3 1:c2大于c3
		}
		
		return d1 <= 0 && d2 >= 0;
	}
	
	public void setCheckToken(boolean checkToken) {
		this.checkToken = checkToken;
	}
	
	public void setJedisTemplate(JedisTemplate jedisTemplate) {
		this.jedisTemplate = jedisTemplate;
	}

	public void setMobileSystemLoginService(
			MobileSystemLoginService mobileSystemLoginService) {
		this.mobileSystemLoginService = mobileSystemLoginService;
	}
	
	public void setExceptUrlList(List<String> exceptUrlList) {
		this.exceptUrlList = exceptUrlList;
	}

	public void setNotUpdateList(List<String> notUpdateList) {
		this.notUpdateList = notUpdateList;
	}
	
	public void setSysDeviceInfoService(SysDeviceInfoService sysDeviceInfoService) {
		this.sysDeviceInfoService = sysDeviceInfoService;
	}
	
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
	public void setTransCommonContextService(TransCommonContextService transCommonContextService) {
		this.transCommonContextService = transCommonContextService;
	}
	
	public void setTransConfigService(TransConfigService transConfigService) {
		this.transConfigService = transConfigService;
	}
	
	public void setStartBiz(StartBiz startBiz) {
		this.startBiz = startBiz;
	}

	public void setStartRequestService(StartRequestService startRequestService) {
		this.startRequestService = startRequestService;
	}
	public void setLoginProducer(LoginProducer loginProducer) {
		this.loginProducer = loginProducer;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
//	public void setLoginProducerService(LoginProducerService loginProducerService) {
//		this.loginProducerService = loginProducerService;
//	}*/

}
