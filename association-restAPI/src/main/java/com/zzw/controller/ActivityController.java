package com.zzw.controller;


import com.zzw.dto.ActivityFileDto;
import com.zzw.entity.Activity;
import com.zzw.entity.ResponseResult;
import com.zzw.service.ActivityService;
import com.zzw.util.ResponseResultUtil;
import com.zzw.vo.ActivityPageVo;
import com.zzw.vo.ActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/activities")
@Api(tags = "活动管理系统前台文章接口")
public class ActivityController {
    @Autowired
private ActivityService activityService;
    @GetMapping("/{id}")
    @ApiOperation("通过活动id查看一个活动")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception{
        ActivityFileDto activityFileDto = activityService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(activityFileDto);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有活动")
    public ResponseResult list(Integer activityTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        ActivityPageVo activityPageVo = activityService.getPageWithTypeList(pageNum,pageSize,activityTypeId);
        return ResponseResultUtil.renderSuccess(activityPageVo);
    }

    @GetMapping("/top/{n}")
    @ApiOperation("查看最近发布的n篇活动")
    public ResponseResult getTopN(Activity search, @PathVariable("n") int n) {
        ActivityVo activityVo = activityService.getTopN(n,search);
        return ResponseResultUtil.renderSuccess(activityVo);
    }
}

