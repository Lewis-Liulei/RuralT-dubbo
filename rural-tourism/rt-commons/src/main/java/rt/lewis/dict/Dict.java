package rt.lewis.dict;

public class Dict {
	/** 返回结果 */
	public static final String RESULT = "result";
	/** 客户号 */
	public static final String CIF_SEQ = "cifSeq";
	/** 客户号-EDI0059 */
	public static final String CUST_NO = "custNo";
	/** 客户号 */
	public static final String CIF_NAME = "CifName";
	/** 定期资产 */
	public static final String TIME_BALANCE = "timeTotal";
	/** 活期资产 */
	public static final String SAVE_BALANCE = "saveTotal";
	/** 理财资产 */
	public static final String FINANCICAL_BALANCE = "financicalTotal";
	/** 基金资产 */
	public static final String FUND_BALANCE = "fundTotal";
	/** 卡列表 */
	public static final String CARD_LIST = "cardList";
	/** 账户子账户列表 */
	public static final String SUB_ACC_LIST = "subAccList";

	public static final String REGULAR_LIST = "regularList";

	public static final String MTL_GOLE_LIST = "mtlGoleList";
	public static final String MTL_PRICE_LIST = "mtlPriceList";
	/** 当前页查询回数据的条数 */
	public static final String CUURENT_COUNT = "currCount";
	/** 凭证类型 */
	public static final String BANK_AC_TYPE = "bankAcType";
	/** 凭证账户类型 */
	public static final String DCMTFS = "dcmtfs";
	/** 储种 */
	public static final String DEBT_TYPE = "debtType";
	/** 银行卡号 */
	public static final String AC_NO = "acNo";
	/** 外围系统交易流水号 */
	public static final String MDTRSQ = "mdtrsq";
	/** 卡原密码 */
	public static final String CARD_OLD_PASSWORD = "oldPassword";
	/** 卡新密码 */
	public static final String CARD_NEW_PASSWORD = "newPassword";
	/** 银行卡号列表 */
	public static final String AC_NOS = "acNos";
	/** 原来绑定的一类账户账号 */
	public static final String ORIGINAL_BUND_CARD_NUMBER = "originalBundCardNumber";
	/** 新绑定的一类账户账号 */
	public static final String NEW_BUND_CARD_NUMBER = "newBundCardNumber";
	/** 绑定的一类账户本行卡外行卡标志 0--行外账户 1--行内账户 2--会员卡 */
	public static final String SELF_OR_OTHER_BANK_FLAG = "selfOrOtherBankFlag";
	/** 绑定一类账户账号 */
	public static final String BUND_CARD_NUMBER = "bundCardNumber";
	/** 绑定一类账户机构号 */
	public static final String BUND_CARD_OPEN_BRANCH_NO = "bundCardOpenBranchNo";
	/** 绑定一类账户机构名称 */
	public static final String BUND_CARD_OPEN_BRANCH_NAME = "bundCardOpenBranchName";
	/** 绑定的一类账户外行卡标志 0 */
	public static final String OTHER_BANK_FLAG = "0";
	/** 绑定的一类账户本行卡标志 1 */
	public static final String SELF_BANK_FLAG = "1";
	/** 绑定的一类账户会员卡标志 2 */
	public static final String VIP_CARD_FLAG = "2";
	/** 户名 */
	public static final String AC_NAME = "acName";
	/** 产品代码 */
	public static final String PRD_CODE = "prdCode";
	/** 附属卡类型 */
	public static final String VIR_CARD_TYPE = "virCardType";
	/** 子账号序号 */
	public static final String SUB_AC_SEQ = "subAcSeq";
	/** 子账号 */
	public static final String SUB_AC_NO = "subAcNo";
	/** 账号序号 */
	public static final String AC_ORDER = "acOrder";
	/** 账号状态 */
	public static final String AC_STATE = "acState";
	/** 钱包密码 */
	public static final String WALLET_PASSWORD = "walletPassword";
	/** 动态口令 */
	public static final String DYNAMIC_PASSWORD = "dynamicPassword";
	/** 声音对比 */
	public static final String SOUND_CONTRAST = "soundContrast";
	/** 人工电话 */
	public static final String MANUAL_TELEPHONE = "manualTelephone";

	public static final String AUTHENTICATION = "authentication";

	/** 转出钱包用户号 **/
	public static final String PAYER_USER_ACCOUNT = "payerUserAccount";
	/** 转出钱包用户OID **/
	public static final String PAYER_USER_INFO_ID = "payerUserInfoId";
	/** 转入钱包用户号 **/
	public static final String PAYEE_USER_ACCOUNT = "payeeUserAccount";
	/** 转入钱包用户OID **/
	public static final String PAYEE_USER_INFO_ID = "payeeUserInfoId";

	public static final String AUTHENTICATION_KEY = "authenticationKey";

	public static final String USER_PASSWORD = "password";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String CHECK_CHANNEL = "checkChannel";
	public static final String OLD_USER_CARD_LIST = "oldUserCardList";

	public static final String PASSWORD_BORDKEY = "bordKey";

	/** 红包专用熊猫钱包过渡户系统参数配置类型 **/
	public static final String RED_ENVEL_INNER_ACCOUNT_CONFIG_TYPE = "RedEnvel";

	/** 红包专用熊猫钱包过渡户系统参数配置名 **/
	public static final String RED_ENVEL_INNER_ACCOUNT_CONFIG_NAME = "RedEnvelInnerWalletUserAccount";

	/** 发红包公共资金管理帐户系统参数配置名 **/
	public static final String ENVEL_COMMON_SEND_WALLET_ACCOUNT_CONFIG_NAME = "777envelSendWalletmgrAccount";

	/** 钱包调帐专用帐户系统参数配置名 **/
	public static final String WALLET_COMMON_FILLINGMONEY_ACCOUNT_CONFIG_NAME = "WalletCommonFillingMoneyAccount";

