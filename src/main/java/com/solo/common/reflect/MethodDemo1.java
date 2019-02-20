package com.solo.common.reflect;

import java.lang.reflect.Method;

/**
 * 方法的反射
 *
 * @Author gaojian
 * @Date 2019/2/14
 */
public class MethodDemo1 {

    public static void main(String[] args) {

        A a = new A();
        Class c = a.getClass();
        try {

            /*
             * print(int a, int b)
             */
            //Method m = c.getMethod("print",new Class[]{int.class,int.class});
            Method m = c.getMethod("print", int.class, int.class);

            //效果和执行a.print(10,20)一样
            //Object o = m.invoke(a,new Object[]{10,20});
            Object o = m.invoke(a, 10, 20);

            /*
             * print(String a, String b)
             */
            Method m1 = c.getMethod("print", String.class, String.class);
            Object o1 = m1.invoke(a, "hello", "world");

            /*
             * print()
             */
            Method m2 = c.getMethod("print");
            Object o2 = m2.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {

    public void print() {
        System.out.println("hello reflect!");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a + "," + b);
    }
}
