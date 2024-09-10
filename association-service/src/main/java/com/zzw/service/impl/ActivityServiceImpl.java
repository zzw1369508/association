package com.zzw.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.ActivityMapper;
import com.zzw.dao.ActivityTypeMapper;
import com.zzw.dao.FileMapper;
import com.zzw.dto.ActivityFileDto;
import com.zzw.dto.ActivityTypeDto;
import com.zzw.entity.Activity;
import com.zzw.entity.ActivityType;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.BusinessException;
import com.zzw.service.ActivityService;
import com.zzw.vo.ActivityPageVo;
import com.zzw.vo.ActivityVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityTypeMapper activityTypeMapper;
    @Autowired
    private FileMapper fileMapper;

    public ActivityVo getTopN(int n, Activity search) {
        ActivityType activityType = null;
        Wrapper<Activity> activityWrapper = new EntityWrapper<>();
        if (search.getActivityTypeId() != null && search.getActivityTypeId() != 0) {
            activityWrapper.eq("activity_type_id", search.getActivityTypeId());
            activityType = activityTypeMapper.selectById(search.getActivityTypeId());
        }
        activityWrapper.orderBy("apply_time", false);
        PageHelper.startPage(1, n);
        List<Activity> activityList = activityMapper.selectList(activityWrapper);
        return new ActivityVo(activityType, activityList);
    }

    @Override
    public PageInfo<ActivityTypeDto> getPage(int pageNum, int pageSize, Activity search) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivityTypeDto> activityList = activityMapper.findActivity(search);
        return new PageInfo<>(activityList);
    }

    @Override
    public ActivityPageVo getPageWithTypeList(int pageNum, int pageSize, Integer activityTypeId) {
        ActivityType activityType = null;
        Wrapper<Activity> activityWrapper = new EntityWrapper<>();
        if (activityTypeId != null) {
            activityWrapper.eq("activity_type_id", activityTypeId);
            activityType = activityTypeMapper.selectById(activityTypeId);
        }
        activityWrapper.orderBy("apply_time", false);
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> activityList = activityMapper.selectList(activityWrapper);
        return new ActivityPageVo(activityType, new PageInfo<>(activityList));
    }

    @Override
    @Cacheable(value = "activity")
    public ActivityFileDto getInfoById(Integer id) {
        ActivityFileDto activityFileDto = activityMapper.getInfoById(id);
        if (activityFileDto == null) {
            throw new BusinessException(ErrorEnum.BUSINESS_EXCEPTION.setMsg("活动不存在"));
        }


        return activityFileDto;
    }

    @Override
//    @CachePut(value = "activity", key = "#activity.id")
    public Activity add(Activity activity) {
        activityMapper.add(activity);
        return activity;
    }

    @Override
    @CacheEvict(value = "activity", key = "#id")
    public boolean deleteById(Serializable id) {
        Assert.notNull(id, "活动id不能为空");
        activityMapper.deleteById(id);
        return true;
    }

    @Override
    @CachePut(value = "activity", key = "#activity.id")
    public ActivityFileDto updateWithId(ActivityFileDto activity) {
        activityMapper.updateById(activity);
        return activity;
    }
}
