package com.solo.web.adaptor;

import com.alibaba.fastjson.JSONObject;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.model.*;
import com.solo.web.service.jenkins.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author gaojian
 * @Date 2018/8/27
 */
@Component
public class JenkinsAdaptor {
    private static JenkinsServer jenkinsServer;
    @Autowired
    private JenkinsService jenkinsService;

    private static final String url = "http://jenkins.doctorwork.com/";

    JenkinsHttpClient jenkinsHttpClient;


    public String getJob(String env, String jobName) throws IOException, URISyntaxException {
        JenkinsServer jenkins = getInstance();
        Map<String, Job> jobs = jenkins.getJobs();
        JobWithDetails jobDetail = jobs.get(jobName).details();

        Build lastCompletedBuild = jobDetail.getLastBuild();
       /* lastCompletedBuild.getQueueId();
        lastCompletedBuild.getUrl();
        lastCompletedBuild.getNumber();*/
        //TestReport testReport = lastCompletedBuild.getTestReport();

        System.out.println(" --- TestReport ---");
        System.out.println("queueId: " + lastCompletedBuild.getQueueId());
        System.out.println(" url: " + lastCompletedBuild.getUrl());
        System.out.println(" number: " + lastCompletedBuild.getNumber());

        //TestResult testResult = lastCompletedBuild.getTestResult();
        System.out.println(" --- TestResult ---");

        /*System.out.println(" PassCount: " + testResult.getPassCount());
        System.out.println(" failCount: " + testResult.getFailCount());
        System.out.println(" skipCount: " + testResult.getSkipCount());
        System.out.println("  duration: " + testResult.getDuration());
        System.out.println("   isEmpty: " + testResult.isEmpty());*/
        return JSONObject.toJSONString("hello");

    }

    public static Map<String, Long> getStartTImeAndEndTime(String jobName) throws IOException, URISyntaxException {

        JenkinsServer jenkins = getInstance();
        Map<String, Job> jobs = jenkins.getJobs();
        Job job = jobs.get(jobName);
        JobWithDetails jobDetail = job.details();
        List<Build> buildByNumber =  jobDetail.getBuilds();
        long startTime = buildByNumber.get(0).details().getTimestamp();
        long duration = buildByNumber.get(0).details().getDuration();

        Map<String, Long> data = new HashMap<>();
        data.put("startTime", startTime);
        data.put("duration", duration);
        return data;
    }

   /* private static JenkinsServer getInstance() throws URISyntaxException {
        return new JenkinsServer(new URI(url));
    }*/

    public synchronized static JenkinsServer getInstance() {
        if (jenkinsServer == null) {
            try {
                jenkinsServer = new JenkinsServer(
                        new URI("http://jenkins.doctorwork.com/"),
                        "dev",
                        "doctorwork");

            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return jenkinsServer;
    }

    public List<String> jobList() throws IOException {
        List<String> jobList = new ArrayList<>();
        JenkinsServer jenkins = getInstance();
        Map<String, Job> jobs = jenkins.getJobs();
        for (String job : jobs.keySet()){
            jobList.add(job);
        }
        return jobList;
    }
}
