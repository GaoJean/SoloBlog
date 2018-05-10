package com.solo.common.util;

import java.util.UUID;

/**
* 
* @ClassName: GenerateUUIDUtil
* @Description: TODO
* @author GaoJean
* @date 2017年10月23日 
* 
*/
public class GenerateUUIDUtil {

    /**
     * 获取主键
     * @return
     */
    public static String randomPK() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

}
 