package rt.lewis.common.exception;

public class ZSBusinessException extends UnexpectedException {
	
	private static final long serialVersionUID = 4693786499059513760L;
	
	private String errorDescription;
	
	private String errorCode;
	
	public ZSBusinessException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	public ZSBusinessException(String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
	}

	public ZSBusinessException(String code,String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}

	public ZSBusinessException(String code,String errorDescription, Throwable t) {
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
		return "业务校验失败!";
	}
	
	
	
}
