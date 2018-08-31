package com.solo.web.controller.jenkins;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.adaptor.JenkinsAdaptor;
import com.solo.web.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @Author gaojian
 * @Date 2018/8/27
 */
@RestController
@RequestMapping("/jenkins")
public class JenkinsController extends BaseController {

    @Autowired
    private JenkinsAdaptor jenkinsAdaptor;

    @GetMapping("/job/get")
    @ApiOperation(value = "getJob", notes = "jenkins get job")
    @Verification(token = false)
    public ResultModel getJob() throws IOException, URISyntaxException {
        String jobName = "c-dev-healthapp-vaccine";
        return success(jenkinsAdaptor.getJob(jobName));
    }

    @GetMapping("/job/list")
    @ApiOperation(value = "jobList", notes = "jenkins get job")
    @Verification(token = false)
    public ResultModel jobList() throws IOException, URISyntaxException {
        return success(jenkinsAdaptor.jobList());
    }


    @GetMapping("/job/jobGet1111")
    @ApiOperation(value = "jobGet1111", notes = "jenkins get job")
    @Verification(token = false)
    public ResultModel jobGet1111() throws IOException, URISyntaxException {
        String jobName = "c-dev-healthapp-vaccine";
        return success(jenkinsAdaptor.getStartTImeAndEndTime(jobName));
    }

    @GetMapping("/job/lastSuccessConsole")
    @ApiOperation(value = "getJobLastSuccessConsole", notes = "getJobLastSuccessConsole")
    @Verification(token = false)
    public ResultModel getJobLastSuccessConsole() throws IOException {
        String jobName = "c-dev-healthapp-vaccine";
        return success(jenkinsAdaptor.getJobLastSuccessConsole(jobName));
    }




}
