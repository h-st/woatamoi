package de.qaware.buenavista;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.ResponseWrapper;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidURLException extends RuntimeException {

    public InvalidURLException() {
    }

    public InvalidURLException(String message) {
        super(message);
    }

    public InvalidURLException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidURLException(Throwable cause) {
        super(cause);
    }

    public InvalidURLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
