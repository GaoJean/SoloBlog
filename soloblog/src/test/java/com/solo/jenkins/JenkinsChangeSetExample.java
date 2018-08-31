package com.solo.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;
import com.solo.common.util.DateUtils;
import com.solo.common.util.jenkins.JenkinsServerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @Author gaojian
 * @Date 2018/8/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsChangeSetExample {
    @Test
    public void shouldAddStringParamToAnExistingJob() throws IOException {
        // JenkinsServerUtil js = new
        // JenkinsServerUtil(URI.create("http://localhost:10090/"));
        /*JenkinsServer js = new
                JenkinsServer(URI.create("http://jenkins.doctorwork.com/"),
                "dev",
                "doctorwork");*/
        JenkinsServer js = JenkinsServerUtil.createJenkinsServer(
                "http://jenkins.doctorwork.com/","dev","doctorwork");

        // MavenJobWithDetails mavenJob = js.getMavenJob("javaee");
//        MavenJobWithDetails mavenJob = js.getMavenJob("c-dev-healthapp-vaccine");
        MavenJobWithDetails mavenJob = js.getMavenJob("c-dev-healthapp-vaccine");

        // BuildWithDetails details = mavenJob.getLastBuild().details();
        List<MavenBuild> mavenBuilds = mavenJob.getBuilds();
        for (MavenBuild build : mavenBuilds){

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

            System.out.println("Build duration: " + DateUtils.formatTimestamp(details.getDuration(),"HH:mm:ss"));
            System.out.println("Build result: " + details.getResult().name());
            System.out.println("Build times: " + DateUtils.formatTimestamp(details.getEstimatedDuration()));
//            System.out.println("Build status: " + details.getDescription());
//            System.out.println("Build status: " + details.getDescription());
//            System.out.println("Build status: " + details.getDescription());

            List<BuildCause> causes = details.getCauses();
            for (BuildCause buildCause : causes) {
                System.out.println("-----------------------");
                System.out.println(" Cause:" + buildCause.getShortDescription());
                System.out.println(" username:" + buildCause.getUserName());
                System.out.println(" userId:" + buildCause.getUserId());
            }
            System.out.println("==============================================");
            BuildChangeSet changeSet = details.getChangeSet();
            System.out.println("ChangeSet Kind:" + changeSet.getKind());
            System.out.println("Number of CS:" + changeSet.getItems().size());

            List<BuildChangeSetAuthor> culprits = details.getCulprits();
            if(culprits != null ){
                for (BuildChangeSetAuthor item : culprits) {
                    System.out.println(" Culprit item:");
                    System.out.println("   fullName: " + item.getFullName() + " url:" + item.getAbsoluteUrl());
                }

            }
            List<BuildChangeSetItem> items = changeSet.getItems();
            System.out.println("ChangeSet:");
            for (BuildChangeSetItem item : items) {
                System.out.println(" comment:" + item.getComment());
                System.out.println(" affectedPath:");
                for (String path : item.getAffectedPaths()) {
                    System.out.println(" Path:" + path);
                }
                System.out.println(" commitId:" + item.getCommitId());
                System.out.println(" date:" + item.getDate());
                System.out.println(" id:" + item.getId());
                System.out.println(" msg:" + item.getMsg());
                System.out.println(" timestamp:" + item.getTimestamp());
                System.out.println(" path:");
                for (BuildChangeSetPath changeSetPath : item.getPaths()) {
                    System.out.println("  CS: " + changeSetPath.getEditType() + " " + changeSetPath.getFile());
                }
                System.out.println(" Author:");
                System.out.println("    url:" + item.getAuthor().getAbsoluteUrl());
                System.out.println("    fullName:" + item.getAuthor().getFullName());
            }


            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
}
