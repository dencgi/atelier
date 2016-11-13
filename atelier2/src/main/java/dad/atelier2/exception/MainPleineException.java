package dad.atelier2.exception;

public class MainPleineException extends RuntimeException {

	private static final long serialVersionUID = -541682877613493447L;

	public MainPleineException() {
	}

	public MainPleineException(String arg0) {
		super(arg0);
	}

	public MainPleineException(Throwable arg0) {
		super(arg0);
	}

	public MainPleineException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MainPleineException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
