package com.h2t.study.controller;

import com.h2t.study.service.FilesService;
import com.h2t.study.util.ResponseUtil;
import com.h2t.study.vo.FilesVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * 文件控制层
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:03
 */
@RestController
@RequestMapping("/api/files")
public class FilesController {
    private final String savePath = "G:\\java工程\\http-call\\upload-file";
    @Resource
    private FilesService filesService;

    @PostMapping("/{userId}")
    public Object saveFiles(@RequestParam("file") MultipartFile multipartFile, @PathVariable Long userId) {
        File targetFile = new File(String.format("%s%s%s", savePath, File.separator, multipartFile.getOriginalFilename()));
        try {
            multipartFile.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        filesService.saveFiles(FilesVO.builder().name(multipartFile.getOriginalFilename()).savePath(targetFile.getAbsolutePath()).userId(userId).build());
        return ResponseUtil.success();
    }

    @GetMapping("/{userId}")
    public Object listFilesPO(@PathVariable Long userId) {
//        try {
//            Thread.sleep(8 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ResponseUtil.success(filesService.listFilesPO(userId));
    }
}
