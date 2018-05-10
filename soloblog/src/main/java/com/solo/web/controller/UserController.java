package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.adaptor.UserAdaptor;
import com.solo.web.entity.request.user.LoginRequest;
import com.solo.web.entity.response.user.LoginResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jianjian on 2018/5/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserAdaptor userAdaptor;

    @PostMapping("/login")
    @ApiOperation(value = "login",notes = "login")
    @Verification(token = false)
    public ResultModel login(@RequestBody LoginRequest request){
        logger.info("{用户管理UserController}[方法入：login(),参数：{}]",request);
        ResultModel resultModel = new ResultModel();
        LoginResponse response = new LoginResponse();
        String name = userAdaptor.getUserName();
        response.setNikename(name);
        resultModel.setModel(response);
        return resultModel;
    }
}
