package com.solo.common.design.creational_patterns.simple_factory;

/**
 * @Author gaojian
 * @Date 2019/1/8
 */
public class ProductAImpl implements ProductInterface {
    public ProductAImpl() {
        System.out.println("ProductAImpl");
    }

    @Override
    public void create() {
        System.out.println("Create ProductAImpl!");
    }
}
