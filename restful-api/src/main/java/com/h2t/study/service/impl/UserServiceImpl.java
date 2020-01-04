package com.h2t.study.service.impl;

import com.h2t.study.dao.UserMapper;
import com.h2t.study.po.UserPO;
import com.h2t.study.service.UserService;
import com.h2t.study.util.PropertiesUtil;
import com.h2t.study.vo.UserVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * 用户业务层接口实现类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 9:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void removeUser(Long id) {
        userMapper.removeUser(id);
    }

    @Override
    public void addUser(UserVO userVO) {
        UserPO userPO = new UserPO();
        PropertiesUtil.copyProperties(userPO, userVO);
        userMapper.addUser(userPO);
    }

    @Override
    public void updateUserName(UserVO userVO) {
        UserPO userPO = new UserPO();
        PropertiesUtil.copyProperties(userPO, userVO);
        userMapper.updateUserName(userPO);
    }
}
