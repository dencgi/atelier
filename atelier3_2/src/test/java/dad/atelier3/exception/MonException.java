package dad.atelier3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class MonException extends RuntimeException {

	private static final long serialVersionUID = 1895944142727932856L;

	public MonException() {
		super();
	}

	public MonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MonException(String message, Throwable cause) {
		super(message, cause);
	}

	public MonException(String message) {
		super(message);
	}

	public MonException(Throwable cause) {
		super(cause);
	}

}
