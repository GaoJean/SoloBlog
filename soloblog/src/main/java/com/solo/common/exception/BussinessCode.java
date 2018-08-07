package com.solo.common.exception;

/**
 * @Author gaojian
 * @Date 2018/8/7
 */
public enum BussinessCode implements ErrorCode{
    COMMON_ERROR(1, "banner模块出错，请稍后再试");


    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误描述
     */
    private String message;

    BussinessCode(int code, String message) {
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
