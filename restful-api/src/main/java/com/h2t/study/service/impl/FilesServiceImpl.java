package com.h2t.study.service.impl;

import com.h2t.study.dao.FilesMapper;
import com.h2t.study.po.FilesPO;
import com.h2t.study.service.FilesService;
import com.h2t.study.util.PropertiesUtil;
import com.h2t.study.vo.FilesVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件业务层接口实现类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 9:58
 */
@Service
public class FilesServiceImpl implements FilesService {
    @Resource
    private FilesMapper filesMapper;

    @Override
    public void saveFiles(FilesVO filesVO) {
        FilesPO filesPO = new FilesPO();
        PropertiesUtil.copyProperties(filesPO, filesVO);
        filesMapper.saveFiles(filesPO);
    }

    @Override
    public List<FilesPO> listFilesPO(Long userId) {
        return filesMapper.listFilesPO(userId);
    }
}
