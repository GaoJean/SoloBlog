package com.solo.web.service.loginservice;

import com.solo.web.service.BaseHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
public abstract class LoginService implements BaseHandle {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 不处理具体的逻辑交由继承的class创建
     * @param name
     * @return
     */
    @Override
    public String login(String name) {
        return null;
    }

    public void init(){
        logger.info("init-----");
    }
}
