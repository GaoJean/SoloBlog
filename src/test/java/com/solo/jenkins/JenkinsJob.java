package com.solo.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;
import com.solo.BaseTest;
import com.solo.common.util.DateUtils;
import com.solo.common.util.jenkins.JenkinsServerUtil;
import com.solo.web.entity.response.user.LoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * @Author gaojian
 * @Date 2018/8/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsJob extends BaseTest {

    private static JenkinsServer jenkinsServer;

    @Before
    public synchronized void getInstance() {
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
    }


    @Test
    public void sortTest() throws Exception {
        /*String a = "release-1.0.9";
        String b = "release-1.0.10";
        Byte aaa = new Byte(a);
        Byte bbb = new Byte(b);
//        Long aa = Long.valueOf(a);
//        Long bb = Long.valueOf(b);
        System.out.println(aaa);
        System.out.println(bbb);

        if(aaa<bbb){
            System.out.println("ok");
        }*/

        List<String> list = new ArrayList<>();
        list.add("release-1.0.1");
        list.add("release-1.0.9");
        list.add("release-1.0.11.02");
        list.add("release-1.0.10");
        list.add("release-1.0.11.1");
        String max = "";
        for (int i = 0; i <list.size() -1; i++) {
            if(compareVersion(list.get(i),list.get(i+1)) >0){
                max = list.get(i);
            }else {
                max = list.get(i+1);
            }
        }
        System.out.println(max);
        /*List<String> a = list.stream().sorted(Comparator.).collect(Collectors.toList());

        System.out.println(a);*/
    }

    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) throws Exception {
        if (version1 == null || version2 == null) {
            throw new Exception("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("-");//注意此处为正则匹配，不能用"."；
        String[] versionArray2 = version2.split("-");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

    @Test
    public void getViews() throws IOException {

        Map<String, View> viewMap = jenkinsServer.getViews();
//        jenkinsServer.createView("testjen","<view _class=\"hudson.model.ListView\">\n" +
//                "<name>腾讯hr项目</name>\n" +
//                "<url>\n" +
//                "http://jenkins.qieyisheng.com/view/%E8%85%BE%E8%AE%AFhr%E9%A1%B9%E7%9B%AE/\n" +
//                "</url>\n" +
//                "</view>");
        //获取视图列表
        for (String name : viewMap.keySet()) {
            System.out.println("name = " + name);
            //获取视图下的job
            View view = viewMap.get(name);
            List<Job> viewJob = view.getJobs();
            for (Job job : viewJob) {
                System.out.println("    jobName:" + job.getName());
                System.out.println("    jobUrl:" + job.getUrl());
            }
        }
    }

    //todo
    @Test
    public void createView() throws IOException {
        String jobXml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<project>\n" +
                "  <keepDependencies>false</keepDependencies>\n" +
                "  <properties/>\n" +
                "  <scm class=\"hudson.scm.NullSCM\"/>\n" +
                "  <canRoam>false</canRoam>\n" +
                "  <disabled>false</disabled>\n" +
                "  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" +
                "  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
                "  <triggers/>\n" +
                "  <concurrentBuild>false</concurrentBuild>\n" +
                "  <builders/>\n" +
                "  <publishers/>\n" +
                "  <buildWrappers/>\n" +
                "</project>";
        String viewName = "testView";
        jenkinsServer.createView(viewName, jobXml);
    }

    @Test
    public void getJobListDetail() throws IOException {
        String jobName = "c-dev-healthapp-vaccine";
        MavenJobWithDetails mavenJob = jenkinsServer.getMavenJob(jobName);
        List<MavenBuild> mavenBuilds = mavenJob.getBuilds();
        for (MavenBuild build : mavenBuilds) {

            BuildWithDetails details = build.details();
            System.out.println("Build Number: " + details.getNumber());
            System.out.println("Build time: " + DateUtils.formatTimestamp(details.getTimestamp()));
            System.out.println("Build description: " + details.getDescription());
            //有时间
            //System.out.println("Build html: " + details.getConsoleOutputHtml());
            //没有时间
            //System.out.println("Build text: " + details.getConsoleOutputText());
            System.out.println("Build id: " + details.getId());
            System.out.println("Build #id: " + details.getDisplayName());
            System.out.println("Build building: " + details.isBuilding());

            System.out.println("Build duration: " + DateUtils.formatTimestamp(details.getDuration(), "HH:mm:ss"));
            System.out.println("Build result: " + details.getResult().name());
            System.out.println("Build times: " + DateUtils.formatTimestamp(details.getEstimatedDuration()));
            System.out.println("=======================================================================");
        }
    }

    @Test
    public void createJob() throws IOException {
        String date = DateUtils.formatTimestamp(new Date().getTime(), "yyyyMMddHHmmss");
        String jobName = "jenkins-test-" + date;
        String jobXml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<project>\n" +
                "  <keepDependencies>false</keepDependencies>\n" +
                "  <properties/>\n" +
                "  <scm class=\"hudson.scm.NullSCM\"/>\n" +
                "  <canRoam>false</canRoam>\n" +
                "  <disabled>false</disabled>\n" +
                "  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" +
                "  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
                "  <triggers/>\n" +
                "  <concurrentBuild>false</concurrentBuild>\n" +
                "  <builders/>\n" +
                "  <publishers/>\n" +
                "  <buildWrappers/>\n" +
                "</project>";
        jenkinsServer.createJob(jobName, jobXml, true);
    }

    @Test
    public void buildJob() throws IOException, InterruptedException, TimeoutException {
        String jobName = "c-dev-healthapp-vaccine";
        long timeOut = 20000;
        MavenJobWithDetails mavenJob = jenkinsServer.getMavenJob(jobName);
        mavenJob.build(true);

        print(mavenJob.details().getLastBuild().getNumber());

        boolean buildCompleted = false;
        Long timeoutCounter = 0L;
        while (!buildCompleted) {
            Thread.sleep(2000);
            timeoutCounter = timeoutCounter + 2000L;
            if (timeoutCounter > timeOut) {
                throw new TimeoutException("The job did not complete in the expected time");
            }
            //When the build is in the queue, the nextbuild number didn't change.
            //When it changed, It might still be running.
            JobWithDetails wrkJobData = jenkinsServer.getJob(jobName);
            int newNextNbr = wrkJobData.getNextBuildNumber();
            logger.info("New Next Nbr:" + newNextNbr);
            if (44 != newNextNbr) {
                logger.info("The expected build is there");
                boolean isBuilding = wrkJobData.getLastBuild().details().isBuilding();
                if (!isBuilding) {
                    buildCompleted = true;
                }else {
                    print(wrkJobData.getLastBuild().details().getConsoleOutputText());
                }
            }
        }


        print(buildCompleted);
    }

    @Test
    public void isSuccess() {
        int number = 413;
        boolean flag = false;
        String jobName = "android-health";
        try {
            JobWithDetails job = jenkinsServer.getJob(jobName);
            Build buildByNumber = job.getBuildByNumber(number);
            if (null != buildByNumber) {
                BuildWithDetails details = buildByNumber.details();
                print(details.getResult().name());
            } else {
                print(false);
            }

        } catch (Exception e) {
            logger.info("get jobName" + jobName + " the " + number + " result fail", e);
        }
    }

    @Test
    public void testGetJobXml() throws Exception {
//        jenkinsRule.getInstance().createProject(FreeStyleProject.class, JENKINS_TEST_JOB);
        String xmlReturned = jenkinsServer.getJobXml("jenkins-test1574a3ec6eff4d4fbb4fee8c306ddd7f");
        print(xmlReturned);
        assertTrue(xmlReturned.length() > 0);
    }

    @Test
    public void isFinished() {
        int number = 2;
        String jobName = "jenkins-test1574a3ec6eff4d4fbb4fee8c306ddd7f";

        boolean isBuilding = false;
        if (number <= 0) {
            throw new IllegalArgumentException("jodId must greater than 0!");
        }
        try {
            Map<String, Job> jobs = jenkinsServer.getJobs();
            JobWithDetails job = jobs.get(jobName).details();
            Build buildByNumber = job.getBuildByNumber(number);
            if (null != buildByNumber) {
                BuildWithDetails details = buildByNumber.details();
                if (null != details) {
                    isBuilding = details.isBuilding();
                } else {
                    isBuilding = true;
                }
            } else {
                isBuilding = true;
            }

            print(!isBuilding);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


}
