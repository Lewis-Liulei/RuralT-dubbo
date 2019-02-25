package rt.lewis.api.common;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/4/14
 * Time: 5:18 PM
 */
public interface Constant {

    String LOG_ID_PRO = "wangyin.log.id";

    String LOG_ID_DEF = "ServiceId";

    String LOG_ID_KEY = System.getProperty(LOG_ID_PRO, LOG_ID_DEF);

    String CHARSET = "UTF-8";

    /**
     * 唯一消息ID key
     */
    String UUID = "UUID";

    /**
     * 系统名称
     */
    String SERVICE_NAME = "API";

    String CHARSET_KEY = "charset";
    /**
     * requestUri for config
     */

    String REQ_URI = "request_uri";

    String REMOTE_ADDR = "Remote_Addr";

    String PROTOCOL_KEY = "Protocol_key";

    String METHOD_KEY = "Method_key";

    String MESSAGE_TPYE_KEY = "Message_type_key";

    String FLAG_FAIL = "N";
    String FLAG_SUCCESS = "Y";
    String IS_SUCCESS = "is_success";


    /**
     * 数据报文格式JSON、XML、URL
     */
    String FORMART_TYPE_JSON = "JSON";
    String FORMART_TYPE_XML = "XML";
    String FORMART_TYPE_URL = "URL";

    /**
     * URL方式分隔符号&
     */
    String URL_SPLIT = "&";
    /**
     * URL 键值对 连接符号=
     */
    String URL_LINK = "=";

    /**
     * 一天的分钟数
     */
    long ONE_DAY_MIN = 1 * 24 * 60;
    /**
     * 一分钟的毫秒数
     */
    long ONE_MIN_MS = 1000 * 60;
    /**
     * 七天的分钟数
     */
    long SEVEN_DAY_MIN = 7 * ONE_DAY_MIN;

    /**
     * 关键字段名称 客户号、商户号、签名类型
     */
    String CUSTOMER_NO = "customer_no";
    String SIGN_TYPE = "sign_type";
    String SIGN_DATA = "sign_data";
    /**
     * 收银台签名算法
     */
    String CASHIER_SIGN = "SHA1";

    /**
     * 风控字段前缀
     */
    String RISK_PREFIX = "add_";

    String RESPONSE_CODE = "response_code";
    String RESPONSE_MESSAGE = "response_message";


    String NPP_SEC_KEY = "GLOBAL";

    /**
     * API 异常编码
     */
    /**
     * 不支持的安全类型
     */
    String NON_SUPPORT_SECURITY = SERVICE_NAME + "0000001";
    /**
     * 报文签名验证失败
     */
    String SIGN_VALIDATE = SERVICE_NAME + "0000002";
    /**
     * 安全验证失败
     */
    String SECURITY_VALIDATE = SERVICE_NAME + "0000003";
    /**
     * 字符集不正确
     */
    String CHARSET_ILLEGAL = SERVICE_NAME + "0000004";
    /**
     * 错误的数据格式,不能解析
     */
    String DATA_FORMAT_ILLEGAL = SERVICE_NAME + "0000005";
    /**
     * 提交的参数有误
     */
    String FIELD_ILLEGAL = SERVICE_NAME + "0000006";

    /**
     * 商户获取密钥或签名称失败
     */
    String GET_SECRET_KEY_FAIL = SERVICE_NAME + "0000008";


    /**
     * 处理中
     */
    String PROCESSING_ERROR = "00001";

    /**
     * 未知错误
     */
    String UNKNOWN_ERROR = "00002";
    /**
     * 网络超时
     */
    String TIMEOUT_ERROR = "00003";


    String SEC_KEY = "SEC_KEY";
    String SALT_KEY = "SALT_KEY";
    /**
     * access log
     */
    String SERVICE_START_TIME = "service.start.time";

    String UNSUPPORTED_FUNCODE = "UNSUPPORTED_FUNCODE";

    String ERROR_CODE = "error_code";
    String ERROR_DESC = "error_desc";
    /**
     * 日期格式
     */
    String YYYYMMDD_T_HHMMSS = "yyyyMMdd-HHmmss";

    String REQUEST_DATETIME = "request_datetime";
    String FILE_DATE = "file_date";
    String OUT_TRADE_DATE = "out_trade_date";
    String ORIGINAL_OUT_TRADE_DATE = "original_out_trade_date";
    String RESPONSE_DATETIME = "response_datetime";
    String OUT_TRADE_NO = "out_trade_no";
    String ORIGINAL_OUT_TRADE_NO = "original_out_trade_no";
    String REFUND_AMOUNT = "refund_amount";
    String REFUND_REASON = "refund_reason";
    String RETURN_URL = "return_url";
    String RETURN_PARAMS = "return_params";
    String EXTEND_PARAMS = "extend_params";
    String ORIGINAL_TRADE_DATE = "original_trade_date";
    String BIZ_TRADE_NO = "biz_trade_no";
    String TRADE_AMOUNT = "trade_amount";
    String TOTAL_AMOUNT = "total_amount";
    String TOTAL_COUNT = "total_count";
    String TRADE_CURRENCY = "trade_currency";
    String NOTIFY_URL = "notify_url";
    String REQUEST_TIME = "request_time";
    String OUT_TRADE_DATETIME = "out_trade_datetime";
    String WY_TRADE_DATETIME = "wy_trade_datetime";
}
