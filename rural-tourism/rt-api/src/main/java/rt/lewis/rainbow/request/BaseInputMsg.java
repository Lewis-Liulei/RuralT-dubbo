package rt.lewis.rainbow.request;


import rt.lewis.common.annotation.Length;
import rt.lewis.common.annotation.NotEmpty;

import java.util.HashMap;
import java.util.Map;


public class BaseInputMsg implements InputMsg {
	
	private static final long serialVersionUID = -7979977598471880415L;

	/**调用方编号 */
	private String appID;
	/**调用方秘钥 */
	private String appSecret;
	/**ip地址 */
	private String clientIp;
	/**  app版本 */
	private String appversion;
	/**  设备类型 */
	@Length(min=1, max=1, message="错误的设备类型")
	private String system;
	/** 设备版本 */
	private String systemversion;
	/** 客户端版本 */
	private String clientVersion;
	/** 操作系统版本 */
	private String osVersion;
//	@NotEmpty(message="imei不能为空")
	private String imei;
	private String atoken;
	/** 请求URL */
	@NotEmpty(message="URL地址不能为空")
	private String url;
	/** 渠道类型 */
	private String channelType;
	/**  交易码 */
    private String transactionID;
    /**  设备号 */
    private String deviceId;
    /** 设备类型 */
    private String deviceType;
    private String lon;
	private String lat;
	private String position;
	private String tokenId;
	/**会话唯一编号*/
	private String sessionId;
	/**系统信息编号*/
	private String sysUuid;
	/**错误信息编号*/
	private String errorUuid;
	/**菜单信息编号*/
	private String menuUuid;
	
	private String did;
	/**
	 * 扩展字段
	 */
	private Map<String, Object> extendMap = new HashMap<String, Object>();
	
	/**
	 * 交易上下文
	 */
	//private ProcessContext processContext;
	/**nc南充社保sn遂宁社保*/
	private String cityType;

//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}

	@Override
	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Override
	public String getClientIp() {
		return clientIp;
	}

	@Override
	public void setClientIp(String clinetIp) {
		this.clientIp = clinetIp;
	}

	@Override
	public String getAppversion() {
		return appversion;
	}

	@Override
	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	@Override
	public String getSystemversion() {
		return systemversion;
	}

	@Override
	public void setSystemversion(String systemversion) {
		this.systemversion = systemversion;
	}

	@Override
	public String getImei() {
		return imei;
	}

	@Override
	public void setImei(String imei) {
		this.imei = imei;
	}

	@Override
	public String getAtoken() {
		return atoken;
	}

	@Override
	public void setAtoken(String atoken) {
		this.atoken = atoken;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Map<String, Object> getExtendMap() {
		return extendMap;
	}

	public void setExtendMap(Map<String, Object> extendMap) {
		this.extendMap = extendMap;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/*@Override
	public ProcessContext getProcessContext() {
		if (null == processContext) {
			processContext = new TransProcessContext();
		}
		return processContext;
	}

	public void setProcessContext(ProcessContext processContext) {
		this.processContext = processContext;
	}
	*/
	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}


	public String getSysUuid() {
		return sysUuid;
	}

	public void setSysUuid(String sysUuid) {
		this.sysUuid = sysUuid;
	}

	public String getErrorUuid() {
		return errorUuid;
	}

	public void setErrorUuid(String errorUuid) {
		this.errorUuid = errorUuid;
	}

	public String getMenuUuid() {
		return menuUuid;
	}

	public void setMenuUuid(String menuUuid) {
		this.menuUuid = menuUuid;
	}


	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "BaseInputMsg [appID=" + appID + ", appSecret=" + appSecret
				+ ", clientIp=" + clientIp + ", appversion=" + appversion
				+ ", system=" + system + ", systemversion=" + systemversion
				+ ", clientVersion=" + clientVersion + ", osVersion="
				+ osVersion + ", imei=" + imei + ", atoken=" + atoken
				+ ", url=" + url + ", channelType=" + channelType
				+ ", transactionID=" + transactionID + ", deviceId=" + deviceId
				+ ", deviceType=" + deviceType + ", lon=" + lon + ", lat="
				+ lat + ", position=" + position + ", tokenId=" + tokenId
				+ ", sessionId=" + sessionId + ", sysUuid=" + sysUuid
				+ ", errorUuid=" + errorUuid + ", menuUuid=" + menuUuid
				+ ", extendMap=" + extendMap + ", processContext="
				+ "processContext" + ", cityType=" + cityType + "]";
	}

}
