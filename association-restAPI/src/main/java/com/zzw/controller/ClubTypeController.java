package com.zzw.controller;


import com.zzw.entity.ClubType;
import com.zzw.entity.ResponseResult;
import com.zzw.service.ClubTypeService;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clubTypes")
@Api(tags = "社团管理系统前台社团类型接口")
public class ClubTypeController {
    @Autowired
    private ClubTypeService clubTypeService;
    @GetMapping
    public ResponseResult list() {
        List<ClubType> clubTypeList= clubTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(clubTypeList);
    }
}

