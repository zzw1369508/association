package com.zzw.controller;


import com.zzw.entity.ActivityType;
import com.zzw.entity.ResponseResult;
import com.zzw.service.ActivityTypeService;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activityTypes")
@Api(tags = "前台活动类型接口")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;
    @GetMapping
    public ResponseResult list() {
        List<ActivityType> activityTypeList= activityTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(activityTypeList);
    }
}

