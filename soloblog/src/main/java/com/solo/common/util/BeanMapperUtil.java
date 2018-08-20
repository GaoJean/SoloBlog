package com.solo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author gaojian
 * @Date 2018/8/13
 */
public class BeanMapperUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanMapperUtil.class);

    public static <T> T map(Object source, Class<T> targetClazz) {
        try {
            T target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> mapList(List<?> sourceList, Class<T> targetClazz) {
        if (sourceList == null || sourceList.size() == 0) {
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>();
        for (Object obj : sourceList) {
            list.add(map(obj, targetClazz));
        }
        return list;
    }

    public static HashMap<String, Object> convertToMap(Object obj)
            throws Exception {

        HashMap<String, Object> map = new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);

            Object o = fields[i].get(obj);
            if (o != null)
                map.put(varName, o);

            fields[i].setAccessible(accessFlag);
        }

        return map;
    }

}
