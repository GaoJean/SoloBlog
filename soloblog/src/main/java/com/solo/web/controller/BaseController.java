package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaojian
 * @Date 2018/8/7
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseController() {

    }

    protected ResultModel success() {
        return new ResultModel(Integer.valueOf(0), "success", (Object) null);
    }

    protected  ResultModel success( Object object){
        return new ResultModel(Integer.valueOf(0),"success",object);
    }
    protected ResultModel success(Integer errorCode, Object content) {
        return new ResultModel(errorCode, "success", content);
    }

    protected ResultModel error(String message) {
        return new ResultModel(Integer.valueOf(1), message, (Object)null);
    }

    protected ResultModel error(Integer errorCode, String message) {
        return new ResultModel(errorCode, message, (Object)null);
    }

   /* protected ResultModel error(ErrorCode errorCode) {
        return new ResultModel(Integer.valueOf(errorCode.getCode()), errorCode.getMessage(), (Object)null);
    }*/
}
