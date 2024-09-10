package com.zzw.vo;

import com.zzw.entity.Club;
import com.zzw.entity.ClubType;
import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class ClubPageVo {
    private ClubType clubType;
    private PageInfo<Club> clubPageInfo;

    public ClubPageVo(ClubType clubType, PageInfo<Club> clubPageInfo) {
        this.clubType = clubType;
        this.clubPageInfo = clubPageInfo;
    }

    public ClubPageVo() {
    }

}
