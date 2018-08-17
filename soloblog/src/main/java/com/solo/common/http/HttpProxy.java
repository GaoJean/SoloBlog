package com.solo.common.http;

import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;
import com.solo.common.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author gaojian
 * @Date 2018/8/16
 */
@Component
public class HttpProxy {

    @Autowired
    HttpHandle handle;

    private static final String HTTPHOST="";

    public String createOrder(String bodyJson) throws BusinessException {

        ResultModel httpResult = handle.post(HTTPHOST,  bodyJson);
        if(httpResult == null || httpResult.getModel() == null){
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR,"调用http请求失败！");
        }
        return (String) httpResult.getModel();
    }
}
