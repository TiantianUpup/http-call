package com.h2t.study.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OkhttpClient响应实体
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/06 11:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OkHttpResponse<T> {
    private String code;

    private String msg;

    private T data;
}
