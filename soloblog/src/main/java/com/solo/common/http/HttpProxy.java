package com.solo.common.http;

import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;
import com.solo.common.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String,Object> getGitLabproject() throws BusinessException {

        List<NameValuePair> formparams = new ArrayList <NameValuePair>();
        String url = "http://git.doctorwork.com/projects";
        Map<String, Object> uriParam = new HashMap<>();
        Map<String, String> headerLis = new HashMap<>();
        ResultModel model = handle.get(url,uriParam,headerLis);
        if(model == null || model.getModel() == null){
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR,"调用http请求失败！");
        }
        return (Map<String,Object>)model.getModel();
    }
}
