package com.solo.common.util.jenkins;

import com.offbytwo.jenkins.JenkinsServer;

import java.net.URI;

/**
 * @Author gaojian
 * @Date 2018/8/28
 */
public class JenkinsServerUtil {

    public static JenkinsServer createJenkinsServer(String url) {
        return new JenkinsServer(URI.create(url));
    }

    public static JenkinsServer createJenkinsServer(String url,String name,String password) {
        return new JenkinsServer(URI.create(url),name,password);
    }

}
