package com.h2t.study;

import com.alibaba.fastjson.JSONObject;
import com.h2t.study.vo.UserVO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * HttpClient测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/06 15:23
 */
public class HttpClientTest {
    private final String BASE_URL = "http://localhost:8082";
    private CloseableHttpClient httpClient = HttpClientBuilder.create().build();

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
        HttpPost httpPost = new HttpPost(url);
        //UserVO userVO = UserVO.builder().name("hetiantian").build();
        JSONObject json = new JSONObject();
        json.put("name", "hetiantian");
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(new StringEntity(String.valueOf(json), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void testPut() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPut httpPut = new HttpPut(url);
        UserVO userVO = UserVO.builder().name("h2t").id(28L).build();
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPut);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void testDelete() throws IOException {
        String api = "/api/user/28";
        String url = String.format("%s%s", BASE_URL, api);
        HttpDelete httpDelete = new HttpDelete(url);
        CloseableHttpResponse response = httpClient.execute(httpDelete);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void testUpload1() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        File file = new File("C:/Users/hetiantian/Desktop/学习/docker_practice.pdf");
        FileBody fileBody = new FileBody(file);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", fileBody);  //addPart上传文件
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    @Test
    public void testUpload2() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        File file = new File("C:/Users/hetiantian/Desktop/学习/docker_practice.pdf");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        //addBinaryBody上传文件
        builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "docker_practice.pdf");
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    @Test
    public void testGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpGet httpGet = new HttpGet(url);
        //测试连接的取消

        //long begin = System.currentTimeMillis();
        CloseableHttpResponse response = httpClient.execute(httpGet);
//        while (true) {
//            if (System.currentTimeMillis() - begin > 1000) {
//                httpGet.releaseConnection();
//                System.out.println("task canceled");
//                break;
//            }
//        }

        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void testCancel() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpGet httpGet = new HttpGet(url);
        //测试连接的取消

        long begin = System.currentTimeMillis();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        while (true) {
            if (System.currentTimeMillis() - begin > 1000) {
                httpGet.releaseConnection();
                System.out.println("task canceled");
                break;
            }
        }

        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
