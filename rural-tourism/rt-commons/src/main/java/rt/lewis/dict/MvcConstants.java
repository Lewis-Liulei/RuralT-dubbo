package rt.lewis.dict;

public class MvcConstants {
	private MvcConstants() {
	}

	public static final String MVC_RETURN_TYPE_BUS = "bus";
	public static final String MVC_RETURN_TYPE_WS = "ws";
	public static final String MVC_RETURN_TYPE_BUS_DESCRIBE = "业务校验失败";
	public static final String MVC_RETURN_TYPE_SYS = "sys";
	public static final String MVC_RETURN_TYPE_SYS_DESCRIBE = "系统校验失败";
	public static final String MVC_RETURN_TYPE_VALID = "valid";
	public static final String MVC_RETURN_TYPE_VALID_DESCRIBE = "数据验证失败";
	public static final String MVC_RETURN_TYPE_INVALID_CKCODE_DESCRIBE = "参数校验失败";

	public static final String MVC_RETURN_TYPE_TIME_OUT = "timeout";
	public static final String MVC_RETURN_TYPE_REQ_REPEATED = "REQ_REPEATED";
	public static final String MVC_RETURN_NO_IMEI = "noImei";
	public static final String MVC_RETURN_TYPE_INVALID_ACCESS = "invalid access";
	public static final String MVC_RETURN_TYPE_INVALID_ACCESS_DESCRIBE = "非法访问！";
	public static final String MVC_RETURN_TYPE_REQ_REPEATED_DESCRIBE = "交易正在处理，请确认交易是否成功后再试";

	public static final String MVC_RETURN_RESULT_TOKENID = "tokenId";
	public static final String MVC_RETURN_RESULT_SUCCESS_CODE = "00";
	public static final String MVC_RETURN_RESULT_SUCCESS_MESSAGE = "SUCCESS";
	public static final String MVC_RETURN_RESULT_FAILD_CODE = "01";
	public static final String MVC_RETURN_LOGIN_PWD_ERROR = "loginError";
	public static final String MVC_RETURN_RESULT_FAILD_MESSAGE = "FAILD";
	public static final String MVC_RETURN_RESULT_FAILD_CHINESE_MESSAGE = "输入信息含有非法字符'%><";
	public static final String MVC_RETURN_RESULT_INVALID_CKCODE_MESSAGE = "网络异常，请稍后再试";
	public static final String MVC_RETURN_TYPE_BIND = "bind";
	public static final String MVC_RETURN_TYPE_BIND_DESCRIBE = "数据绑定失败";
	public static final String MVC_RETURN_TYPE_NOT_METHOD = "notMethod";
	public static final String MVC_RETURN_TYPE_NOT_METHOD_DESCRIBE = "访问资源失败";

	//4位数状态码,其中前两位为功能代码,后两位为状态代码
	//目前功能代码有01,02,03,分别代表登陆功能,注册功能,验证码功能
	//状态码00表示成功,01表示失败
	//0201表示注册失败
	public static final String MVC_RETURN_OVER_RIGHT = "overRight";
	public static final String MVC_RETURN_NOT_PANDA_FUND= "0801";
	public static final String MVC_RETURN_NOT_SAME_DEVICE = "0802";
	public static final String MVC_RETURN_LOGIN_SUCCESS_MESSAGE = "LOGIN SUCCESS";
	public static final String MVC_RETURN_LOGIN_FAILD_CODE = "0101";
	public static final String MVC_RETURN_LOGIN_OLD_ACCOUNT = "0102";
	public static final String MVC_RETURN_LOGIN_AC_ACCOUNT = "0103";
	public static final String MVC_RETURN_LOGIN_NO_ACCOUNT = "0104";
	public static final String MVC_RETURN_RESULT_NO_BILL = "0601";

	public static final String MVC_RETURN_REGISTER_SUCCESS_MESSAGE = "REGISTER SUCCESS";
	public static final String MVC_RETURN_REGISTER_FAILD_CODE = "0201";

