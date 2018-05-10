package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jianjian on 2018/5/3.
 */
@RestController
@RequestMapping("/main")
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/test")
    @ApiOperation(value = "testMain",notes = "My frist controller")
    @Verification(token = false)
    public ResultModel testMain(@RequestParam(value = "id") String id){
        logger.info("testMain = {}",id);
        ResultModel resultModel = new ResultModel();
        resultModel.setModel("hello");
        return resultModel;
    }


 }
