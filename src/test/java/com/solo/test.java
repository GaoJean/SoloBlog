package com.solo;

import com.alibaba.fastjson.JSONArray;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author gaojian
 * @Date 2018/10/16
 */
public class test {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://git.doctorwork.com/api/v4/groups")
                .get()
                .addHeader("private-token", "H_tNdFFxP83H7qffoPAa")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = null;
        List<GroupVo> resultModel = null;
        try {
            response = client.newCall(request).execute();
            String body = new String(response.body().bytes());
            resultModel = JSONArray.parseArray(body, GroupVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> names = resultModel.stream().map(GroupVo::getName).collect(Collectors.toList());
        for (String name: names){
            System.out.println(name);
        }
    }
}
