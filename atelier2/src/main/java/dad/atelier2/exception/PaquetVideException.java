package dad.atelier2.exception;

public class PaquetVideException extends RuntimeException {

	private static final long serialVersionUID = 4459131340797644907L;

	public PaquetVideException() {
	}

	public PaquetVideException(String arg0) {
		super(arg0);
	}

	public PaquetVideException(Throwable arg0) {
		super(arg0);
	}

	public PaquetVideException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PaquetVideException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
