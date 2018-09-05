package com.solo.common.http;

import com.solo.common.exception.BusinessException;
import com.solo.common.exception.BussinessErrorCodeEnum;
import com.solo.common.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

	private static final String HTTPHOST = "https://gitlab.com/api/v4//users/299076";

	private static final String API_VERSION_KEY = "X-ApiVersion";

	private static final String API_VERSION_VALUE = "1.0";

	private static final String TOKEN = "PRIVATE-TOKEN";

	public String createOrder(String bodyJson) throws BusinessException {
		Map<String, Object> uriParam = new HashMap<>();
		//uriParam.put("id", 1);
		ResultModel httpResult = null;
		try {
			httpResult = handle.get(HTTPHOST, uriParam, this.getHttpHeaders());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (httpResult == null || httpResult.getModel() == null) {
			throw new BusinessException(BussinessErrorCodeEnum.BIZ_ERROR.getCode(), "调用http请求失败！");
		}
		return (String) httpResult.getModel();
	}

	private Map<String, String> getHttpHeaders() {
		Map<String, String> headers = new HashMap<>();
		//headers.put(API_VERSION_KEY, API_VERSION_VALUE);
		//headers.put(TOKEN, "xN3wZD8vDzt8p6mX5seQ");
		return headers;
	}

}
