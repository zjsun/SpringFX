package me.alex.spring.fx.core;

/**
 * Created by Alex.Sun on 1/11/17.
 */
public class FxException extends RuntimeException {
    public FxException() {
    }

    public FxException(String message) {
        super(message);
    }

    public FxException(String message, Throwable cause) {
        super(message, cause);
    }

    public FxException(Throwable cause) {
        super(cause);
    }

    public FxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
