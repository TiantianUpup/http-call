package com.h2t.study.service;

import com.h2t.study.po.FilesPO;
import com.h2t.study.vo.FilesVO;

import java.util.List;

/**
 * 文件业务层接口
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 9:57
 */
public interface FilesService {
    void saveFiles(FilesVO filesVO);

    List<FilesPO> listFilesPO(Long userId);
}
