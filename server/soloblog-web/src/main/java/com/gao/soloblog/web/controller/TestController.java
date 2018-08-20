package com.gao.soloblog.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gao.soloblog.common.model.ResultModel;
import com.gao.soloblog.common.util.logger.Logger;
import com.gao.soloblog.common.util.logger.LoggerFactory;
import com.gao.soloblog.framework.verify.Verification;
import com.gao.soloblog.web.entity.BaseResponse;
import com.gao.soloblog.web.entity.request.WriteJournalRequest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/journal")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    /**
     * 编写日志
     * @param request
     * @return
     */
    @ApiOperation(value="编写日志", notes="编写日志",response =BaseResponse.class)
    @RequestMapping(value="/test",method=RequestMethod.POST)
    @Verification(token = false)
    public ResultModel writeJournal(@RequestBody WriteJournalRequest request){
        BaseResponse response = new BaseResponse();
        logger.info("hello");
        response.setSuccess("0");
        return new ResultModel(response);
    }

    public static void main(String[] args) {
        Map<String,Object> param = BeanMapperUtil.map(req,Map.class);
    }

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
}
