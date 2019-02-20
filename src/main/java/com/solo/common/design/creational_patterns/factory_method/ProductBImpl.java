package com.solo.common.design.creational_patterns.factory_method;

/**
 * @Author gaojian
 * @Date 2019/1/8
 */
public class ProductBImpl implements ProductInterface{
    public ProductBImpl() {
        System.out.println("ProductBImpl!");
    }

    @Override
    public String create() {
        return "Create ProductBImpl!";
    }
}
