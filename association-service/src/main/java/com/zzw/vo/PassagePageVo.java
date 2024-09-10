package com.zzw.vo;

import com.zzw.entity.Passage;
import com.zzw.entity.PassageType;
import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class PassagePageVo {
    private PassageType passageType;
    private PageInfo<Passage> passagePageInfo;

    public PassagePageVo(PassageType passageType, PageInfo<Passage> passagePageInfo) {
        this.passageType = passageType;
        this.passagePageInfo = passagePageInfo;
    }

    public PassagePageVo() {
    }
}
