package com.zzw.controller;


import com.zzw.entity.PassageType;
import com.zzw.entity.ResponseResult;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.ParamInvalidException;
import com.zzw.service.PassageTypeService;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/passageTypes")
@RestController
@Api(value = "社团管理系统后台文章类型接口",tags = "社团管理系统后台文章类型接口")
public class PassageTypeController {
    @Autowired
    private PassageTypeService passageTypeService;

    @GetMapping
    public ResponseResult list() {
        List<PassageType> passageTypeList = passageTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(passageTypeList);
    }

    @ApiOperation("通过id获取一个新闻类型")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        PassageType passageType = passageTypeService.selectById(id);
        return ResponseResultUtil.renderSuccess(passageType);
    }

    @PutMapping
    @ApiOperation("更新新闻类型")
    public ResponseResult edit(@Valid @RequestBody PassageType passageType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageTypeService.updateById(passageType);
        return ResponseResultUtil.renderSuccess("更新成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除新闻类型")
    public ResponseResult delete(Integer id) {
        passageTypeService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除新闻类型成功");
    }

    @PostMapping
    @ApiOperation("添加新闻类型")
    public ResponseResult add(@Valid @RequestBody PassageType passageType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageTypeService.insert(passageType);
        return ResponseResultUtil.renderSuccess("添加新闻类型成功");
    }
}

