package com.h2t.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FilesVO
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilesVO {
    private Long userId;

    private String name;

    private String savePath;
}
