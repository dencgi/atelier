package dad.atelier3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperationNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 5336671479898621295L;

	public OperationNotSupportedException() {
		super();
	}

	public OperationNotSupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OperationNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationNotSupportedException(String message) {
		super(message);
	}

	public OperationNotSupportedException(Throwable cause) {
		super(cause);
	}

}