	public static final String MVC_RETURN_VERIFE_FAILD_CODE = "0301";
	public static final String MVC_RETURN_RESET_PWD_FAILD_CODE = "0401";
	public static final String MVC_RETURN_UPDATE_USER_FAILD_CODE = "0501";

	public static final String MVC_RETURN_LOGOUT = "用户退出";
	public static final String MVC_RETURN_NO_PASSWORD = "密码为空,请输入密码";
	public static final String MVC_RETURN_SAME_PASSWORD = "两次密码输入不同,请重新确认密码";
	public static final String MVC_RETURN_RESET_PASSWORD_FAILD = "密码重置失败";
	public static final String MVC_RETURN_RESET_PASSWORD_TIMEOUT = "修改密码超时";
	public static final String MVC_RETURN_ERROR_PASSWORD = "密码错误";
	public static final String MVC_RETURN_RIGHT_PASSWORD = "密码正确";
	public static final String MVC_RETURN_ACCOUNT_LOCK = "帐号被锁定,请联系客服解锁";
	public static final String MVC_RETURN_ACCOUNT_ERROR = "手机号码输入不合法";
	public static final String MVC_RETURN_CREDIT_CARD_MOBILE_PHONE = "您的预留手机号码不符合规范";
	public static final String MVC_RETURN_CREDIT_CARD_MOBILE_PHONE_NUMBER = "您的预留手机号码为空";
	public static final String MVC_RETURN_ACCOUNT_NOT_EXISTS = "帐号不存在";
	public static final String MVC_RETURN_ACCOUNT_EXISTS = "手机号已被注册";
	public static final String MVC_RETURN_SPREAD_ERROR = "邀请人信息验证失败";
	public static final String MVC_RETURN_NO_VERIFE = "没有获取验证码或验证码已失效,请重新获取!";
	public static final String MVC_RETURN_ENTER_VERIFE = "请输入验证码";
	public static final String MVC_RETURN_VERIFE_ERROR = "验证码错误";
	public static final String MVC_RETURN_VERIFE_RIGHT = "验证码正确";
	public static final String MVC_RETURN_VERIFE_SUCCESS_SEND = "验证码发送成功";
	public static final String MVC_RETURN_VERIFE_FAILD_SEND = "验证码发送失败";
	public static final String MVC_RETURN_VERIFE_RESEND_DAY = "注册验证码次数已达当日上限,请24小时后再试!";
	public static final String MVC_RETURN_VERIFE_CERTIFICATION_TIMES = "实名认证验证码次数已达当日上限,请24小时后再试!";
	public static final String MVC_RETURN_VERIFE_RESEND_FAILD = "验证码获取失败,请不要频繁获取验证码";
	public static final String MVC_RETURN_UPDATE_USER_FAILD = "修改用户失败";
	public static final String MVC_RETURN_UPDATE_USER_SUCCESS = "修改用户成功";
	public static final String MVC_RETURN_INCALID_NIKENAME = "昵称不能超过5个中文或10个数字、英文组合";
	public static final String MVC_RETURN_INVALID_USER = "用户失效,请重新登录";
	public static final String MVC_RETURN_UPLOAD_SUCCESS = "图片上传成功";
	public static final String MVC_RETURN_SEARCH_USER_SUCCESS = "用户查找成功";
	public static final String MVC_RETURN_ADD_FRIEND_SUCCESS = "添加用户好友成功";
	public static final String MVC_RETURN_CHECK_INFO_SUCCESS = "实名认证成功";
	public static final String MVC_RETURN_CHECK_INFO_FAILED = "实名认证失败";
	public static final String MVC_RETURN_SET_PAY_PWD_SUCCESS = "设置支付密码成功";
	public static final String MVC_RETURN_NO_PWD_PAY_SUCCESS = "设置免密限额成功";
	public static final String MVC_RETURN_INVALID_AMOUNT = "免密限额不合法";
	public static final String MVC_RETURN_NO_PWD_PAY_FAILD = "设置免密限额失败";
	public static final String MVC_RETURN_QUERY_SUCCESS = "查询信息成功";
	public static final String MVC_RETURN_QUERY_FAILD = "查询信息失败";
	public static final String MVC_RETURN_SET_PAY_PLAN_SUCCESS = "设置存取计划成功";
	public static final String MVC_RETURN_DEL_PAY_PLAN_SUCCESS = "删除存取计划成功";
	public static final String MVC_RETURN_NO_CONFIRM_NAME = "请先进行实名认证";
	public static final String MVC_RETURN_CHECK_BILL = "系统正在日终清算,请稍候再试!";
	
