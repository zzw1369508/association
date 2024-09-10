package com.zzw.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zzw.dto.ActivityFileDto;
import com.zzw.dto.ActivityTypeDto;
import com.zzw.entity.Activity;

import java.util.List;

public interface ActivityMapper extends BaseMapper<Activity> {
    List<ActivityTypeDto> findActivity(Activity activity);

    ActivityFileDto getInfoById(Integer id);

    Integer add(Activity activity);
}
