package com.solo.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;
import com.solo.common.model.ResultModel;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author gaojian
 * @Date 2018/8/16
 */
@Component
public class HttpHandle {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    public ResultModel post(String url, String bodyJson) throws BusinessException {
        return post(url, null, null, bodyJson);
    }

    public ResultModel post(String url, Map<String, String> headerList, String bodyJson) throws BusinessException {
        return post(url, null, headerList, bodyJson);
    }

    public ResultModel post(String url, Map<String, Object> uriParam, Map<String, String> headerList, String bodyJson)
            throws BusinessException {
        this.printParams(url, uriParam, headerList, bodyJson);
        RequestBody requestBody = RequestBody.create(APPLICATION_JSON, bodyJson);
        Request request = this.createRequest(url, uriParam, headerList).post(requestBody).build();
        String resultJson = "";
        logger.info("POST HTTP REQUEST WITH request={}, header ={}, body = {}", request, request.headers(), bodyJson);

        try (Response response = okHttpClient.newCall(request).execute()) {
            resultJson = response.body().string();
            logger.info("RESULT with body={}, response = {}", resultJson, response);
            return JSON.parseObject(resultJson, ResultModel.class);
        } catch (Exception e) {
            logger.error("POST HTTP 失败 with json = {}, exception = {}", resultJson, e);
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR.getCode(), e.getMessage());
        }
    }

    public ResultModel get(String url, Map<String, Object> uriParam, Map<String, String> headerList)
            throws BusinessException, IOException {
        this.printParams(url, uriParam, headerList, "");
        Request request = this.createRequest(url, uriParam, headerList).get().build();
        Response response = okHttpClient.newCall(request).execute();
        String resultJson = response.body().string();
        this.validateResult(response, url);
        logger.info("RESULT with body={}, response = {}", resultJson, response);
        return JSON.parseObject(resultJson, ResultModel.class);
    }

    private Request.Builder createRequest(String url, Map<String, Object> uriParam, Map<String, String> headerList) {
        Request.Builder requestBuilder = new Request.Builder();

        // 配置uri参数
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        if (uriParam != null) {
            uriParam.forEach((key, value) -> {
                httpBuilder.addQueryParameter(key, value.toString());
            });
        }
        requestBuilder.url(httpBuilder.build());

        // 配置头部参数
        if (headerList != null) {
            requestBuilder.headers(Headers.of(headerList));
        }

        return requestBuilder;
    }



    private void printParams(String url, Map<String, Object> urlParam, Map<String, String> headerList, String bodyJson) {
        logger.info("调用URL->{}, uriParam->{}, header->{}, requestBody->{}", url, JSONObject.toJSONString(urlParam),
                JSONObject.toJSONString(headerList), JSONObject.toJSONString(bodyJson));
    }

    private <T> void validateResult(Response response, String url) {
        if (response == null) {
            logger.error("调用 {} 返回responseEntity为空.", url);
            throw new NullPointerException("调用  " + url + " 返回responseEntity为空..");
        }


    }
}
