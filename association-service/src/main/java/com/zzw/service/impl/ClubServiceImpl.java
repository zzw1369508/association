package com.zzw.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.ClubMapper;
import com.zzw.dao.ClubTypeMapper;
import com.zzw.entity.Club;
import com.zzw.entity.ClubType;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.BusinessException;
import com.zzw.service.ClubService;
import com.zzw.vo.ClubInfoVo;
import com.zzw.vo.ClubPageVo;
import com.zzw.vo.ClubVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

@Service
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club> implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private ClubTypeMapper clubTypeMapper;
    @Override
    public ClubVo getTopN(int n, Club search) {
        ClubType clubType = null;
        Wrapper<Club> clubWrapper = new EntityWrapper<>();
        if (search.getClubTypeId() != null) {
            clubWrapper.eq("club_type_id", search.getClubTypeId());
            clubType = clubTypeMapper.selectById(search.getClubTypeId());
        }
        PageHelper.startPage(1, n);
        List<Club> clubList = clubMapper.selectList(clubWrapper);
        return new ClubVo(clubType,clubList);
    }

    @Override
    public PageInfo<ClubInfoVo> getPage(int pageNum, int pageSize, Club search) {
        PageHelper.startPage(pageNum, pageSize);
        List<ClubInfoVo> clubList = clubMapper.findClub(search);
        return new PageInfo<>(clubList);
    }

    @Override
    public ClubPageVo getPageWithTypeList(int pageNum, int pageSize, Integer clubTypeId) {
        ClubType clubType = null;
        Wrapper<Club> clubWrapper = new EntityWrapper<>();
        if (clubTypeId != null) {
            clubWrapper.eq("club_type_id", clubTypeId);
            clubType = clubTypeMapper.selectById(clubTypeId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Club> clubList = clubMapper.selectList(clubWrapper);
        return new ClubPageVo(clubType,new PageInfo<>(clubList));
    }

    @Override
    @Cacheable(value = "club")
    public Club getById(Serializable num) {
        Club club = clubMapper.selectById(num);
        if (club == null) {
            throw new BusinessException(ErrorEnum.BUSINESS_EXCEPTION.setMsg("社团不存在"));
        }
        return club;
    }

    @Override
//    @CachePut(value = "club", key = "#club.id")
    public Club add(Club club) {
        clubMapper.insert(club);
        return club;
    }

    @Override
    @CacheEvict(value = "club", key = "#num")
    public boolean deleteById(Serializable num) {
        Assert.notNull(num, "社团id不能为空");
        clubMapper.deleteById(num);
        return true;
    }

    @Override
    @CachePut(value = "club", key = "#club.num")
    public Club updateWithId(Club club) {
        clubMapper.updateById(club);
        return club;
    }
}
