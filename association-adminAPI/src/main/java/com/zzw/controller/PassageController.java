package com.zzw.controller;


import com.zzw.dto.PassageTypeDto;
import com.zzw.dto.PassageFileDto;
import com.zzw.entity.Passage;
import com.zzw.entity.ResponseResult;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.ParamInvalidException;
import com.zzw.service.PassageService;
import com.zzw.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/passages")
@Api(value = "社团管理系统后台文章管理接口",tags = "社团管理系统后台文章管理接口")
public class PassageController {
    @Autowired
    private PassageService passageService;

    @ApiOperation("通过id获取一篇文章详细信息")
    @GetMapping("/{id}")
    public ResponseResult getInfoById(@PathVariable("id") Integer id) {
        PassageFileDto passageFileDto = passageService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(passageFileDto);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有文章")
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, Passage search) {
        PageInfo<PassageTypeDto> passageList = passageService.findPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(passageList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除一篇文章")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        passageService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    @ApiOperation("添加一篇文章")
    public ResponseResult add(@Valid @RequestBody Passage passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageService.add(passage);
        System.out.println(passage.getId());
        return ResponseResultUtil.renderSuccess(passage.getId());
    }

    @PutMapping
    @ApiOperation("通过id更新一篇文章")
    public ResponseResult update(@RequestBody @Valid PassageFileDto passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageService.updateInfoById(passage);
        return ResponseResultUtil.renderSuccess("更新文章成功");
    }
}

