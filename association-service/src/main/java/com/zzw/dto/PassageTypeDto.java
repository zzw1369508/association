package com.zzw.dto;

import com.zzw.entity.Passage;
import com.zzw.entity.PassageType;
import lombok.Data;

@Data
public class PassageTypeDto extends Passage{
    private PassageType passageType;
}
