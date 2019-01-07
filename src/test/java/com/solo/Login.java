package com.solo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author gaojian
 * @Date 2018/10/16
 */
public class Login {

    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("");
        InputStream inputStream = resource.getInputStream();
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource(""));
    }
}
