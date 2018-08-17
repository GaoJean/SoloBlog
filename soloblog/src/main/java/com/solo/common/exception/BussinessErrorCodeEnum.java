package com.solo.common.exception;

/**
 * @Author gaojian
 * @Date 2018/8/7
 */
public enum BussinessErrorCodeEnum implements ErrorCode {
    SYSTEM_ERROR(1, "系统异常"),
    BIZ_ERROR(2, "业务异常"),
    PARAM_ERROR(3, "参数异常");

    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误描述
     */
    private String message;

    BussinessErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
