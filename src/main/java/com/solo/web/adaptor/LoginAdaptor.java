package com.solo.web.adaptor;

import com.solo.common.exception.BusinessException;
import com.solo.web.service.HandleRouter;
import com.solo.web.service.LogHandle;
import com.solo.web.service.loginservice.LoginService1;
import com.solo.web.service.loginservice.LoginService2;
import com.solo.web.service.loginservice.LoginService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
@Component
public class LoginAdaptor {


    @Autowired
    private LoginService1 loginService1;
    @Autowired
    private LoginService2 loginService2;
    @Autowired
    private LoginService3 loginService3;

    @Autowired
    private LogHandle logHandle;

    private HandleRouter handleRouter = new HandleRouter();

    /**
     * 初始化数据
     */
    @PostConstruct
    public void init() {
        initRouter();
    }

    /**
     * 初始化订单处理路由规则
     */
    @PostConstruct
    private void initRouter() {

        HandleRouter newRouter = new HandleRouter();
        // 订单日志记录(记录订单请求日志，handler继续)
        newRouter.rule().handler(this.logHandle).next();
        //普通订单
        newRouter.rule().type(2).handler(this.loginService2).end();
        //基因检测类型订单
        newRouter.rule().type(1).handler(this.loginService1).end();
        //增值订单
        newRouter.rule().type(3).handler(this.loginService3).end();
        this.handleRouter = newRouter;
    }

    public String login(String name,Integer type) throws BusinessException {
        return handleRouter.login(name,type);
    }

}
