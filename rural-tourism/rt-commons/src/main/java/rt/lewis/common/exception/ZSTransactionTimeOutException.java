package rt.lewis.common.exception;


public class ZSTransactionTimeOutException extends ZSBusinessException {
	
	private static final long serialVersionUID = 4693786499059513760L;
	
	private String errorDescription;
	
	private String errorCode;
	
	public ZSTransactionTimeOutException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	public ZSTransactionTimeOutException(String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
	}

	public ZSTransactionTimeOutException(String code,String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}

	public ZSTransactionTimeOutException(String code,String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}	
	public String getErrorDescription() {
		return this.errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorTitle() {
		return "交易超时!";
	}
}
