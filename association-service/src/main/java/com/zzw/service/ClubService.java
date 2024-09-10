package com.zzw.service;

import com.baomidou.mybatisplus.service.IService;
import com.zzw.entity.Club;
import com.zzw.vo.ClubInfoVo;
import com.zzw.vo.ClubPageVo;
import com.zzw.vo.ClubVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

public interface ClubService extends IService<Club> {
    ClubVo getTopN(int n, Club search);

    PageInfo<ClubInfoVo> getPage(int pageNum, int pageSize, Club search);

    ClubPageVo getPageWithTypeList(int pageNum, int pageSize, Integer clubTypeId);

    Club getById(Serializable id);

    Club add(Club club);

    Club updateWithId(Club club);

    boolean deleteById(Serializable id);
}
