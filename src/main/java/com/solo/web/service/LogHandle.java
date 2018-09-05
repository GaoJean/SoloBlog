package com.solo.web.service;

import com.solo.web.service.loginservice.LoginService;
import org.springframework.stereotype.Service;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
@Service
public class LogHandle extends LoginService {
    @Override
    public String login(String name) {
        logger.info("name={}",name);
        return  null;
    }
}
