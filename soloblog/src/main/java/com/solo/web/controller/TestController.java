package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by Jianjian on 2018/5/3.
 */
@RestController
@RequestMapping("/main")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    @ApiOperation(value = "testMain", notes = "My frist controller")
    @Verification(token = false)
    public ResultModel testMain(@RequestParam(value = "id") String id) {
        logger.info("testMain = {}", id);
        ResultModel resultModel = new ResultModel();
        resultModel.setModel("hello");
        return resultModel;
    }


    public static void main(String[] args) {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            Double price = 0.01;
            BigDecimal bigDecimal = new BigDecimal(Double.toString(price));
            total = total.add(bigDecimal);

        }

        System.out.println(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    @GetMapping("/index")
    public String toIndex() {
        return "/index";
    }

}