	/** 钱包调帐专用帐户系统参数配置名 **/
	public static final String WALLET_COMMON_MOREMONEY_ACCOUNT_CONFIG_NAME = "WalletCommonMoreMoneyAccount";

	/** 流水号jnlNo **/
	public static final String JNLNO = "jnlNo";
	/** 交易时间transTime **/
	public static final String TRANS_TIME = "transTime";
	/** 主机交易日期 **/
	public static final String TRAN_DT = "trandt";
	/** tokenId **/
	public static final String TOKEN_ID = "tokenId";
	/** 金额amount **/
	public static final String AMOUNT = "amount";
	/** 余额 **/
	public static final String BALANCE = "balance";
	/** 付款人账号 payerAccountNo **/
	public static final String PAYER_ACCOUNT_NO = "payerAccountNo";
	/** 付款人户名 payerName **/
	public static final String PAYER_NAME = "payerName";
	/** 收款人账号 payeeAccountNo **/
	public static final String PAYEE_ACCOUNT_NO = "payeeAccountNo";
	/** 收款人户名 payeeName **/
	public static final String PAYEE_NAME = "payeeName";
	/** 说明 remark **/
	public static final String REMARK = "remark";
	/** 币种 currency **/
	public static final String CURRENCY = "currency";
	/** 费用 fee **/
	public static final String FEE = "fee";
	/** 收款人行号 **/
	public static final String PAYEE_BACK = "payeeBank";
	/** 购买商品ID **/
	public static final String GOODS_ID = "goodsId";
	/** 交易经度 **/
	public static final String TRANS_LON = "transLon";
	/** 交易纬度 **/
	public static final String TRANS_LAT = "transLat";
	/** 交易位置 **/
	public static final String TRANS_POSITION = "transPosition";
	/** 用户选择的支付方式， 从卡支付 */
	public static final String MODE_OF_PAYMENT_CARD = "card";
	/** 用户选择的支付方式， 从钱包支付 */
	public static final String MODE_OF_PAYMENT_WALLET = "wallet";

	// 交易动作，审核状态：待审核
	// wait_review，审核中in_review，审核拒绝reject_review，审核通过pass_review。非必填
	/** 待审核 wait_review **/
	public static final String TRSSTATE_WAIT = "wait_review";
	/** 审核中in_review **/
	public static final String TRSSTATE_IN = "in_review";
	/** 审核拒绝reject_review **/
	public static final String TRSSTATE_REJECT = "reject_review";
	/** 审核通过pass_review **/
	public static final String TRSSTATE_PASS = "pass_review";

	public static final String FAILURE = "FAILURE";
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE_NAME = "失败";
	public static final String SUCCESS_NAME = "成功";

	public static final String RETURN_CODE_SUCCESS = "200";
	public static final String RETURN_MSG_SUCCESS = "SUCCESS";
	public static final String MOBILE_SYS_MESSAGE = "mobileSysMessage";
	public static final String ALL_TITLE = "allTitle";
	public static final String ALL_CONTENT = "allContent";
	public static final String ALL_SHOW_DATE = "allShowDate";
	public static final String ALL_SHOW_TIME = "allShowTime";
	public static final String ALL_AVAILABLE = "allAvailable";
	public static final String ALL_GO_NEXT = "allGoNext";
	public static final String SYS_MESSAGE = "sysMessage";
	public static final String CLIENT_IP = "clientIp";
	public static final String APP_VERSION = "appversion";
	public static final String SYSTEM = "system";
	public static final String SYSTEM_VERSION = "systemversion";
	public static final String IMEI = "imei";
	public static final String ATOKEN = "ATOKEN";
	public static final String REPAY_AMOUNT = "repay_amount";
	public static final String walletToOtherUser_BeforeBalance = "walletToOtherUserBeforeBalance";
	public static final String walletToOtherUser_AfterBalance = "walletToOtherUserAfterBalance";
	public static final String otherUserToWallet_BeforeBalance = "otherUserToWalletBeforeBalance";
	public static final String otherUserToWallet_AfterBalance = "otherUserToWalletAfterBalance";

	public static final String INVOKE_APP_ID = "appID";
	public static final String INVOKE_APP_SECRET = "appSecret";

	/** 加挂他行卡 **/
	public static final String ACCOUNT_NUMBER = "accountNumber";
	public static final String ACCOUNT_NAME = "accountName";
	public static final String ID_TYPE = "identificationType";
	public static final String ID_TYPE_VALUE = "109010001";
	public static final String ID_NO = "identificationNumber";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String CARD_TYPE = "cardType";
	public static final String CARD_TYPE_VALUE = "10";

	/** 他转本 **/
	public static final String USAGE = "usage";
	public static final String USAGE_VALUE = "他转本";
	public static final String ACCEPTER_ACC_NO = "accepterAccno";
	public static final String ACCOUNT_TYPE = "accountType";
	public static final String ACCOUNT_TYPE_VALUE = "11";
	public static final String ACCEPTER_ACC_NAME = "accepterAccname";

	/** 远程开户 **/
	public static final String OPENCARD_ID_NO = "IdNo";
	public static final String PHONE_NO = "PhoneNo";
	public static final String CHANNEL_SN = "ChannelSN";
	public static final String REQ_DT = "ReqDT";
	public static final String TELLER_ID = "TellerID";
	public static final String BRANCH = "Branch";
	public static final String REQ_TM = "ReqTM";
	public static final String CHANNEL_NO = "ChannelNo";
	public static final String HOST_TRANS_CODE = "hostTransCode";
	public static final String PWD = "Pwd";
	public static final String PER_AC_TYPE = "PerAcType";
	public static final String BIND_AC_NO = "BindAcNo";
	public static final String INNER_TYPE = "InnerType";
	public static final String NETWORKCHECKIND = "networkCheckInd";
	public static final String IDTYPE = "IdType";

