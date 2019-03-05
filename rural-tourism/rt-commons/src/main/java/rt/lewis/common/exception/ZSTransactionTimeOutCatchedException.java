package rt.lewis.common.exception;


public class ZSTransactionTimeOutCatchedException extends Exception {
	
	private static final long serialVersionUID = 4693786499059513760L;
	
	private String errorDescription;
	
	private String errorCode;
	
	public ZSTransactionTimeOutCatchedException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	public ZSTransactionTimeOutCatchedException(String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
	}

	public ZSTransactionTimeOutCatchedException(String code,String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}

	public ZSTransactionTimeOutCatchedException(String code,String errorDescription, Throwable t) {
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
