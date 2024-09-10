package com.zzw.vo;

import com.zzw.entity.Club;
import com.zzw.entity.ClubType;
import lombok.Data;

import java.util.List;

@Data
public class ClubVo {
    private ClubType clubType;
    private List<Club> clubList;

    public ClubVo(ClubType clubType, List<Club> clubList) {
        this.clubType = clubType;
        this.clubList = clubList;
    }
}
