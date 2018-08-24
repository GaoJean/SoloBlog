package com.solo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.solo.common.util.DateUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SoloblogApplication.class)
@WebAppConfiguration
public class BaseTest {


    // HttpResult属性errcode的json path
    protected static final String JSON_PATH_ERR_CODE = "$.errcode";

    // HttpResult属性errmsg的json path
    protected static final String JSON_PATH_ERR_MSG = "$.errmsg";

    // HttpResult成功时errcode的值
    protected static final Integer SUCCESS_CODE = 0;

    // HttpResult成功时errmsg的值
    protected static final String SUCCESS_MSG = "success";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected void print(Object object) {
        String json = JSON.toJSONStringWithDateFormat(object, DateUtils.DATE_TIME,
                SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue, SerializerFeature.PrettyFormat);
        logger.info("\n{}", json);
    }
}
