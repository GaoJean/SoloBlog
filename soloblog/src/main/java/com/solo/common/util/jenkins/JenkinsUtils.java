package com.solo.common.util.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author gaojian
 * @Date 2018/8/29
 */
public class JenkinsUtils {

    static final Logger LOG = LoggerFactory.getLogger(JenkinsUtils.class);
    private static JenkinsServer jenkins;

    public synchronized void getInstance() {
        if (jenkins == null) {
            try {
                jenkins = new JenkinsServer(
                        new URI("http://jenkins.doctorwork.com/"),
                        "dev",
                        "doctorwork");

            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取jenkins所有任务job
     *
     * @return
     */
    public static Map<String, Job> getJobs() {
        Map<String, Job> jobs = null;
        try {
            jobs = jenkins.getJobs();
        } catch (IOException e) {
            LOG.error("get jobs message fail:", e);
        }
        return jobs;
    }

    /**
     * 根据任务名称获取该jobName任务信息
     *
     * @param jobName
     * @return
     */
    public static JobWithDetails getJobWithDetails(String jobName) {
        Map<String, Job> jobs = getJobs();
        JobWithDetails job = null;
        try {
            job = jobs.get(jobName).details();
        } catch (IOException e) {
            LOG.error("get job " + jobName + " fail", e);
        }
        return job;
    }

    /**
     * @param jobName 需要创建的项目名
     * @param config  配置文件内容
     * @return
     */
    public static Boolean createJob(String jobName, String config) {
        boolean flag = false;

        //创建连接

        try {
            jenkins.createJob(jobName, config);

            flag = true;
        } catch (IOException e) {
            LOG.error("创建任务失败", e);
        } finally {
            jenkins.close();
        }

        return flag;
    }

    /**
     * 根据任务名称获取第number次任务构建日志
     *
     * @param jobName
     * @param number
     * @return
     */
    public static String getJobLog(String jobName, int number) {

        JobWithDetails job = getJobWithDetails(jobName);
        Build buildByNumber = job.getBuildByNumber(number);
        String outputText = null;
        BuildWithDetails details = null;
        try {

            details = buildByNumber.details();
            outputText = details.getConsoleOutputText();
        } catch (IOException e) {
            LOG.error("get jobName " + jobName + " the number " + number + " fail", e);
        }

        return outputText;
    }

    /**
     * 根据任务名获取指定构建的开始时间以及结束时间
     * number=0  flag=true  则获最后一次构建成功的开始结束时间
     * number=0 flag=false 则获取最后一次构建失败的开始结束时间
     *
     * @param jobName
     * @param number  number等于0则返回最后一次构建时间
     * @param flag    是否获取构建成功的结果
     * @return
     */
    public static Map<String, Long> getStartAndEndTime(String jobName, int number, Boolean flag) {


        long startTime = 0;
        long duration = 0;
        try {
            JobWithDetails job = getJobWithDetails(jobName);
            Build buildByNumber = job.getBuildByNumber(number);
            startTime = buildByNumber.details().getTimestamp();
            duration = buildByNumber.details().getDuration();
        } catch (IOException e) {
            LOG.error("get job startTime and endTime exception :", e);
        }


        Map<String, Long> data = new HashMap<String, Long>();
        data.put("startTime", startTime);
        data.put("duration", duration);
        return data;
    }

    /**
     * 获取指定构建号构建的job是否构建成功
     *
     * @param jobName
     * @param number
     * @return
     */
    public static boolean isSuccess(String jobName, int number) {

        int LastSuccessfulNumber = 0;
        int LastUnsuccessfulNumber = 0;

        JobWithDetails job = getJobWithDetails(jobName);
        LastSuccessfulNumber = job.getLastSuccessfulBuild().getNumber();
        LastUnsuccessfulNumber = job.getLastUnsuccessfulBuild().getNumber();

        boolean flag = false;
        if (LastSuccessfulNumber == number) {
            flag = true;
        }
        if (LastUnsuccessfulNumber == number) {
            flag = false;
        }
        return flag;
    }

    /**
     * 根据job名字删除job
     *
     * @param jobName
     * @return
     */
    public static boolean delJob(String jobName) {
        Boolean flag = false;
        try {
            jenkins.deleteJob(jobName);
            flag = true;
        } catch (IOException e) {
            LOG.error("del job name " + jobName + " fail", e);
        } finally {
            jenkins.close();
        }
        return flag;
    }

    /**
     * 根据任务名称更新该任务配置
     *
     * @param jobName
     * @param config
     * @return
     */
    public static boolean updateJob(String jobName, String config) {
        Boolean flag = false;
        try {
            jenkins.updateJob(jobName, config);
            flag = true;
        } catch (IOException e) {
            LOG.error("update job name " + jobName + " fail", e);
        } finally {
            jenkins.close();
        }
        return flag;
    }

    /**
     * 根据任务名称查看某一次构建是否完成
     *
     * @param number  构建数
     * @param jobName 任务名称
     * @return
     */
    public static boolean isFinished(String jobName, int number) {
        boolean flag = false;
        if (number <= 0) {
            LOG.error("number must gt 0");
            return false;
        }

        try {

            JobWithDetails job = getJobWithDetails(jobName);
            Build buildByNumber = job.getBuildByNumber(number);

            if (null != buildByNumber) {
                BuildWithDetails details = buildByNumber.details();
                if (null != details) {
                    flag = details.isBuilding();
                } else {
                    flag = true;
                }
            } else {
                flag = true;
            }

            return !flag;
        } catch (Exception e) {
            LOG.error("get jobName" + jobName + " the " + number + " result fail", e);
        }

        return false;
    }
}