	/** 验证南充市商业银行银行卡密码 **/
	public static final String CARD_NUMBER = "cardNumber";
	public static final String CHECK_TYPE = "checkType";
	public static final String CHECK_TYPE_VALUE = "1";
	public static final String PASSWORD = "password";

	/** 获取银行卡信息 **/
	public static final String BANK_CARD_NAME = "acName";
	public static final String BANK_CARD_INFO_ID_NO = "idNo";
	public static final String BANK_CARD_INFO_CIFSEQ = "cifSeq";
	public static final String BANK_CARD_INFO_CIFNAME = "cifName";

	public static final String DCMTFS_CZ = "R35001002";

	public static final String BANK_CARD_TYPE_1 = "1";
	public static final String BANK_CARD_TYPE_2 = "2";
	public static final String BANK_CARD_TYPE_3 = "3";
	public static final String BANK_CARD_TYPE = "sortType";
	public static final String BANK_CARD_ACALIAS = "acAlias";
	public static final String PAGE_SIZE = "pageSize";
	public static final String BEGIN_PAGE = "beginPage";
	public static final String DEFAULT_PAGE_SIZE = "20";
	public static final String DEFAULT_BEGIN_PAGE = "1";
	public static final String ACCOUNT_DETAIL_LIST = "accountDetailList";
	public static final String BUNDED_1_ACCOUNT = "primaryAcNo";
	public static final String IS_SELF_BANK_CARD = "isSelfBankCard";
	public static final String ZHONG_JIN_VERIFY = "zhongjinVerify";
	public static final String BUND_SERVTP = "servtp";
	public static final String BUND_SERVTP_MBL = "MBL";
	public static final String IS_ADDED = "isAdded";
	public static final String OTHER_CARD_BRACH_INFO_B = "OTHER_CARD_BRACH_INFO";
	public static final String OTHER_CARD_BRACH_INFO_S = "otherCardBrachInfo";
	public static final String VERIFICATION_CODE = "verification_code";
	public static final String CHANGE_BUND_SHORT_MSG = "changeBundAccountShortMsg";
	public static final String SELF_BANK_CARD_BIN = "selfBankCardBin";
	public static final String SELF_BANK_CARD_BIN_CONFIG = "selfBankCardBinConfig";
	public static final String SELF_CLOUND_CARD_BIN_CONFIG = "selfCloundCardBinConfig";
	public static final String DOC_ID = "docid";
	public static final String AUDIT_IN_PROGRESS = "1";
	public static final String AUDIT_SUCCESS = "2";
	public static final String AUDIT_FAILURE = "3";
	public static final String CHANGE_BUND_ACCOUNT_AUDIT_RESULT_Y = "Y";
	public static final String CHANGE_BUND_ACCOUNT_AUDIT_RESULT_N = "N";
	public static final String TASK_ID = "taskId";
	/** 作为服务方时的返回码 */
	public static final String RETURN_CODE_SVR = "code";
	/** 作为服务方时的返回消息 */
	public static final String RETURN_MSG_SVR = "message";

	/** provider-servicebus发送消息 */
	public static final String FROM_USER_ACCOUNT = "SYSTEM";
	public static final String TO_CHANNEL = "1";
	public static final String MESSAGE_TYPE = "901";
	public static final String TEMPLATE_CODE = "500001";
	public static final String AUDIT_RESULT_SUCCESS = "成功";
	public static final String AUDIT_RESULT_FAILURE = "失败 ";
	public static final String RESULT_DESC = ", 失败原因是:  ";
	public static final String ACNO2_KEY = "acNo2";
	public static final String AUDIT_RESULT_KEY = "auditResult";
	public static final String RECEIVE_SUCCESS_PROCESS_BANK_CALL_CODE = "00";
	public static final String IS_PAYMENT_Y = "Y";
	public static final String IS_PAYMENT_N = "N";
	public static final String IS_PRIMARY_Y = "Y";
	public static final String IS_PRIMARY_N = "N";
	public static final String MOBILE_PHONE = "mobilePhone";
	public static final String CHECK_PWD_RESULT_FOR_ADD_ACCOUNT = "checkPwdResultForAddAccount";
	public static final String GET_REMAIN_MOBILE_PHONE_FOR_ADDCOUNT = "getRemainMobilePhoneForAddAccount";
	public static final String UNDER_SCORE = "_";
	public static final String WHITE_USER_INFO_TYPE = "1";
	public static final String WHITE_USER_INFO_KEY = "isWhiteUserInfo";
	/** 春节红包上账流水transCode **/
	public static final String SPRING_RED_ENVEL_JNL_CODE = "springRedEnvel";
	/** 春节抽奖红包管理账户系统参数配置名 **/
	public static final String RED_ENVEL_SPRING_ACCOUNT_CONFIG_NAME = "RedEnvelSpringWalletmgrAccount";

