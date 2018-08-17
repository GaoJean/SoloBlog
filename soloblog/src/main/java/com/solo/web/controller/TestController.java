package com.solo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.solo.common.exception.BusinessException;
import com.solo.common.http.HttpProxy;
import com.solo.common.model.ResultModel;
import com.solo.common.util.BeanMapperUtil;
import com.solo.common.verify.Verification;
import com.solo.web.entity.request.user.LoginRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Jianjian on 2018/5/3.
 */
@RestController
@RequestMapping("/main")
public class TestController extends BaseController{

    @Autowired
    private HttpProxy httpProxy;

    @GetMapping("/test")
    @ApiOperation(value = "testMain", notes = "My frist controller")
    @Verification(token = false)
    public ResultModel testMain(@RequestParam(value = "id") String id) {
        logger.info("testMain = {}", id);
        return success("hello");
    }


    public static void main(String[] args) throws Exception {
        LoginRequest req = new LoginRequest();
        req.setPassword("1231");
        req.setUsername("123123");
        req.setId(1l);
        Map<String,Object> param = BeanMapperUtil.convertToMap(req);
        System.out.println(JSONObject.toJSONString(param));
       /* BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            Double price = 0.01;
            BigDecimal bigDecimal = new BigDecimal(Double.toString(price));
            total = total.add(bigDecimal);

        }

        System.out.println(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());*/

    }

    @GetMapping("/index")
    public String toIndex() {
        return "/index";
    }

    @PostMapping("/testHttp")
    public ResultModel testHttp() throws BusinessException {

        return success(httpProxy.createOrder("a"));
    }





}
