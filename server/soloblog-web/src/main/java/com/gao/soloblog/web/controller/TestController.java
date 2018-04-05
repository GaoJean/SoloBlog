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
}
