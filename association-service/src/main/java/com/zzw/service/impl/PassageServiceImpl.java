package com.zzw.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zzw.dao.FileMapper;
import com.zzw.dao.PassageMapper;
import com.zzw.dao.PassageTypeMapper;
import com.zzw.dto.PassageTypeDto;
import com.zzw.dto.PassageFileDto;
import com.zzw.entity.Passage;
import com.zzw.entity.PassageType;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.BusinessException;
import com.zzw.service.PassageService;
import com.zzw.vo.PassagePageVo;
import com.zzw.vo.PassageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

@Service
public class PassageServiceImpl implements PassageService {
    @Autowired
    private PassageMapper passageMapper;
    @Autowired
    private PassageTypeMapper passageTypeMapper;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public PassageVo getTopN(int n, Passage search) {

        PassageType passageType = null;
        Wrapper<Passage> passageWrapper = new EntityWrapper<>();
        if (search != null && search.getPassageTypeId() != 0) {
            passageWrapper.eq("passage_type_id", search.getPassageTypeId());
            passageType = passageTypeMapper.selectById(search.getPassageTypeId());
        }
        passageWrapper.orderBy("publish_time", false);
        PageHelper.startPage(1, n);
        List<Passage> passageList = passageMapper.selectList(passageWrapper);
        return new PassageVo(passageType, passageList);
    }


    @Override
    public PageInfo<PassageTypeDto> findPage(int pageNum, int pageSize, Passage search) {
        PageHelper.startPage(pageNum, pageSize);
        List<PassageTypeDto> passageList = passageMapper.findPassage(search);
        return new PageInfo<>(passageList);
    }

    @Override
    public PassagePageVo getPageWithTypeList(int pageNum, int pageSize, Integer passageTypeId) {
        PassageType passageType = null;
        Wrapper<Passage> passageWrapper = new EntityWrapper<>();
        if (passageTypeId != null) {
            passageWrapper.eq("passage_type_id", passageTypeId);
            passageType = passageTypeMapper.selectById(passageTypeId);
        }
        passageWrapper.orderBy("publish_time", false);
        PageHelper.startPage(pageNum, pageSize);
        List<Passage> passageList = passageMapper.selectList(passageWrapper);
        return new PassagePageVo(passageType, new PageInfo<>(passageList));
    }

    @Override
    @Cacheable(value = "passage")
    public PassageFileDto getInfoById(Integer id) {
        PassageFileDto passageFileDto = passageMapper.getInfoById(id);
        if (passageFileDto == null) {
            throw new BusinessException(ErrorEnum.BUSINESS_EXCEPTION.setMsg("文章不存在"));
        }
        return passageFileDto;
    }


    @Override
//    @CachePut(value = "passage", key = "#passage.id")
    public Passage add(Passage passage) {
        if (StringUtils.isEmpty(passage.getSource())) {
            passage.setSource("社团管理员");
        }
        if (StringUtils.isEmpty(passage.getPublisher())) {
            passage.setPublisher("社团管理员");
        }
        passageMapper.add(passage);
        return passage;
    }

    @Override
    @CacheEvict(value = "passage", key = "#id")
    public boolean deleteById(Serializable id) {
        Assert.notNull(id, "文章id不能为空");
        passageMapper.deleteById(id);
        return true;
    }

    @Override
    @CachePut(value = "passage", key = "#passage.id")
    public PassageFileDto updateInfoById(PassageFileDto passage) {
        passageMapper.updateById(passage);
        return  passage;
    }
}
