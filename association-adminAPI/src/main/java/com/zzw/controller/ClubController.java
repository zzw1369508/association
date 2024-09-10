package com.zzw.controller;


import com.zzw.entity.Club;
import com.zzw.entity.ResponseResult;
import com.zzw.enums.ErrorEnum;
import com.zzw.exception.ParamInvalidException;
import com.zzw.service.ClubService;
import com.zzw.util.ResponseResultUtil;
import com.zzw.vo.ClubInfoVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/clubs")
@Api(value = "社团管理系统后台文章管理接口",tags = "社团管理系统后台文章管理接口")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @ApiOperation("通过社团编号num查看一个社团")
    @GetMapping("/{num}")
    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
        Club club = clubService.getById(num);
        return ResponseResultUtil.renderSuccess(club);
    }

    @ApiOperation("根据条件分页查询所有社团")
    @GetMapping
    public ResponseResult list(Club search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<ClubInfoVo> clubPageInfo = clubService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(clubPageInfo);
    }

    @ApiOperation("通过id删除一个社团")
    @DeleteMapping("/{num}")
    public ResponseResult delete(@PathVariable("num") Integer num) {
        clubService.deleteById(num);
        return ResponseResultUtil.renderSuccess(num);
    }

    @ApiOperation("添加一个社团")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.add(club);
        return ResponseResultUtil.renderSuccess("添加社团成功");
    }

    @ApiOperation("通过id更新一个社团")
    @PutMapping
    public ResponseResult update(@RequestBody @Valid Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.updateWithId(club);
        return ResponseResultUtil.renderSuccess("更新社团成功");
    }
}

