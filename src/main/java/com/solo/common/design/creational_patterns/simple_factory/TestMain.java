package com.solo.common.design.creational_patterns.simple_factory;

/**
 * 简单工厂模式
 * <p>
 * eg:
 * 1.java.text.DateFormat
 * 2.获取不同加密算法的密钥生成器:
 *
 * @Author gaojian
 * @Date 2019/1/8
 */
public class TestMain {
    public static void main(String[] args) {
        Factory factory = new Factory();
        ProductAImpl A = (ProductAImpl) factory.createProduct("A");
        A.create();
    }
}
