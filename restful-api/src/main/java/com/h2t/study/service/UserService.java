package com.h2t.study.service;

import com.h2t.study.po.UserPO;
import com.h2t.study.vo.UserVO;

/**
 * 用户业务层接口
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/03 16:49
 */
public interface UserService {
    void removeUser(Long id);

    void addUser(UserVO userVO);

    void updateUserName(UserVO userVO);
}
