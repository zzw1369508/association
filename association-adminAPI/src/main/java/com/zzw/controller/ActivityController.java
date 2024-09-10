package com.zzw.controller;


import com.zzw.dto.ActivityFileDto;
import com.zzw.dto.ActivityTypeDto;
import com.zzw.entity.Activity;
import com.zzw.entity.ResponseResult;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.ParamInvalidException;
import com.zzw.service.ActivityService;
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
@RequestMapping("/activities")
@Api(tags  = "社团管理系统后台活动管理接口",value = "社团管理系统后台活动管理接口")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "通过id获取一个活动", notes = "通过id获取一个活动")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        ActivityFileDto activity = activityService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(activity);
    }

    @ApiOperation(value = "根据条件分页查询所有活动",notes = "根据条件分页查询所有活动")
    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, Activity search) {
        PageInfo<ActivityTypeDto> activityPageInfo = activityService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(activityPageInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过id删除一个活动", notes = "通过id删除一个活动")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        activityService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    @ApiOperation(value = "添加一个活动", notes = "添加一个活动")
    public ResponseResult add(@Valid @RequestBody Activity activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.add(activity);
            return ResponseResultUtil.renderSuccess(activity.getId());
    }

    @PutMapping
    @ApiOperation(value = "通过id更新一个活动",notes="通过id更新一个活动")
    public ResponseResult update(@RequestBody @Valid ActivityFileDto activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.updateWithId(activity);
        return ResponseResultUtil.renderSuccess("更新活动成功");
    }
}

