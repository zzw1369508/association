package com.zzw.vo;

import com.zzw.entity.Activity;
import com.zzw.entity.ActivityType;
import lombok.Data;

import java.util.List;

@Data
public class ActivityVo {
    private ActivityType activityType;
    private List<Activity> activityList;

    public ActivityVo(ActivityType activityType, List<Activity> activityList) {
        this.activityType = activityType;
        this.activityList = activityList;
    }

    public ActivityVo() {
    }
}
