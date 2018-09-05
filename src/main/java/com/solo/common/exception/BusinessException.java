package com.solo.common.exception;

/**
 * @Author gaojian
 * @Date 2018/8/16
 */
public class BusinessException extends Exception {

    private int code;
    private String message;

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(int code, String message, Object... args) {
        this.code = code;
        this.message = String.format(message, args);
    }

    public BusinessException(ErrorCode errorCode, Object... args) {
        if(errorCode != null) {
            this.code = errorCode.getCode();
            this.message = String.format(errorCode.getMessage(), args);
        }

    }

    public BusinessException(ErrorCode errorCode) {
        if(errorCode != null) {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
        }

    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
