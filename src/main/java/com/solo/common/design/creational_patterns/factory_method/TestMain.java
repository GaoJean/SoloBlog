package com.solo.common.design.creational_patterns.factory_method;

/**
 * 工厂方法模式（工厂模式、多态模式）
 * <p>
 * eg:
 * 1.LogFactory
 *
 *
 * @Author gaojian
 * @Date 2019/1/8
 */
public class TestMain {
    public static void main(String[] args) {
        FactoryInterface factory = new FactoryAImpl();
        System.out.println(factory.createProduct().create());
    }
}
