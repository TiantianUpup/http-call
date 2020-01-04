package com.h2t.study.dao;

import com.h2t.study.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户持久层
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/03 16:49
 */
@Mapper
public interface UserMapper {
    void removeUser(Long id);

    void addUser(UserPO userPO);

    void updateUserName(UserPO userPO);
}