	/** 酒店常量定义 **/
	public static final String HOTEL_GROUP_CODE = "hotelGroupCode"; // 酒店集团码
	public static final String MANAGEMENT_CODE = "managementCode"; // 酒店集团码
	public static final String SRCHOTELGROUP_CODE = "srcHotelGroupCode"; // 酒店集团码
	public static final String CLIENT_CHANNEL = "clientChannel"; // 酒店集团码
	public static final String HOTEL_CODE = "hotelCode";
	public static final String HOTEL_GC_RSV_NO = "gcRsvNo";
	public static final String HOTEL_GCRSVNOS = "gcRsvNos";
	public static final String HOTEL_TA_NO = "taNo";
	public static final String HOTEL_PAY_CODE = "payCode";
	public static final String HOTEL_MONEY = "money";
	public static final String HOTEL_REMARK = "remark";
	public static final String OTA_CHANNEL = "otaChannel";
	public static final String OTA_CHANNEL_APP = "web";
	public static final String HOTEL_PAY_STATUS = "paySta";
	public static final String TRANMD = "tranmd";
	public static final String TRANMD_IMMEDIATELY = "T36001001";
	public static final String TRANMD_24H_LATER = "T36001003";
	public static final String HOTEL_PAY_WAY = "hotelPayWay";
	public static final String HOTEL_REFUND_WAY = "hotelRefundWay";
	public static final String HOTE_ORDER_STATUS = "sta";
	public static final String HOTE_ORDER_STATUS_R = "R";
	public static final String HOTEL_PAY_STATUS_2 = "2";
	public static final String HOTEL_FROM_DATE = "fromDate";
	public static final String HOTEL_TO_DATE = "toDate";
	public static final String HOTEL_CITY_CODE = "cityCode";
	public static final String HOTEL_HOTELKEYWORDS = "hotelKeyWords";
	public static final String HOTEL_FIRSTRESULT = "firstResult";
	public static final String HOTEL_PAGESIZE = "pageSize";
	public static final String HOTEL_SHOWTYPE = "showType";
	public static final String HOTEL_HOTELCODES = "hotelCodes";
	public static final String HOTEL_HOTELCODE = "hotelCode";
	public static final String HOTEL_RESULTCODE = "resultCode";
	public static final String HOTEL_RESULTINFOS = "resultInfos";
	public static final String HOTEL_RESULTINFO = "resultInfo";
	public static final String HOTEL_RETURNCODE_FAIL = "0";
	public static final String HOTEL_RETURNCODE = "returnCode";
	public static final String HOTEL_PRODUCTROOMLIST = "productRoomList";
	public static final String HOTEL_GCPRODUCTBASES = "gcProductBases";
	public static final String HOTEL_ISFULL = "isFull";
	public static final String HOTEL_GCROOMEXTRA = "gcRoomExtra";
	public static final String HOTEL_MEMBERPRICEDTOS = "memberPriceDtos";
	public static final String HOTEL_MEMBERPRICEDTO = "memberPriceDto";
	public static final String HOTEL_MEMBERLEVEL = "memberLevel";
	// 普通会员
	public static final String HOTEL_MEMBERLEVEL_000 = "000";
	public static final String HOTEL_MEMBERLEVEL_001 = "001";
	public static final String HOTEL_MEMBERLEVEL_002 = "002";
	public static final String HOTEL_LOGO = "logo";
	public static final String HOTEL_PICTURES = "pictures";
	public static final String HOTEL_BEDTYPE = "bedType";
	public static final String HOTEL_AVLPRODUCTS = "avlProducts";
	public static final String HOTEL_ISBOOKABLE = "isBookAble";
	public static final String HOTEL_ISBOOKABLE_FALSE = "1";
	public static final String HOTEL_MESSAGE = "message";
	public static final String HOTEL_RATESUM = "rateSum";
	public static final String HOTEL_EVERYDAYDETAILS = "everyDayDetails";
	public static final String HOTEL_ISDELETE_NO = "0";
	public static final String HOTEL_ISDELETE_YES = "1";
	public static final String HOTEL_ISREFUND_NO = "0";
	public static final String HOTEL_ISREFUND_YES = "1";
	public static final String HOTEL_USERSEQ = "userSeq";
	public static final String HOTEL_OPERATIONTYPE = "operationType";
	public static final String HOTEL_OPERATIONTYPE_CANCEL = "Cancel";
	public static final String HOTEL_OPERATIONTYPE_CHECKAVL = "CheckAvl";
	public static final String HOTEL_OPERATIONTYPE_BOOK = "Book";
	public static final String HOTEL_PRODUCTCODE = "productCode";
	public static final String HOTEL_ARR = "arr";
	public static final String HOTEL_DEP = "dep";
	public static final String HOTEL_PERSONNUM = "personNum";
	public static final String HOTEL_RMNUM = "rmNum";
	public static final String HOTEL_CHECKPRODUCTINFORQ = "checkProductInfoRQ";
	public static final String HOTEL_PAYSTA = "paySta";
	public static final String HOTEL_PAYSTA_PAYED = "2";
	public static final String HOTEL_STA = "sta";
	public static final String HOTEL_STA_BOOK = "R";
	public static final String HOTEL = "Hotel";
	public static final String HOTEL_GC_ACCOUNT = "gcHotelAccount";
	public static final String HOTEL_GC_ACCOUNT_NAME = "gcHotelAccountName";
	public static final String HOTEL_GC_TRANSFER_TYPE = "gcHotelTransferType";
	public static final String HOTEL_PAYEE_ACCOUNT_NO = "payeeAccountNo";
	public static final String HOTEL_PAYEE_NAME = "payeeName";
	public static final String HOTEL_PAYER_ACCOUNT_NO = "payerAccountNo";
	public static final String HOTEL_PAYER_NAME = "payerName";
	public static final String HOTEL_JNLNO = "jnlno";
	public static final String HOTEL_AMOUNT = "amount";
	// 酒店发票
	public static final String HOTEL_INVOICETITLE = "invoiceTitle";
	public static final String HOTEL_RECEIVERNAME = "receiverName";
	public static final String HOTEL_RECEIVERADDRESS = "receiverAddress";
	public static final String HOTEL_RECEIVERMOBILE = "receiverMobile";
	public static final String HOTEL_WANTTIME = "wantTime";
	public static final String HOTEL_PAYED_ORDER = "hotelPayedOrder";
	public static final String HOTEL_CANCEL_ORDER_FUN_ON = "Y";
	public static final String HOTEL_CANCEL_ORDER_FUN_ON_OFF = "hotelCancelOrderFunOnOff";
	public static final String HOTEL_CANCEL_PAY_RESULT_CODE = "hotelCancelPayResultCode";
	public static final String HOTEL_ORDER_ID = "hotelOrderId";
	public static final String HOTEL_REFUND_SUCC_MSG = "hotelRefundSuccMsg";
	public static final String HOTEL_TRANS_SQ = "transq";
	public static final String HOTEL_TRANS_JNLNO = "jnlno";

