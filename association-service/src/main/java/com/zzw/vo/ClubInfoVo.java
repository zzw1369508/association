package com.zzw.vo;

import com.zzw.entity.Club;
import com.zzw.entity.ClubType;
import com.zzw.entity.File;
import lombok.Data;

import java.util.List;

@Data
public class ClubInfoVo extends Club {
    private ClubType clubType;
    private List<File> fileList;
}
