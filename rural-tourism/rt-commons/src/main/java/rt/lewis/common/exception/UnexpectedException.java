package rt.lewis.common.exception;


public class UnexpectedException extends RuntimeException {

	private static final long serialVersionUID = -5562104925630725000L;
	private boolean hasBeanRecorded = false;
	protected String errorCode;

	public UnexpectedException(String paramString, boolean paramBoolean) {
		super(paramString);
		recorded(paramBoolean);
	}

	public UnexpectedException(Throwable paramThrowable, boolean paramBoolean) {
		super("", paramThrowable);
		recorded(paramBoolean);
	}

	public UnexpectedException(String paramString, Throwable paramThrowable,
			boolean paramBoolean) {
		super(paramString, paramThrowable);
		recorded(paramBoolean);
	}

	public UnexpectedException(String paramString) {
		super(paramString);
	}

	public UnexpectedException(Throwable paramThrowable) {
		super(paramThrowable.getMessage(), paramThrowable);
	}

	public UnexpectedException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

	public String getErrorCode() {
		return "-1";
	}

	public String getErrorTitle() {
		return "运行时错误!";
	}

	public String getErrorDescription() {
		String str = getMessage();
		if ((str == null) || ("".equals(str))) {
			str = getCause().getMessage();
		}
		return str;
	}

	public boolean hasBeanRecorded() {
		return this.hasBeanRecorded;
	}

	public void recorded(boolean hasBeanRecorded) {
		this.hasBeanRecorded = hasBeanRecorded;
	}
}
