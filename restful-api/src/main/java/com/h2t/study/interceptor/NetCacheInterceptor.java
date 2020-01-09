package com.h2t.study.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 缓存拦截器
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/09 11:22
 */
public class NetCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originResponse = chain.proceed(request);

        //设置响应的缓存时间为60秒，即设置Cache-Control头，并移除pragma消息头，因为pragma也是控制缓存的一个消息头属性
        originResponse = originResponse.newBuilder()
                .removeHeader("pragma")
                .header("Cache-Control", "max-age=60")
                .build();

        return originResponse;
    }
}
