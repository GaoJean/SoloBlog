package com.solo.common.design.creational_patterns.simple_factory;

/**
 * @Author gaojian
 * @Date 2019/1/8
 */
public class ProductBImpl implements ProductInterface {
    public ProductBImpl() {
        System.out.println("ProductBImpl");
    }

    @Override
    public void create() {
        System.out.println("Create ProductBImpl!");
    }
}