	public static final String MVC_RETURN_USER_NO_LOGIN = "非法用户！";
	
	public static final String MVC_RETURN_NO_WALLET_PANDA = "没有熊猫宝帐户,请去就近营业厅开通此功能!";
	public static final String MVC_RETURN_NO_MONEY_CARD = "没有汇金卡,请去就近营业厅开通此功能!";
	public static final String MVC_RETURN_HAVE_MONEY_CARD = "有汇金卡";
	public static final String MVC_RETURN_WALLET_PANDA_INVALID = "熊猫宝帐户过期,请重新风险评估";
	
	public static final String MVC_RETURN_PARAM_ERROR = "系统参数不正确";
	public static final String MVC_RETURN_USER_ID_ERROR = "传入身份信息与实名认证身份信息不一致";
	//我的资产
	public static final String MVC_RETURN_QUERY_CUSTNO_APPENDED_CARDS_SUCCESS = "查询客户加挂卡信息成功";
	public static final String MVC_RETURN_QUERY_CUSTNO_APPENDED_CARDS_FAILED = "查询客户加挂卡信息失败";
	public static final String MVC_RETURN_QUERY_CUSTNO_NET_ASSETS_BY_SUBACCOUNT_SUCCESS = "查询客户净资产子户模式成功";
	public static final String MVC_RETURN_QUERY_CUSTNO_NET_ASSETS_BY_SUBACCOUNT_FAILED = "查询客户净资产子户模式失败";
	public static final String MVC_RETURN_QUERY_CUSTNO_NET_ASSETS_BY_ACCOUNT_SUCCESS = "查询客户净资产账户模式成功";
	public static final String MVC_RETURN_QUERY_CUSTNO_NET_ASSETS_BY_ACCOUNT_FAILED = "查询客户净资产账户模式失败";
	public static final String MVC_RETURN_ADD_APPENDED_CARDS_SUCCESS = "加挂账号成功";
	public static final String MVC_RETURN_ADD_APPENDED_CARDS_FAILED = "加挂账号失败";
	public static final String MVC_RETURN_QUERY_APPENDED_CARDS_SUCCESS = "获取已经加挂卡信息成功";
	public static final String MVC_RETURN_NO_APPENDED_CARDS_CURRENTLY = "目前还没有加挂卡";
	public static final String MVC_RETURN_QUERY_APPENDED_CARDS_FAILED = "获取已经加挂卡信息失败";
	public static final String MVC_RETURN_CARD_ALREADY_ADDED = "卡已经加挂";
	public static final String MVC_RETURN_CARD_NOT_BELONG_TO_CUST = "此卡不属于该客户";
	public static final String MVC_RETURN_IN_CARD_NOT_BELONG_TO_CUST = "收款账户不属于该客户";
	public static final String MVC_RETURN_OUT_CARD_NOT_BELONG_TO_CUST = "付款账户不属于该客户";
	public static final String MVC_RETURN_QUERY_SUBACCOUNT_DETAIL_SUCCESS = "查询子账号详细信息成功";
	public static final String MVC_RETURN_QUERY_SUBACCOUNT_DETAIL_FAILED = "查询子账号详细信息失败";
	public static final String MVC_RETURN_QUERY_LICAI_PRODUCT_DETAIL_SUCCESS = "获取理财产品详细信息成功";
	public static final String MVC_RETURN_QUERY_LICAI_PRODUCT_DETAIL_FAILED = "获取理财产品详细信息失败";
	public static final String MVC_RETURN_QUERY_CURRENT_TRANS_DETAIL_RECORD_ZERO = "没有活期交易明细";
	public static final String MVC_RETURN_QUERY_CURRENT_TRANS_DETAIL_SUCCESS = "查询活期交易明细成功";
	
	
	//柜面签约
	public static final String COUNTER_REGISTER_PHONE_FAILED = "01";
	public static final String COUNTER_REGISTER_PHONE = "账号已存在,处于待审核状态或已审核通过状态";
	public static final String COUNTER_REGISTER_CARD_FAILED = "02";
	public static final String COUNTER_REGISTER_CARD = "卡号已存在";
	public static final String COUNTER_REGISTER_MESSAGE_FAILED = "03";
	public static final String COUNTER_REGISTER_MESSAGE = "证件类型或证件号或姓名不匹配";
	public static final String COUNTER_REGISTER_REFEREENUM_FAILED = "04";
	public static final String COUNTER_REGISTER_REFEREENUM = "推荐人号码不存在";
	public static final String COUNTER_REGISTER_REFEREENUM_NOPASS_FAILED = "05";
	public static final String COUNTER_REGISTER_REFEREENUM_NOPASS = "推荐人没有通过实名认证";
	public static final String COUNTER_REGISTER_PHONENUM_VALIDATE_FAILED = "06";
	public static final String COUNTER_REGISTER_PHONENUM_VALIDATE = "手机号码不正确";
	public static final String COUNTER_REGISTER_USER_LOCK_FAILED = "07";
	public static final String COUNTER_REGISTER_USER_LOCK = "账户挂失状态，不能修改密码";
	public static final String COUNTER_REGISTER_USER_LOCK_FORGET = "账户挂失状态，不能忘记密码";
	public static final String COUNTER_REGISTER_PHONE_NO_FAILED = "08";
	public static final String COUNTER_REGISTER_PHONE_NO = "手机号码未注册";
	public static final String COUNTER_UPDATE_PWD_FAILED= "09";
	public static final String COUNTER_UPDATE_PWD_FAILED_MESSAGE = "旧密码不正确";
	public static final String COUNTER_UPDATE_PWD_NULL= "10";
	public static final String COUNTER_UPDATE_PWD_NULL_MESSAGE = "密码不能为空";
	public static final String COUNTER_UPDATE_VERIFICATION_CODE_NULL= "11";
	public static final String COUNTER_UPDATE_VERIFICATION_CODE_NULL_MESSAGE = "验证码不能为空";
	public static final String COUNTER_UPDATE_USER_INFO_FAILED= "12";
	public static final String COUNTER_UPDATE_USER_INFO_MESSAGE = "手机号，身份证号，卡号不匹配，请检查";
	public static final String COUNTER_REGISTER_TYPE_FAILED= "13";
	public static final String COUNTER_REGISTER_TYPE_FAILED_MESSAGE = "type参数错误";
	public static final String COUNTER_REGISTER_IDNO_FAILED = "14";
	public static final String COUNTER_REGISTER_IDNO = "该身份证信息已经处于待审核状态或已审核通过状态";
	
