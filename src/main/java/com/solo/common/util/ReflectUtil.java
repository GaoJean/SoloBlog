package com.solo.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>反射工具类</p>
 */
public class ReflectUtil {
	private static final Log logger = LogFactory.getLog(ReflectUtil.class);

	/**
	 * <p>通过反射设置set某个类属性值</p>
	 * 
	 * @author 来自网络
	 * @param target 类
	 * @param fname 类属性名
	 * @param ftype 
	 * @param fvalue 属性值
	 */
	public static void setFieldValue(Object target, String fname, Class<?> ftype, Object fvalue) { 
		// 设置字段值 如：username 字段,setUsername(String username)
		if (target == null || fname == null || "".equals(fname) || (fvalue != null && !ftype.isAssignableFrom(fvalue.getClass()))) {// 如果类型不匹配，直接退出
			return;
		}
		Class<? extends Object> clazz = target.getClass();
		try { // 先通过setXxx()方法设置类属性值
			String methodname = "set" + Character.toUpperCase(fname.charAt(0)) + fname.substring(1);
			Method method = clazz.getDeclaredMethod(methodname, ftype); // 获取定义的方法
			if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
				method.setAccessible(true);
			}
			method.invoke(target, fvalue); // 执行方法回调
		} catch (Exception me) {// 如果set方法不存在，则直接设置类属性值
			if (logger.isDebugEnabled()) {
				logger.debug(me);
			}
			try {
				Field field = clazz.getDeclaredField(fname); // 获取定义的类属性
				if (!Modifier.isPublic(field.getModifiers())) { // 设置非共有类属性权限
					field.setAccessible(true);
				}
				field.set(target, fvalue); // 设置类属性值
			} catch (Exception fe) {
				if (logger.isDebugEnabled()) {
					logger.debug(fe);
				}
			}
		}
	}
	
	/**
	 * <p>通过反射获取get某个类属性值</p>
	 * 
	 * @author 来自网络
	 * @param target 类
	 * @param fname 类属性名
	 * @param clazz 传入的class
	 * @return 属性值
	 */
	public static Object getObjFieldValue(Object target, String fname, Class<?> clazz) {
		// 获取字段值  如：username 字段,getUsername()
		if (target == null || fname == null || "".equals(fname)) {
			return null;
		}
		if (clazz == null) {
			clazz = target.getClass();
		}
		try {
			// 先通过getXxx()方法获取类属性值
			String methodname = "get" + Character.toUpperCase(fname.charAt(0)) + fname.substring(1);
			Method method = clazz.getDeclaredMethod(methodname); // 获取定义的方法
			if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
				method.setAccessible(true);
			}
			return method.invoke(target); // 方法回调，返回值
		} catch (Exception me) {// 如果get方法不存在，则直接获取类属性值
			if (logger.isDebugEnabled()) {
				logger.debug(me);
			}
			try {
				Field field = clazz.getDeclaredField(fname); // 获取定义的类属性
				if (!Modifier.isPublic(field.getModifiers())) { // 设置非共有类属性权限
					field.setAccessible(true);
				}
				return field.get(target);// 返回类属性值
			} catch (Exception fe) {
				if (logger.isDebugEnabled()) {
					logger.debug(fe);
				}
				// 没有找到该属性，尝试到父类中去找
				Class<?> superClass = clazz.getSuperclass();
				if (superClass == Object.class) { // 父类是Object，直接返回null
					return null;
				}
				try {
					return getObjFieldValue(target, fname, superClass);
				} catch (Exception ie) {
					if (logger.isDebugEnabled()) {
						logger.debug(ie);
					}
				}
			}
		}
		return null;
	}
}
