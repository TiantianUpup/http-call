package com.h2t.study.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * fastjson工具类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/06 11:34
 */
public class FastjsonUtil {
    /**
     * json字符串转对象
     */
    public static <T> T deserializeToObj(String jsonStr, Class<T> clazz) {
        return JSONObject.parseObject(jsonStr, clazz);
    }

    /**
     * json字符串转List
     *
     * @param jsonStr json字符串
     * @param clazz   类
     * @return
     */
    public static <T> List<T> deserializeToList(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, new TypeReference<List<T>>(clazz) {
        });
    }
}
