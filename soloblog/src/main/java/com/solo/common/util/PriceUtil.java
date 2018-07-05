package com.solo.common.util;

import java.math.BigDecimal;

/**
 * 价格工具类
 * @Author gaojian
 * @Date 2018/7/5
 */
public class PriceUtil {


    /**
     * 金额由double转换为integer类型
     * @param price （分）
     */
    public Integer amout2Integer(Double price){
        BigDecimal bigDecimal = new BigDecimal(price);
        BigDecimal bignum2 = new BigDecimal("100");
        return bigDecimal.multiply(bignum2).intValue();
    }
}
