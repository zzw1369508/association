package com.zzw.controller;


import com.zzw.dto.PassageFileDto;
import com.zzw.entity.ResponseResult;
import com.zzw.util.ResponseResultUtil;
import com.zzw.entity.Passage;
import com.zzw.service.PassageService;
import com.zzw.vo.PassagePageVo;
import com.zzw.vo.PassageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/passages")
@Api(tags = "社团管理系统前台文章接口")
public class PassageController {
    @Autowired
    private PassageService passageService;
    @ApiOperation("通过id获取一篇文章详细信息")
    @GetMapping("/{id}")
    public ResponseResult getInfoById(@PathVariable("id") Integer id) {
        PassageFileDto passageInfoVo = passageService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(passageInfoVo);
    }


    @ApiOperation("根据条件分页查询所有文章")
    @GetMapping
    public ResponseResult list(Integer passageTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        PassagePageVo passagePageVo = passageService.getPageWithTypeList(pageNum, pageSize,passageTypeId);
        return ResponseResultUtil.renderSuccess(passagePageVo);
    }
    @ApiOperation("查找最近发布的n篇新闻")
    @GetMapping("/top/{n}")
    public ResponseResult getTopN(Passage search, @PathVariable("n") int n) {
        PassageVo passageVo = passageService.getTopN(n,search);
        return ResponseResultUtil.renderSuccess(passageVo);
    }
}

