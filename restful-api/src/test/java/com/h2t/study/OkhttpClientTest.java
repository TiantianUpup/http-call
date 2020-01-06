package com.h2t.study;

import com.alibaba.fastjson.JSONObject;
import com.h2t.study.vo.UserVO;
import okhttp3.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * OkhttpClient测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/06 11:00
 */
public class OkhttpClientTest {
    private final String BASE_URL = "http://localhost:8082";
    private OkHttpClient client = new OkHttpClient();
    long start;

    @Before
    public void setUp() {
        start = System.currentTimeMillis();
    }

    @After
    public void tearDown() {
        System.out.println(String.format("cost %d msc", System.currentTimeMillis() - start));
    }

    @Test
    public void testPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        JSONObject json = new JSONObject();
        json.put("name", "hetiantian");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), String.valueOf(json));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody) //post请求
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testPut() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        UserVO userVO = UserVO.builder().name("h2t").id(11L).build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                JSONObject.toJSONString(userVO));
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testDelete() throws IOException {
        String api = "/api/user/7";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testUpload() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "docker_practice.pdf",
                        RequestBody.create(MediaType.parse("multipart/form-data"),
                                new File("C:/Users/hetiantian/Desktop/学习/docker_practice.pdf")))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)  //默认为GET请求，可以不写
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }


    @Test
    public void testGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder()
                .url(url)
                .get()  //默认为GET请求，可以不写
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
//        OkHttpResponse okHttpResponse = FastjsonUtil.deserializeToObj(response.body().string(), OkHttpResponse.class);
//        List<FilesPO> filesPOS = FastjsonUtil.deserializeToList(okHttpResponse.getData().toString(), FilesPO.class);
//        for (FilesPO filesPO : filesPOS) {
//            System.out.println(filesPO);
//        }
    }
}
