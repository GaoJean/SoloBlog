/**
 * Copyright (c) www.danlu.com 2016 All Rights Reserved.
 */
package com.solo.common.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 
 * @Filename: DoubleUtil.java
 * @Version: 1.0
 * @Author: WL
 */
public class DoubleUtil
{
    /**
     * 默认保留小数位数
     */
    public static final int DEFAULT_ROUND_COUNT = 2;
    public static final MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);

    /**
     * 计算方法 a + b = c； a,b同时null 返回 null
     * 
     * @param a
     * @param b
     * @return c
     */
    public static Double add(Double a, Double b)
    {
        if (null == a)
        {
            a = new Double(0);
        }
        if (null == b)
        {
            b = new Double(0);
        }

        BigDecimal ba = new BigDecimal(a, mathContext);
        BigDecimal bb = new BigDecimal(b, mathContext);
        return ba.add(bb).setScale(DEFAULT_ROUND_COUNT, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算方法 a - b = c； a,b不能是null，是null返回 null
     * 
     * @param a
     * @param b
     * @return c
     */
    public static Double sub(Double a, Double b)
    {
        if (a == null || b == null)
        {
            return null;
        }
        BigDecimal ba = new BigDecimal(a, mathContext);
        BigDecimal bb = new BigDecimal(b, mathContext);
        return ba.subtract(bb).setScale(DEFAULT_ROUND_COUNT, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
    }

    /**
     * 计算方法 a * b = c； a,b不能是null，是null返回 null
     * 
     * @param a
     * @param b
     * @return c
     */
    public static Double mul(Double a, Double b)
    {
        if (a == null || b == null)
        {
            return null;
        }
        return mul(a, b, DEFAULT_ROUND_COUNT);
        // BigDecimal ba = new BigDecimal(a, mathContext);
        // BigDecimal bb = new BigDecimal(b, mathContext);
        // return ba.multiply(bb).setScale(6,
        // BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算方法 a * b = c； a,b不能是null，是null返回 null
     * 
     * @param a
     * @param b
     * @param count 保留小数点后位数
     * @return c
     */
    public static Double mul(Double a, Double b, int cout)
    {
        if (a == null || b == null)
        {
            return null;
        }
        BigDecimal ba = new BigDecimal(a.toString(), mathContext);
        BigDecimal bb = new BigDecimal(b.toString(), mathContext);
        return ba.multiply(bb).setScale(cout, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算方法 a * b = c； a,b不能是null，是null返回 null
     * 
     * @param a 整数
     * @param b
     */
    public static Double mul(Integer a, Double b)
    {
        if (a == null || b == null)
        {
            return null;
        }
        BigDecimal ba = new BigDecimal(a, mathContext);
        BigDecimal bb = new BigDecimal(b, mathContext);
        return ba.multiply(bb).setScale(DEFAULT_ROUND_COUNT, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
    }

    /**
     * 计算方法 a / b = c； a,b不能是null，是null返回 null 并且b不能为0，除数不能是0
     * 
     * @param a
     * @param b
     * @param roundingMode 精确位数
     * @return c
     */
    public static Double div(Double a, Double b, int roundingMode)
    {
        if (a == null || b == null)
        {
            return null;
        }
        BigDecimal ba = new BigDecimal(a, mathContext);
        BigDecimal bb = new BigDecimal(b, mathContext);
        if (bb.equals(BigDecimal.ZERO))
        {
            throw new NullPointerException("除数不能为0.");
        }
        return ba.divide(bb, roundingMode, RoundingMode.HALF_UP)
            .setScale(DEFAULT_ROUND_COUNT, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算方法 a / b = c； a,b不能是null，是null返回 null 并且b不能为0，除数不能是0
     * 
     * @param a
     * @param b
     * @param roundingMode 精确位数
     * @return c
     */
    public static Double div(Integer a, Double b, int roundingMode)
    {
        if (a == null || b == null)
        {
            return null;
        }
        BigDecimal ba = new BigDecimal(a, mathContext);
        BigDecimal bb = new BigDecimal(b, mathContext);
        if (bb.equals(BigDecimal.ZERO))
        {
            throw new NullPointerException("除数不能为0.");
        }
        return ba.divide(bb, roundingMode, RoundingMode.HALF_UP)
            .setScale(DEFAULT_ROUND_COUNT, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 精确到小数点后面的位数
     * 
     * @param src 数据
     * @param count 小数点后面位数
     * @return
     */
    public static BigDecimal convertBigDecimal(double src, int count)
    {
        BigDecimal bd = new BigDecimal(String.valueOf(src), mathContext);
        return bd.setScale(count, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal convertBigDecimal(double src)
    {
        return convertBigDecimal(src, 2);
    }

    /**
     * 精确到小数点后面的位数(默认为小数点后面2位)
     * 
     * @param src 数据
     * @return
     */
    public static Double round(double src)
    {
        return convertBigDecimal(src).doubleValue();
    }

    /**
     * 精确到小数点后面的位数(默认为小数点后面2位)
     * 
     * @param src 数据
     * @return
     */
    public static Double round(double src, int count)
    {
        return convertBigDecimal(src, count).doubleValue();
    }

    public static String counvertToString(Double src)
    {
        if (src == null)
        {
            return "0.0";
        }
        return convertBigDecimal(src).toString();
    }

    public static String counvertToString(double src)
    {
        Double d = new Double(src);
        return counvertToString(d).toString();
    }

    public static void main(String[] args)
    {
        double a = mul(0.001, 19010388.0);
        System.out.println(a);
        System.out.println(convertBigDecimal(mul(mul(0.001, 5.0, 10), 0.00001, 10), 10));
    }
}
