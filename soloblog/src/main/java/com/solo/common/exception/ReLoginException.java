package com.solo.common.exception;

public class ReLoginException extends Exception {

    private static final long serialVersionUID = 6181642941762430251L;

    public ReLoginException() {
        super();
    }

    public ReLoginException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ReLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReLoginException(String message) {
        super(message);
    }

    public ReLoginException(Throwable cause) {
        super(cause);
    }

}
