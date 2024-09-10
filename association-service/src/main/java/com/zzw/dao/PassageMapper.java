package com.zzw.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zzw.dto.PassageTypeDto;
import com.zzw.dto.PassageFileDto;
import com.zzw.entity.Passage;

import java.util.List;

public interface PassageMapper extends BaseMapper<Passage> {
    List<PassageTypeDto> findPassage(Passage passage);

    PassageFileDto getInfoById(Integer id);

    Passage findSimplePassage(Passage passage);

    int add(Passage passage);
}
