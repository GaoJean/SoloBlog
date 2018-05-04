package com.solo.controller;

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
    public String testMain(@RequestParam(value = "id") String id){
        logger.info("testMain={}",id);
        return "hello";
    }


 }
