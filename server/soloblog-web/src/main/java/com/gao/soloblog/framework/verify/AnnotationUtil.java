package com.gao.soloblog.framework.verify;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationUtil {

    public static boolean containsAnnotation(Method method, Class<?> clazz) {
        Annotation[] annotations = method.getAnnotations();
        for(int i = 0; i < annotations.length; i++) {
            // Spring 会代理注�? 判断其子类类�?
            boolean suitableAnnotation = AnnotationUtil.isSuitableAnnotation(clazz, annotations[i]);
            if(suitableAnnotation == true) {
                return true;
            }
        }
        return false;
    }
    
    public static <T> T getAnnotationWithType(Method method, Class<T> clazz) {
        Annotation[] annotations = method.getAnnotations();
        for(int i = 0; i < annotations.length; i++) {
            // Spring 会代理注�? 判断其子类类�?
            boolean suitableAnnotation = AnnotationUtil.isSuitableAnnotation(clazz, annotations[i]);
            if(suitableAnnotation == true) {
                return clazz.cast(annotations[i]);
            }
        }
        return null;
    }

    public static boolean containsParameterWithAnnotation(Method method, Class<?> clazz) {
        int index = AnnotationUtil.getParameterIndexWithAnnotation(method, clazz);
        if(index != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static Class<?> getParameterWithAnnotationType(Method method, Class<?> clazz) {
        int index = AnnotationUtil.getParameterIndexWithAnnotation(method, clazz);
        Class<?>[] parameterTypes = method.getParameterTypes();
        return index != -1 ? parameterTypes[index] : null;
    }

    public static <T> T getActualParameterWithAnnotation(Method method, Class<?> clazz, T[] paramsWithIndex) {
        int index = AnnotationUtil.getParameterIndexWithAnnotation(method, clazz);
        return index != -1 ? paramsWithIndex[index] : null;
    }

    public static int getParameterIndexWithAnnotation(Method method, Class<?> clazz) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for(int i = 0; i < parameterAnnotations.length; i++) {
            for(int j = 0; j < parameterAnnotations[i].length; j++) {
                Annotation annotation = parameterAnnotations[i][j];
                // Spring 会代理注�? 判断其子类类�?
                boolean suit = AnnotationUtil.isSuitableAnnotation(clazz, annotation);
                if(suit == true) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isSuitableAnnotation(Class<?> clazz, Annotation annotation) {
        try {
            clazz.cast(annotation);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
