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
public class UserController extends BaseController{

    @Autowired
    private UserAdaptor userAdaptor;

    @PostMapping("/login")
    @ApiOperation(value = "login",notes = "登录")
    @Verification(token = false)
    public ResultModel login(@RequestBody LoginRequest request){
        logger.info("{用户管理UserController}[方法入：login(),参数：request = {}]",request.toString());
        LoginResponse response = new LoginResponse();
        String name = userAdaptor.getUserName();
        response.setNikename(name);
        return success(response);
    }

    @PostMapping("/get")
    @ApiOperation(value = "get",notes = "获取用户信息")
    @Verification(token = false)
    public ResultModel get(String userId){
        logger.info("{用户管理UserController}[方法入：get(),参数：userId = {}]",userId);
        ResultModel resultModel = new ResultModel();
        return resultModel;
    }
}
