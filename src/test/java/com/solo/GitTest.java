package com.solo;

import com.google.common.collect.Lists;
import com.solo.common.http.HttpHandle;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.TagCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author gaojian
 * @Date 2018/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GitTest extends BaseTest {
    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
@Autowired
    HttpHandle httpHandle;
    @Test
    public void commitId() {
        File repoDir = new File("C:\\Users\\gaojian\\doctorwork\\workspace\\shorturl-web\\.git");
        Git git = null;
        Map<String, Object> result = new HashMap<>();
        try {
            git = Git.open(repoDir); // git对象 方式一
            // repo = new FileRepository(repoDir.getAbsolutePath());
            // Git git = new Git(repo); // 方式二
            // 过滤某个人提交的log
            git.pull();
            LogCommand log = git.log();
            Iterable<RevCommit> results = log.call(); // 获取所有的提交
            if (results == null) {
                print("error");
            }
            List<RevCommit> newar = Lists.newArrayList(results);
            RevCommit commit = newar.get(0);
            String commitId = commit.getId().getName();
            String fullMessage = commit.getFullMessage();
            String authorName = commit.getAuthorIdent().getName();

            result.put("commitId", commitId);
            result.put("message", fullMessage);
            result.put("author", authorName);
            result.put("time", format.format(commit.getAuthorIdent().getWhen()));
            print(result);


        } catch (Exception e) {
            logger.error(e.getMessage() + " : " + repoDir.getAbsolutePath());
        } finally {
            if (git != null) {
                git.close();
            }
        }
    }

    @Test
    public void tag() throws IOException, GitAPIException {
        File repoDir = new File("C:\\Users\\gaojian\\doctorwork\\workspace\\shorturl-web\\.git");
        Git git = Git.open(repoDir);
        TagCommand tagCommand = git.tag();

        RevTag revTag = (RevTag) tagCommand.call();
        String tagName = revTag.getTagName();
        print(tagName);
        List<Ref> call = git.tagList().call();
        // 所有的tag
        if (null == call || call.size() < 0) {
            print("error");
        }
        List<String> tagNames = call.stream().map(ref -> {
            String name = ref.getName();
            String trueName = name.substring(name.lastIndexOf("/") + 1, name.length());
            return trueName;
        }).collect(Collectors.toList());
        //需规定 tag 格式为 xxx-x.x.x
        String maxTag = "";
        for (int i = 0; i < tagNames.size() - 1; i++) {
            /*if (compareVersion(tagNames.get(i), tagNames.get(i + 1)) > 0) {
                maxTag = tagNames.get(i);
            } else {
                maxTag = tagNames.get(i + 1);
            }*/
            print(tagNames.get(i));
        }
        git.close();
    }


}