	/** 景点门票常量定义 **/
	public static final String GET_SCENERIES = "GetSceneries";
	public static final String GET_TICKETS = "GetTickets";
	public static final String GET_TICKET_RESERVE_DATE = "GetTicketCanReserveDate";
	public static final String CREATE_ORDER = "GreateOrder";
	public static final String ORDER_TO_PAY = "OrderToPay";
	public static final String CANCEL_ORDER = "CancelOrder";
	public static final String GET_ORDER_STATUS = "GetOrderStatus";

	/** 生活缴费常量定义 **/
	public static final String TRANS_DATE = "tranDate";
	public static final String TRANS_TYPE = "transType";
	public static final String CUSTOMER_NO = "customerNo";
	public static final String UNIT_NO = "unitNo";
	public static final String MID_ITEM = "midItem";
	public static final String BUSS_CODE = "bussCode";
	public static final String ORDER_ID = "orderId";
	public static final String INFO = "info";
	public static final String SERIAL_NO = "serialno";
	public static final String OLD_SERIAL_NO = "oldSerialno";
	public static final String CUSTOMER_FULL_NAME = "customerFullName";
	public static final String BANK_NO = "bankNo";
	public static final String SERVICE_NAME = "serviceName";
	public static final String REPAY_AMOUNT_2 = "repayAmount2";
	public static final String TRANS_SERIAL_NO = "transSerialNo";

	/** 社保缴费常量定义 **/
	public static final String SBJBH = "sbjbh";
	public static final String KSQH = "ksqh";
	public static final String JZQH = "jzqh";
	public static final String JFDC = "jfdc";
	public static final String MID_XZ_CODE = "midxzCode";
	public static final String BRCH_CODE = "brchCode";

	/** 长途车票常量定义 **/
	public static final String STATION_TYPE = "stationType";
	public static final String OUT_DEPART_TIME = "outDepartTime";
	public static final String DEPART_STATION = "departStation";
	public static final String DEPART_STATION_NAME = "departStationName";
	public static final String ARRIVE_STATION_NAME = "arriveStationName";
	public static final String FULL_PRICE = "fullprice";
	public static final String REG_BUS_NO = "regBusNo";
	public static final String HALF_PRICE = "halfprice";
	public static final String TICKET_NUM = "ticketNum";
	public static final String CARRY_STATION_ID = "carryStationID";
	public static final String PRICE = "price";
	public static final String DEPART_DATE_TIME = "departDateTime";
	public static final String TICKET_TYPE = "ticketType";
	public static final String HALF_STATION_CHARGE = "halfstationcharge";
	public static final String REG_BUS_NO_FOID = "regbusno_foid";
	public static final String CURRENT_NO = "current_no";
	public static final String SERVICE_PRICE = "servicePrice";
	public static final String STATION_CHARGE = "stationcharge";
	public static final String DEST_STOP_ID = "destStopID";

	/** 智能转账常量定义 **/
	public static final String ACC_NO = "accNo";
	public static final String PAGE_NO = "pageNo";
	public static final String MOBILE = "mobile";
	public static final String TIMEOUTJNLNO = "timeOutJnlNo";

	/** 积分常量定义 **/
	public static final String CUST_ID = "custId";
	public static final String PRCSCD = "prcscd";
	public static final String YCLOYST1001 = "99YCLOYST1001";
	public static final String YCLOYST1002 = "99YCLOYST1002";
	public static final String YCLOYST1004 = "99YCLOYST1004";
	public static final String CONSUMER_SEQ_NO = "consumerSeqNo";
	public static final String PAY_INT_VAL = "payIntVal";
	public static final String PAY_INT_COST_VAL = "payIntCostVal";
	public static final String PAY_CASH_VAL = "payCashVal";
	public static final String UNIT_TO_PRICE = "unitTotPrice";
	public static final String COST_TO_PRICE = "costTotPrice";
	public static final String PROD_LIST = "prodList";

	/** 考勤常量定义 **/
	public static final String EMPLOYEE_TOP = "employeeTop";
	public static final String DEPARTMENT_TOP = "departmentTop";

