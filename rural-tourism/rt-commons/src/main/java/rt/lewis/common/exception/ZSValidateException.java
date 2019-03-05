package rt.lewis.common.exception;

import java.util.List;

public class ZSValidateException extends UnexpectedException {
	
	private static final long serialVersionUID = 4693786499059513760L;
	private List<String> errors;

	private String errorDescription;
	
	public ZSValidateException( String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	public ZSValidateException(String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
	}
	
	public ZSValidateException(String errorDescription,List<String> errors){
		super(errorDescription);		
		this.errors = errors;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	public String getErrorTitle() {
		return "业务校验失败!";
	}
	
	
	public List<String> getErrors() {
		return errors;
	}
	
}
