package com.solo.common.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author gaojian
 * @Date 2019/2/14
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        ArrayList a1 = new ArrayList();
        ArrayList<String> a2 = new ArrayList();

        a2.add("hello");
        //a2.add(2);//错误的，加入不进去
        System.out.println("a2原始大小："+a2.size());
        System.out.println("a2原始值："+a2);

        Class c1 = a1.getClass();
        Class c2 = a2.getClass();

        //c1等于c2
        System.out.println(c1==c2);

        try {
            Method m1 = c1.getMethod("add",Object.class);
            m1.invoke(a2,20);//绕过编译操作，即绕过了泛型
            System.out.println("a2变化后的大小："+a2.size());
            System.out.println("a2变化后的值："+a2);
            //但不能用for遍历，会抛出异常，因为系统会拿泛型来对比
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
