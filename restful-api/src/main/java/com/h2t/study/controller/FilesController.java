package com.h2t.study.controller;

import com.h2t.study.service.FilesService;
import com.h2t.study.util.ResponseUtil;
import com.h2t.study.vo.FilesVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:03
 */
@RestController
@RequestMapping("/api/files")
public class FilesController {
    @Resource
    private FilesService filesService;

    @PostMapping
    public Object saveFiles(@RequestBody FilesVO filesVO) {
        filesService.saveFiles(filesVO);
        return ResponseUtil.success();
    }

    @GetMapping("/{userId}")
    public Object listFilesPO(@PathVariable Long userId) {
        return ResponseUtil.success(filesService.listFilesPO(userId));
    }
}
