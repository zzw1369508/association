package com.zzw.vo;

import com.zzw.entity.Activity;
import com.zzw.entity.ActivityType;
import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class ActivityPageVo {
    private ActivityType activityType;
    private PageInfo<Activity> activityPageInfo;

    public ActivityPageVo(ActivityType activityType, PageInfo<Activity> activityPageInfo) {
        this.activityType = activityType;
        this.activityPageInfo = activityPageInfo;
    }

    public ActivityPageVo() {
    }

}
