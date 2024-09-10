package com.zzw.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zzw.entity.Club;
import com.zzw.vo.ClubInfoVo;

import java.util.List;

public interface ClubMapper extends BaseMapper<Club> {
    List<ClubInfoVo> findClub(Club club);

    ClubInfoVo getInfoById(Integer id);
}