	/** 短信验证码常量义 **/
	public static final String TRANS_CODE_NAME = "transCodeName";
	public static final String TRANS_CODE_NAME_OTHER_MSG = "sendOtherMsg";
	public static final String SYS_NO = "SYS_NO";
	public static final String SYS_NO_PB = "pb";
	public static final String ADDRESS_NAME = "ADDRESSNAME";
	public static final String COUNT = "COUNT";
	public static final String CONTENT = "CONTENT";
	public static final String SERVERNO = "SERVERNO";
	public static final String MSG = "MSG";
	public static final String ADDRESS = "ADDRESS";
	public static final String TIMESTAMP = "TIMESTAMP";
	public static final String MESSAGE_VALIDATE = "messageValidate";
	public static final String FORGET_PASSWORD_CONTENT = "forgetPasswordContent";
	public static final String REGISTER_CONTENT = "registerContent";
	public static final String FORGET_MOBILE_PHONE = "forgetMobilePhone";
	public static final String RESET_PAY_PASSWORD_CONTENT = "resetPayPasswordContent";
	public static final String CERTIFICATION_BANK_PHONE_CONTENT = "certificationBankPhoneContent";
	public static final String MODIFY_CARD_PASSWORD_CONTENT = "modifyCardPasswordContent";
	public static final String ADD_OTHER_BANK_CARD_CONTENT = "addOtherBankCardContent";
	public static final String OPEN_CODE_CONTENT = "openCardContent";
	public static final String MARKET_CODE_CONTENT = "marketCardContent";
	public static final String CHECK_DEVICE_ID_CONTENT = "checkDeviceIdContent";
	public static final String USER_DEVICE_DELETE_CONTENT = "userDeviceDeleteContent";
	public static final String UPDATE_MOBILE_CONTENT = "updateMobileContent";
	public static final String SELF_BANK_CERTIFICATION_CONTENT = "selfBankCertificationContent";
	public static final String ACTIVATE_CREDIT_CARD_CONTENT = "activateCreditCardContent";
	public static final String PAYMENT_MSG_CONTENT = "paymentMsgContent";
	public static final String ELITE_CREDIT_LOAN_CONTENT = "eliteCreditLoanContent";
	public static final String THIRDPARTY_BIND_MBL_CONTENT = "thirdPartyBindMBLContent";
	public static final String CHANGE_BUND_ACCOUNT_CONTENT = "changeBundAccountContent";
	public static final String GET_REMAIN_MOBILE_PHONE_CONTENT = "getRemainMobilePhoneContent";
	public static final String MOBILE_BANK_SIGN_CONTENT = "mobileBankSignContent";
	public static final String SECURE_LOCK = "secureLockContent";
	public static final String BUND_OHTER_BANK_CARD = "bundOtherCard";
	public static final String CREDIT_CARD_TRANS_PWD_SET_CONTENT = "creditCardTransPwdSetContent";
	public static final String CAN_NOT_BE_ADDED_DCMTTP = "canNotBeAddedDcmttp";
	public static final String CAN_NOT_ADDED = "canNotAdded";
	public static final String BANK_TYPE2_RECHARGE_CONTENT = "bankAcType2RechargeContent";
	public static final String CHANGE_BUND_MOBILE_PHONE_CONTENT = "changeBundMobilePhoneContent";
	public static final String SHARE_CERTIFICATION_CONTENT = "shareCertificationContent";
	public static final String TRANS_PLAN_CONTENT = "transPlanContent";
	public static final String SMBIZOWNER_CREDIT_LOAN_CONTENT = "sbownerLoanCertificationContent"; // 银税贷支用确认
	public static final String CREDIT_CARD_VER_CODE = "creditCardSendVerCode";

	// 实名认证中金校验逻辑修改系统参数增加(调用华府金科)
	public static final String OTHER_BANK_CERTI_CONTROL = "otherBankCertiControl";
	public static final String OTHER_BANK_CERTI_HFJK = "otherBankCertiHFJK";
	public static final String CURRENT_REGISTER_COUNT = "currentRegisterCount";
	public static final String TOTAL_REQUEST_TRRESHOLD = "totalRequestThresHold";
	public static final String TOTAL_WAIT_TIME_TRRESHOLD = "totalWaitTimeThresHold";
	public static final String THREAD_SLEEP_TIME = "threadSleepTime";
	public static final String JEDIS_VALID_TIME = "jedisValidTime";

	public static final String HFJK_SYS_PARAM = "hfjk";
	public static final String HFJK_CHANNEL_TYPE = "channelType";
	public static final String HFJK_REQUEST_SID = "requestSid";
	public static final String USE_CONFIG_ERROR = "useConfigError";
	public static final String USE_CONFIG_ERROR_Y = "useConfigErrorY";

	public static final String SUCCESS_CODE = "0000";

	public static final String QUERY_BEGIN_LINE = "0";

	public static final String QUERY_NUM = "10";

	/** 用户信息 */
	public static final String LOCAL_USER = "baseUser";
	/** 交易配置信息 */
	public static final String LOCAL_TRANS_CONFIG = "transConfig";

	/** 乘车码支付 */
	public static final String BUS_SCAN_CODE = "busScanCodeContent";
	/** 天府支付码支付 */
	public static final String HOTEL_SCAN_CODE = "hotelScanCodeContent";
	/** 登录秘文转换参数 */
	public static final String PASSWORD_CHANGE_MW = "123010004";
	public static final String CHANNEL_CODE_FOR_UAM = "001";
	/**性别代码*/
	public static final String SEX_CODE_M = "131010002";//男
	public static final String SEX_CODE_F = "131010001";//女
	/**证件类型*/
	public static final String ID_TYPE_ID_CARD= "109010001";
	/**国家*/
	public static final String COUNTRY_CHINA= "111010001";
	
	
	
