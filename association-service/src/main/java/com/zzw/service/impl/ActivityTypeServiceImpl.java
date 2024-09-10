package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.ActivityMapper;
import com.zzw.dao.ActivityTypeMapper;
import com.zzw.entity.ActivityType;
import com.zzw.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl extends ServiceImpl<ActivityTypeMapper, ActivityType> implements ActivityTypeService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityTypeMapper activityTypeMapper;

}
