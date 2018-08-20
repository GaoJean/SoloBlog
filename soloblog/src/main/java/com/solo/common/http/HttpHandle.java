package com.solo.common.http;

import com.alibaba.fastjson.JSON;
import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;
import com.solo.common.model.ResultModel;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author gaojian
 * @Date 2018/8/16
 */
@Component
public class HttpHandle {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private OkHttpClient okHttpClient;

    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    public ResultModel post(String url, String bodyJson) throws BusinessException {
        return post(url, null, null, bodyJson);
    }

    public ResultModel post(String url, Map<String, Object> uriParam, Map<String, String> headerList, String bodyJson)
            throws BusinessException {

        RequestBody requestBody = RequestBody.create(APPLICATION_JSON, bodyJson);
        Request request = createRequest(url, uriParam, headerList).post(requestBody).build();
        String resultJson = "";
        logger.info("POST HTTP REQUEST WITH request={}, header ={}, body = {}", request, request.headers(), bodyJson);

        try (Response response = okHttpClient.newCall(request).execute()) {
            resultJson = response.body().string();
            logger.info("RESULT with body={}, response = {}", resultJson, response);
            return JSON.parseObject(resultJson, ResultModel.class);
        } catch (Exception e) {
            logger.error("POST HTTP 失败 with json = {}, exception = {}", resultJson, e);
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR);
        }
    }

    public ResultModel get(String url, Map<String, Object> uriParam, Map<String, String> headerList)
            throws BusinessException {

        Request request = createRequest(url, uriParam, headerList).get().build();
        String resultJson = "";
        logger.info("GET HTTP REQUEST WITH request={}, header ={}", request, request.headers());

        try (Response response = okHttpClient.newCall(request).execute()) {
            resultJson = response.body().string();
            logger.info("RESULT with body={}, response = {}", resultJson, response);
            return JSON.parseObject(resultJson, ResultModel.class);
        } catch (Exception e) {
            logger.error("GET HTTP 失败 with json = {}, exception = {}", resultJson, e);
            throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR);
        }
    }

    private Request.Builder createRequest(String url, Map<String, Object> uriParam, Map<String, String> headerList) {
        Request.Builder requestBuilder = new Request.Builder();

        // 配置uri参数
        HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();
        if (uriParam != null) {
            uriParam.forEach((key, value) -> {
                httpBuider.addQueryParameter(key, value.toString());
            });
        }
        requestBuilder.url(httpBuider.build());

        // 配置头部参数
        if (headerList != null) {
            requestBuilder.headers(Headers.of(headerList));
        }

        return requestBuilder;
    }



    public void setHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }
}
