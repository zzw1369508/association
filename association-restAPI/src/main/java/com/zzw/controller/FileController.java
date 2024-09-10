package com.zzw.controller;


import com.zzw.entity.File;
import com.zzw.entity.ResponseResult;
import com.zzw.service.FileService;
import com.zzw.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/files")
@Api(tags = "文件管理系统前台文章接口")
public class FileController {
    @Autowired
private FileService fileService;


    @GetMapping
    @ApiOperation("根据条件分页查询     所有文件")
    public ResponseResult list(File search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        PageInfo<File> filePageInfo = fileService.getPage(pageNum,pageSize,search);
        return ResponseResultUtil.renderSuccess(filePageInfo);
    }


}

