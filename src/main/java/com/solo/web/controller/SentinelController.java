package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.adaptor.SentinelAdaptor;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gaojian
 * @Date 2018/9/25
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController extends BaseController {

    @Autowired
    private SentinelAdaptor sentinelAdaptor;

    @GetMapping("/get")
    @ApiOperation(value = "get", notes = "测试")
    @Verification(token = false)
    public ResultModel get() {
        return success(sentinelAdaptor.get());
    }
}
