package com.zzw.vo;

import com.zzw.entity.Passage;
import com.zzw.entity.PassageType;
import lombok.Data;

import java.util.List;

@Data
public class PassageVo{
    private PassageType passageType;
    private List<Passage> passageList;

    public PassageVo(PassageType passageType, List<Passage> passageList) {
        this.passageType = passageType;
        this.passageList = passageList;
    }

    public PassageVo() {
    }
}
