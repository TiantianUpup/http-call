package com.h2t.study.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/03 16:44
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {
    private Long id;

    private String name;

    private Integer deleted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
}
