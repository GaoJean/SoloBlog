package com.solo.web.controller;

import com.solo.common.exception.BusinessException;
import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.adaptor.LoginAdaptor;
import com.solo.web.adaptor.UserAdaptor;
import com.solo.web.entity.request.user.LoginRequest;
import com.solo.web.entity.response.user.LoginResponse;
import com.solo.web.service.BaseHandle;
import com.solo.web.service.HandleRouter;
import com.solo.web.service.loginservice.LoginService1;
import com.solo.web.service.loginservice.LoginService2;
import com.solo.web.service.loginservice.LoginService3;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private LoginAdaptor loginAdaptor;

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

    @GetMapping("/testlogin")
    @ApiOperation(value = "testlogin",notes = "登录test")
    @Verification(token = false)
    public ResultModel testlogin(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "type") Integer type) throws BusinessException {
        return success(loginAdaptor.login(name,type));
    }
}