	public static final String UNIFORM_ERROR_MESSAGE = "服务器繁忙请稍候再试!";

	//手势密码
	public static final String HAND_PWD_SET_ERROR = "hp_01";
	public static final String HAND_PWD_SET_ERROR_MSG = "设置手势密码失败";
	public static final String HAND_PWD_USER_NULL = "hp_02";
	public static final String HAND_PWD_USER_NULL_MSG = "设置手势密码需要先登录";
	public static final String HAND_PWD_USER_ACCOUNT_NULL = "hp_03";
	public static final String HAND_PWD_USER_ACCOUNT_NULL_MSG = "未找到用户信息";
	public static final String HAND_PWD_USER_LOGIN_ERROR = "hp_04";
	public static final String HAND_PWD_USER_LOGIN_ERROR_MSG = "手势密码登录失败";
	public static final String HAND_PWD_USER_LOGIN_ERROR_TIME = "hp_05";
	public static final String HAND_PWD_USER_LOGIN_ERROR_TIME_MSG = "手势密码登录超过次数限制";
	public static final String FACE_USER_LOGIN_ERROR = "fu_01";
	public static final String FACE_USER_LOGIN_ERROR_TIME_MSG = "刷脸登录失败";
	
	//转账计划错误配置
	public static final String MVC_RETURN_TRANS_PLAN_FAILED = "tp_01";
	public static final String MVC_RETURN_TRANS_PLAN_FAILED_MESSAGE = "余额不足";
	
