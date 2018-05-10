package com.solo.common.util;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;

/**
 * 测试用Mock工具
 *
 */
public class MockUtil {

    private static Map<String, Object> mockList = new HashMap<String, Object>();

    /**
     * 
     * @param clazz 传入需要mock的类型
     * @return	返回该类型的Mock实例
     */
    public static <T> T createMock(Class<T> clazz) {
        T mockInstance = EasyMock.createMock(clazz);
        mockList.put(clazz.getSimpleName(), mockInstance);
        return mockInstance;
    }

    /**
     * 获取Mock对象实例
     * @param clazz 需要获取Mock对象的类型
     * @return	返回Mock对象
     */
    public static <T> T getMockInstance(Class<T> clazz) {
        return (T) mockList.get(clazz.getSimpleName());
    }

    /**
     * 重置Mock对象的行为
     * @param 	需要重置的mock对象，可穿多个。
     * @return	返回Mock对象
     */
    public static void resetMock(Object... mocks) {
        EasyMock.resetToDefault(mocks);
    }

}
