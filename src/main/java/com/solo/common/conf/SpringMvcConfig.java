package com.solo.common.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author gaojian
 * @Date 2019/1/7
 */
@SpringBootConfiguration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TestInterceptor testInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Session拦截器
        // 开放给杏仁的接口，验签拦截
        registry.addInterceptor(testInterceptor).addPathPatterns("/**");
    }
}
