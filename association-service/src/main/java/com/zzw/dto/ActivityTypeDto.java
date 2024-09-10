package com.zzw.dto;

import com.zzw.entity.Activity;
import com.zzw.entity.ActivityType;
import lombok.Data;

@Data
public class ActivityTypeDto extends Activity{
    private ActivityType activityType;
}