	//活动配置
	public static final String ACTIVITY_NULL = "ah_01";
	public static final String ACTIVITY_NULL_MSG = "当前没有可执行的活动"; 
	
	public static final String ACTIVITY_SHOW = "ah_02";
	public static final String ACTIVITY_SHOW_MSG = "当天已经获取过活动展示"; 
	
	public static final String ACTIVITY_HAND_SHOW = "ah_03";
	public static final String ACTIVITY_HAND_SHOW_MSG = "当天应该展示手势设置";

	public static final String DELETE_USER_NULL = "udel_01";
	public static final String DELETE_USER_NULL_MSG = "用户失效,请重新登录";

	public static final String DELETE_USER_NOT_EXIT = "udel_02";
	public static final String DELETE_USER_NOT_EXIT_MSG = "用户不存在";

	public static final String DELETE_SYS_CERTIFICATION_FAIL = "udel_03";
	public static final String DELETE_SYS_CERTIFICATION_FAIL_MSG = "清除实名认证信息失败";

    public static final String DELETE_SYS_CUSTOMER_DATA_FAIL = "udel_04";
	public static final String DELETE_SYS_CUSTOMER_DATA_FAIL_MSG = "清除客户信息失败";

    public static final String DELETE_SYS_USER_INFO_FAIL = "udel_05";
    public static final String DELETE_SYS_USER_INFO_FAIL_MSG = "清除用户数据失败";

    public static final String DELETE_WALLET_ACCOUNT_FAIL = "udel_06";
    public static final String DELETE_WALLET_ACCOUNT_FAIL_MSG = "清除钱包数据失败";

    public static final String DELETE_USER_DEVICE_FAIL = "udel_07";
    public static final String DELETE_USER_DEVICE_FAIL_MSG = "清除设备信息失败";

    public static final String DELETE_P_TASK_DETAIL_FAIL = "udel_08";
    public static final String DELETE_P_TASK_DETAIL_FAIL_MSG = "清除存取计划失败";

    public static final String DELETE_WALLET_FRIEND_FAIL = "udel_09";
    public static final String DELETE_WALLET_FRIEND_FAIL_MSG = "清除好友关系失败";

    public static final String DELETE_LOGIN_AUDIT_FAIL = "udel_10";
    public static final String DELETE_LOGIN_AUDIT_FAIL_MSG = "清除登录信息失败";

    public static final String DELETE_SYS_USER_SPREAD_FAIL = "udel_11";
    public static final String DELETE_SYS_USER_SPREAD_FAIL_MSG = "清除邀请信息失败";

    public static final String DELETE_SPREAD_ORDER_FAIL = "udel_12";
    public static final String DELETE_SPREAD_ORDER_FAIL_MSG = "清除客户预约信息失败";

    public static final String DELETE_MESSAGE_FAIL = "udel_13";
    public static final String DELETE_MESSAGE_FAIL_MSG = "清除群消息状态失败";

    public static final String DELETE_NEW_USER_TASK_FAIL = "udel_14";
    public static final String DELETE_NEW_USER_TASK_FAIL_MSG = "清除新手任务失败";

    public static final String DELETE_BACKGROUND_MANAGE_FAIL = "udel_15";
    public static final String DELETE_BACKGROUND_MANAGE_FAIL_MSG = "清除后管配置失败";
    
    public static final String MVC_RETURN_RESULT_TIMEOUT_CODE = "02";
    
}
 
