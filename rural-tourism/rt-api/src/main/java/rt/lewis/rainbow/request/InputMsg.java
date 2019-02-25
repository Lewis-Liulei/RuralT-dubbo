package rt.lewis.rainbow.request;

public interface InputMsg extends InputContext {
	public String getTokenId();

	public String getClientIp();

	public void setClientIp(String clinetIp);

	public String getAppversion();

	public void setAppversion(String appversion);

	public String getSystemversion();

	public void setSystemversion(String systemversion);

	public String getImei();

	public void setImei(String imei);

	public String getAtoken();

	public void setAtoken(String atoken);
	
	public String getDid();
}
