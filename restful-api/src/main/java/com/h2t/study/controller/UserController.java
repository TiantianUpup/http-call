package com.h2t.study.controller;

import com.h2t.study.po.UserPO;
import com.h2t.study.service.UserService;
import com.h2t.study.util.ResponseUtil;
import com.h2t.study.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:02
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @DeleteMapping("/{id}")
    public Object removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseUtil.success();
    }

    @PostMapping
    public Object addUser(@RequestBody UserVO userVO) {
        userService.addUser(userVO);
        return ResponseUtil.success();
    }

    @PutMapping
    public Object updateUserName(@RequestBody UserVO userVO) {
        userService.updateUserName(userVO);
        return ResponseUtil.success();
    }
}
