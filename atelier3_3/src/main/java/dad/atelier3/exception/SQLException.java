package dad.atelier3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SQLException extends RuntimeException {

	private static final long serialVersionUID = 5336671479898621295L;

	public SQLException() {
		super();
	}

	public SQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public SQLException(String message) {
		super(message);
	}

	public SQLException(Throwable cause) {
		super(cause);
	}

}
