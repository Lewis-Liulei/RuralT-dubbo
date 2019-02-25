package rt.lewis.api.exception;

public class RegException extends  Exception{

	
	public RegException() {
		super();
	}

	public RegException(String message) {
		super(message);
	}

	public RegException(String message, Throwable cause,
                        boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RegException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegException(Throwable cause) {
		super(cause);
	}

}