	/**支付sdk常量配置*/
	//***************************************************************************BEGIN//
	public static final String PAY_SDK = "paysdk";
	public static final String TFPAY_PLATFORM_BASE_PARAM = "tfPayPlatformBaseParam";
	public static final String TFPAY_PLATFORM_QUERY_ORDER_BASE_PARAM = "tfPayPlatformQueryOrderBaseParam";
	public static final String TFPAY_RESERVATE_BASE_PARAM = "tfpayReservateBaseParam";
	public static final String TFPAY_RESERVATE_PAY_BASE_PARAM = "tfpayReservatePayBaseParam";
	public static final String TFPAY_SERVICE = "service";
	public static final String TFPAY_SERVICE_VERSION = "service_version";
	public static final String TFPAY_SIGN_TYPE = "sign_type";
	public static final String TFPAY_SIGN_TYPE_MD5 = "MD5";
	public static final String TFPAY_SIGN_ENCODING_UTF8 = "UTF-8";
	public static final String TFPAY_SEND_PARAMS_JSON_STRING = "sendParamsJsonString";
	public static final String TFPAY_SIGN = "sign";
	public static final String TFPAY_SIGN_KEY = "signKey";
	public static final String TFPAY_INPUT_CHARSET = "input_charset";
	public static final String TFPAY_BODY = "body";
	public static final String TFPAY_BIZ_TYPE= "biz_type";
	public static final String TFPAY_BIZ_TYPE_0001= "0001";
	public static final String TFPAY_BIZ_TYPE_0004= "0004"; //一码付
	public static final String TFPAY_USER_ID= "user_id"; //一码付支付需要传入该参数(当前登录用户手机号)
	public static final String TFPAY_TRADE_MODE_0001= "0001";
	public static final String TFPAY_TRADE_MODE_0002= "0002";
	public static final String TFPAY_TRANS_PATTERN= "trans_pattern";
	public static final String TFPAY_TRANS_PATTERN_ZERO= "0";
	public static final String TFPAY_LIMIT_PAY = "limit_pay";
	public static final String TFPAY_LIMIT_PAY_1 = "1";
	public static final String TFPAY_LIMIT_PAY_2 = "2";
	public static final String TFPAY_LIMIT_PAY_3 = "3";
	public static final String TFPAY_MAP = "map";
	public static final String TFPAY_TRADE_DETAILS = "trade_details";
	public static final String TFPAY_TRADE_MODE = "trade_mode";
	public static final String TFPAY_SUBJECT = "subject";
	public static final String TFPAY_SPBILL_CREATE_IP = "spbill_create_ip";
	public static final String TFPAY_FEE_TYPE = "fee_type";
	public static final String TFPAY_FEE_TYPE_VALUE_ONE = "1";
	public static final String TFPAY_OUT_TRADE_NO = "out_trade_no";
	public static final String TFPAY_TOTAL_FEE = "total_fee";
	public static final String TFPAY_PARTNER = "partner";
	public static final String TFPAY_SUB_PARTNER = "subpartner";
	public static final String TFPAY_SUB_APPID =  "sub_appid";
	public static final String TFPAY_WX = "wx";
	public static final String TFPAY_ZFB = "alipay";
	public static final String TFPAY_APPLE = "apple";
	public static final String TFPAY_APP_ID =  "app_id";
	public static final String TFPAY_PRODUCT_CODE = "product_code";
	public static final String TFPAY_QUICK_MSECURITY_PAY = "QUICK_MSECURITY_PAY";
	public static final String TFPAY_BATCH_NUM = "batch_num";
	public static final String TFPAY_BATCH_NUM_VALUE_ONE = "1";
	public static final String TFPAY_MOBILE = "mobile";
	public static final String TFPAY_ATTACH = "attach";
	public static final String TFPAY_TOKEN_ID = "tokenid";
	public static final String TFPAY_TRANS_CHANNEL= "trans_channel";
	public static final String TFPAY_PHONEBANK_PAY_ADDRESS = "phoneBankPayAddress";
	public static final String TFPAY_NOTIFY_URL = "notify_url";
	public static final String TFPAY_RETURN_URL = "return_url";
	public static final String TFPAY_SHOW_URL = "show_url";
	public static final String TFPAY_SPLITER = "^";
	public static final String TFPAY_VALUE_ZERO = "0";
	public static final String TFPAY_COMMA = ",";
	public static final String TFPAY_PAYSDK_CLASS_PATH = "paysdkClassPath";
	public static final String TFPAY_REFLECT_GET_METHOD = "get";
	public static final String TFPAY_SUCCESS = "0";
	public static final String TFPAY_FAILURE = "1";
	public static final String TFPAY_PROCESSING = "2";
	public static final String TFPAY_PARAM_ACNO = "acno";
	public static final String TFPAY_PARAM_ACCOUNT_NO = "accountNo";
	public static final String TFPAY_PARAM_NAME = "name";
	public static final String TFPAY_PARAM_PHONE = "phone";
	public static final String TFPAY_PARAM_IDNO = "idNo";
	public static final String TFPAY_PARAM_TERMID = "termId";
	public static final String TFPAY_PARAM_TERMCODE = "termCode";
	public static final String TFPAY_PARAM_TERMADDR = "termAddr";
	public static final String TFPAY_PARAM_SENDORG = "sendOrg";
	public static final String TFPAY_PARAM_BANKNAME = "bankName";
	public static final String TFPAY_PARAM_CARDTYPE = "cardType";
	public static final String TFPAY_PARAM_TRANSCHANNEL = "trans_channel";
	public static final String TFPAY_PARAM_THIRD_PART_CHANNEL = "thirdPartChannel";
	public static final String TFPAY_PARAM_THIRD_PART_CHANNEL_ZFYMF = "zfymf";
	public static final String TFPAY_PARAM_TRANSCHANNEL_SELFBANK = "quickpay_cgnb";
	public static final String TFPAY_PARAM_TRANSCHANNEL_SELFBANK_CREDIT = "creditcard_cgnb";
	public static final String TFPAY_PARAM_TRANSCHANNEL_OTHERBANK = "quick_debit_pay";
	public static final String TFPAY_PARAM_TRANSCHANNEL_SCORE = "integral_tf";
	public static final String TFPAY_TRADE_STATE = "tradeState";
	public static final String TFPAY_TRANSACTION_ID = "transaction_id";
	public static final String TFPAY_PLAT_TRANS_NO = "platTransno";
	public static final String TFPAY_PAY_RESULT = "payResult";
	public static final String TFPAY_PAY_FAIL_REASON = "payFailReason";
	public static final String TFPAY_PAY_FAIL_CODE= "payFailCode";
	public static final String PAYSDKORDER_CACHETIME = "cacheTime";//订单有效期
	public static final String TFPAY_PAY_TYPE_INT = "1";//积分支付
	public static final String TFPAY_PAY_TYPE_MONEY = "0";//现金支付
	public static final String TFPAY_PAY_TYPE_DOUBLE = "2";//混合支付
	
