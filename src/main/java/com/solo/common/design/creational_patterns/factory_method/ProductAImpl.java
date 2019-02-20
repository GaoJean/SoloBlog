package com.solo.common.design.creational_patterns.factory_method;

/**
 * @Author gaojian
 * @Date 2019/1/8
 */
public class ProductAImpl implements ProductInterface{
    public ProductAImpl() {
        System.out.println("ProductAImpl!");
    }

    @Override
    public String create() {
        return "Create ProductAImpl!";
    }
}
