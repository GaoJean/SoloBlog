package com.solo.web.service.loginservice;


import org.springframework.stereotype.Service;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
@Service
public class LoginService1 extends LoginService {
    @Override
    public String login(String name) {
        init();
        return "LoginService1";
    }
}
