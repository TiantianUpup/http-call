package com.h2t.study.dao;

import com.h2t.study.po.FilesPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文件持久层
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/03 16:52
 */
@Mapper
public interface FilesMapper {
    void saveFiles(FilesPO filesPO);

    List<FilesPO> listFilesPO(Long userId);
}
