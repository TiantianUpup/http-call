package com.h2t.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserVO
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Long id;

    private String name;
}
