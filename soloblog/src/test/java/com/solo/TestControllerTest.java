package com.solo;

import com.solo.web.controller.TestController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author gaojian
 * @Date 2018/8/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest extends BaseTest {

    private MockMvc mockMvc;
    @Autowired
    TestController controllerTest;

    @Autowired
    private WebApplicationContext context;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    //mockMvc测试
    @Test
    public void testMock() throws Exception {

//        MockHttpServletRequestBuilder.accept();
        MvcResult mvcResult =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/main/test")
                                .param("id", "1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)

                )
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath(JSON_PATH_ERR_CODE, Is.is(SUCCESS_CODE)))
//                        .andExpect(MockMvcResultMatchers.jsonPath(JSON_PATH_ERR_MSG, Is.is(SUCCESS_MSG)))
                        .andReturn();
        print(mvcResult.getResponse().getContentAsString());
    }

    //常规测试
    @Test
    public void test2() {
        print(controllerTest.testMain("1"));
    }

    /**
     * 性能测试
     * @PerfTest
     *
     * invocations：执行次数n，与线程数量无关，默认值为1
     * threads：线程池数量n，并发执行n个线程
     * duration：重复地执行时间n，测试至少执行n毫秒
     *
     * @Required
     * throughput：吞吐要求n，要求每秒至少执行n个测试
     * average：平均执行时间n，要求平均执行时间不超过n毫秒
     * max：最大执行时间n，要求最大的执行时间不超过n毫秒
     * totalTime：总执行时间n，要求总的执行时间不超过n毫秒
     * median：50%平均执行时间n，要求所有执行的50%测试平均执行时间不超过n毫秒
     * percentile90：90%平均执行时间n，要求所有执行的90%测试平均执行时间不超过n毫秒
     * percentile95：95%平均执行时间n，要求所有执行的95%测试平均执行时间不超过n毫秒
     * percentile99：99%平均执行时间n，要求所有执行的99%测试平均执行时间不超过n毫秒
     * percentiles：表达式"a:n,b:m"，要求a%的测试不超过n毫秒，b%的测试不超过m毫秒
     *
     * 在target/contiperf-report/index.html可查看统计页面
     */
    @Test
    //1个线程 执行1次
    @PerfTest(invocations = 1,threads = 1)
    public void test3() {
        print(controllerTest.testMain("1"));
    }
}
