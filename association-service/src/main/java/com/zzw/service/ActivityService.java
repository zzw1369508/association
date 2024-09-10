package com.zzw.service;

import com.baomidou.mybatisplus.service.IService;
import com.zzw.dto.ActivityFileDto;
import com.zzw.dto.ActivityTypeDto;
import com.zzw.entity.Activity;
import com.zzw.vo.ActivityPageVo;
import com.zzw.vo.ActivityVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

public interface ActivityService extends IService<Activity> {
    ActivityVo getTopN(int n, Activity search);

    PageInfo<ActivityTypeDto> getPage(int pageNum, int pageSize, Activity search);

    ActivityPageVo getPageWithTypeList(int pageNum, int pageSize, Integer activityTypeId);

    ActivityFileDto getInfoById(Integer id);

    Activity add(Activity activity);

    ActivityFileDto updateWithId(ActivityFileDto activity);

    boolean deleteById(Serializable id);
}
