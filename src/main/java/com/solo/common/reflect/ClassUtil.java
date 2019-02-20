package com.solo.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author gaojian
 * @Date 2019/2/13
 */
public class ClassUtil {

    /**
     * 获取方法信息
     *
     * @param obj
     */
    public static void printMethodMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println("----------------------------------------------");
        System.out.println("类名称是：" + c.getName());

        //获取该类所申明的所有方法
        Method[] methods = c.getDeclaredMethods();

        //获取public权限的方法
        //c.getMethods();

        for (Method method : methods) {
            //获取该方法的返回类类型
            Class returnType = method.getReturnType();
            System.out.print("返回类型：" + returnType.getName() + "   ");

            System.out.print(method.getName() + "(");

            //获取参数类型
            Class[] paramTypes = method.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + ",");
            }
            System.out.println(")");
        }

    }

    /**
     * 获取成员变量信息
     *
     * @param obj
     */
    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        /*
         * 成员变量也是对象 java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields() 获取所有public的成员变量信息
         * getDeclaredFields() 获取所有已申明的成员变量信息
         */
        c.getFields();
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            Class fieldType = field.getType();
            String typeName = fieldType.getTypeName();

            String fieldName = field.getName();

            System.out.println(typeName + "  " + fieldName);
        }
    }

    /**
     * 获取构造函数信息
     *
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();

        /*
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         */
        Constructor[] constructors = c.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName()+"(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName()+",");
            }
            System.out.println(")");
        }
    }
}
