package com.h2t.study.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传上限限制
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 11:37
 */
@Configuration
public class MaxFileSizeConfiguration {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.ofKilobytes(10240)); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize(DataSize.ofKilobytes(102400));
        return factory.createMultipartConfig();
    }
}
