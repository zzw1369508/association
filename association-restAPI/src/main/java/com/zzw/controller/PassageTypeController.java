package com.zzw.controller;

import com.zzw.entity.PassageType;
import com.zzw.entity.ResponseResult;
import com.zzw.service.PassageTypeService;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passageTypes")
@Api(tags = "社团管理系统前台文章类型接口")
public class PassageTypeController {
    @Autowired
    private PassageTypeService passageTypeService;
    @GetMapping
    public ResponseResult list() {
        List<PassageType> passageTypeList= passageTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(passageTypeList);
    }
}

