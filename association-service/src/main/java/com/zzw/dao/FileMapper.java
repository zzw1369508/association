package com.zzw.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zzw.entity.File;

public interface FileMapper extends BaseMapper<File> {
    Integer save(File file);
}
