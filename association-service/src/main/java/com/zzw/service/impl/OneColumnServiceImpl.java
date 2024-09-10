package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.OneColumnMapper;
import com.zzw.entity.OneColumn;
import com.zzw.service.OneColumnService;
import org.springframework.stereotype.Service;

@Service
public class OneColumnServiceImpl extends ServiceImpl<OneColumnMapper, OneColumn> implements OneColumnService {

}
