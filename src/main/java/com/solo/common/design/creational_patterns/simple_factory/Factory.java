package com.solo.common.design.creational_patterns.simple_factory;

/**
 * @Author gaojian
 * @Date 2019/1/8
 */
public class Factory {

    public ProductInterface createProduct(String productName){
        if(productName.equals("A")){
            return new ProductAImpl();
        }else if(productName.equals("B")){
            return new ProductBImpl();
        }
        return null;
    }
}
