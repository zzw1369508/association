package com.zzw.controller;


import com.zzw.entity.OneColumn;
import com.zzw.entity.ResponseResult;
import com.zzw.service.OneColumnService;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oneColumns")
@Api(tags = "系统一级菜单接口")
public class OneColumnController {
    @Autowired
private OneColumnService oneColumnService;
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception{
      OneColumn oneColumn =  oneColumnService.selectById(id);
      return ResponseResultUtil.renderSuccess(oneColumn);
    }

    @GetMapping
    public ResponseResult list(){
       List<OneColumn> oneColumnList =  oneColumnService.selectList(null);
        return ResponseResultUtil.renderSuccess(oneColumnList);
    }
}

