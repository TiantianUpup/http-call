# http-call

### http-call介绍
httpclient和okhttp使用demo

### restful-api模块介绍
主要提供httpclient和okhttp测试的restful接口

**test包介绍：**
- HttpClientTest => HttpClient测试
- OkHttpClient => OkHttpClient测试

主要包括了文件上传【POST请求】、添加用户【POST请求】、删除用户【DELETE请求】、查询上传列表【GET请求】、修改用户请求测试【PUT请求】、取消请求测试【GET请求】  
测试取消请求时，取消FilesController中listFiles中的注释：
```
//        try {
//            Thread.sleep(8 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
```
OkHttp使用设置了超时的连接，即取消如下注释：
```
//    private OkHttpClient client = new OkHttpClient.Builder()
//            .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时时间
//            .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
//            .build();
```
避免默认超时时间对测试的影响

