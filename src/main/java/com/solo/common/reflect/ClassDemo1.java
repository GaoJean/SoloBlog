package com.solo.common.reflect;

/**
 * @Author gaojian
 * @Date 2019/2/13
 */
public class ClassDemo1 {

    public static void main(String[] args) {
        Foo foo = new Foo();
        //任何一个类都是Class的实例对象，有三种表示方式

        Class c1 = Foo.class;
        System.out.println(c1);

        Class c2 = foo.getClass();
        System.out.println(c2);

        Class c3 = null;
        try {
            c3 = Class.forName("com.solo.common.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c3);
    }
}

class Foo{}