	public static final String TFPAY_PAY_TYPE_CREATE = "2";//订单创建
	public static final String TFPAY_PAY_TYPE_SUCCESS = "0";//订单成功
	public static final String TFPAY_PAY_TYPE_FAIL = "1";//订单失败
	public static final String TFPAY_PAY_TYPE_TIMEOUT = "3";//订单超时
	
	public static final String PAY_RESULT_SUCCESS = "0";//支付成功
	public static final String PAY_RESULT_FAIL = "1";//支付失败
	public static final String PAY_RESULT_PROCESSING = "2";//支付超时
	
	public static final String PAY_TYPE_SELF_ONE = "1";//本行卡一类户支付
	public static final String PAY_TYPE_SELF_TWO = "2";//本行卡2类户支付
	public static final String PAY_TYPE_CREDIT = "3";
	public static final String PAY_TYPE_OTHER = "4";//他行卡
	public static final String PAY_TYPE_WX = "5";//微信支付
	public static final String PAY_TYPE_ZFB = "6";//支付宝支付
	public static final String PAY_TYPE_APPLE = "7";//苹果支付	
	public static final String PAY_TF_RETURN_MESSAGE = "returnMsg";//天府支付返回信息
	public static final String PAY_MBZ_RETURN_MESSAGE = "returnMsg";//前置返回信息
	
	public static final String TF_PAY_PROCESSING_CODE = "tfPayProcessingCode";//天府支付返回处理中错误码
	
	/**支付宝同步回调参数列表*/
	public static final String ALIPAY_OUT_TRADE_NO = "out_trade_no"; //商户网站唯一订单号 
	public static final String ALIPAY_TRADE_NO = "trade_no"; //支付宝系统中的交易流水号
	public static final String ALIPAY_APP_ID= "app_id"; //支付宝app_id
	public static final String ALIPAY_TOTAL_AMOUNT = "total_amount"; //订单总金额
	public static final String ALIPAY_SELLER_ID = "seller_id"; //收款支付宝账号对应的支付宝唯一用户号
	public static final String ALIPAY_MSG = "msg"; //处理结果的描述
	public static final String ALIPAY_CHARSET = "charset"; //编码格式
	public static final String ALIPAY_CODE = "code"; //结果码
	public static final String ALIPAY_TIMESTAMP = "timestamp"; //时间
	public static final String ALIPAY_SIGN = "sign"; //签名结果
	public static final String ALIPAY_SIGN_TYPE = "sign_type"; //签名类型
	public static final String ALIPAY_RESULT_STATUS= "resultStatus"; //返回码
	
	/**手机快速充值参数列表*/
	
	public static final String MID_BIZ_PARAM_ACCOUNT_NO= "accountNo"; //充值银行卡号
	public static final String MID_BIZ_PARAM_PHONE_NUMBER= "phoneNumber"; //充值手机号码
	public static final String MID_BIZ_PARAM_DISCOUNT_AMOUNT = "discountAmount"; //折扣金额
	public static final String MID_BIZ_PARAM_TRANS_AMOUNT= "transAmount"; //交易金额
	public static final String MID_BIZ_PARAM_FRT_SERIAL_NO= "frtSerialNo"; //前置区分发起渠道交易流水号
	public static final String MID_BIZ_PARAM_JNLNO= "jnlno"; //前置区分发起渠道交易流水号
	public static final String MID_BIZ_PARAM_OUT_TRADE_NO= "outTradeNo"; //调用支付平台需要的流水号
	public static final String MID_BIZ_PARAM_ODNO= "odno"; //调用支付平台需要的流水号
	public static final String MID_BIZ_PARAM_TRANS_TYPE= "transType"; //1--支付 2--查询
	public static final String MID_BIZ_PARAM_TRANS_TYPE_PAY= "1"; //1--需转发支付平台标志 
	public static final String MID_BIZ_PARAM_TRANS_TYPE_QUERY= "2"; //2--支付缴费状态查询
	public static final String MID_BIZ_PARAM_TRANS_RESERVATE_ORDER= "3"; //3--预下单
	public static final String MID_BIZ_PARAM_TRANS_RESERVATE_PAY= "4"; //4--预下单支付
	public static final String MID_BIZ_PARAM_PAY_TYPE_CODE= "payTypeCode"; //10--本行 20--他行 50--支付宝 60--微信
	public static final String MID_BIZ_PARAM_PAY_TYPE_DESC= "payTypeDesc"; //quickpay_cgnb,quick_debit_pay,wx,alipay
	public static final String MID_BIZ_PARAM_MID_ITEM= "midItem"; //16A--话费充值 51--学费
	public static final String MID_BIZ_PARAM_PARTNER= "partner"; //一级商户号
	public static final String MID_BIZ_PARAM_SUB_PARTNER= "subpartner"; //二级商户号
	public static final String MID_BIZ_PARAM_TO_PAY_PLATFORM= "sendParamsJsonString"; //二级商户号
	public static final String MID_BIZ_RPARAM_MID_SERIAL_NO = "midSerialNo"; //前置返回流水号
	public static final String MID_BIZ_RPARAM_RETURN_CODE= "returnCode"; //前置返回code
	public static final String MID_BIZ_RPARAM_RETURN_MESSAGE= "returnMsg"; //前置返回信息
	public static final String TRANS_CHANNEL_CONFIGURED = "transChannelConfigured";
	public static final String TRANS_MIDBIZ_CHANNEL_CONFIGURED = "transMidBizChannelConfigured";
	
	//白名单管理
	public static final String TF_OA_MODULE_JEDIS_TYPE = "oa_white_list"; //天府科技OA redis key
	public static final String TF_OA_JEDIS_TYPE = "tfb_oa_user_set"; //天府银行OA redis key
	public static final String VIDEO_MEETING_JEDIS_TYPE = "videoMeeting_white_list"; //视频会议redis key

}
