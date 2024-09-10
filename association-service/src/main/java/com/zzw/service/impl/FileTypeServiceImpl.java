package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.FileTypeMapper;
import com.zzw.entity.FileType;
import com.zzw.service.FileTypeService;
import org.springframework.stereotype.Service;

@Service
public class FileTypeServiceImpl extends ServiceImpl<FileTypeMapper, FileType> implements FileTypeService {

}
