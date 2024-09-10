package com.zzw.service;

import com.zzw.dto.PassageTypeDto;
import com.zzw.dto.PassageFileDto;
import com.zzw.entity.Passage;
import com.zzw.vo.PassagePageVo;
import com.zzw.vo.PassageVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

public interface PassageService {
    PassageVo getTopN(int n, Passage search);


    PageInfo<PassageTypeDto> findPage(int pageNum, int pageSize, Passage search);

    PassagePageVo getPageWithTypeList(int pageNum, int pageSize, Integer passageTypeId);

    PassageFileDto getInfoById(Integer id);


    Passage add(Passage passage);

    PassageFileDto updateInfoById(PassageFileDto passage);

    boolean deleteById(Serializable id);
}
