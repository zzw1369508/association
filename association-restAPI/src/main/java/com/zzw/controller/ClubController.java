package com.zzw.controller;


import com.zzw.entity.Club;
import com.zzw.entity.ResponseResult;
import com.zzw.service.ClubService;
import com.zzw.util.ResponseResultUtil;
import com.zzw.vo.ClubPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/clubs")
@Api(tags = "社团管理系统前台社团接口")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/{num}")
    @ApiOperation("通过社团编号num查看一个社团")
    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
        Club club = clubService.getById(num);
        return ResponseResultUtil.renderSuccess(club);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有社团")
    public ResponseResult list(Integer clubTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        ClubPageVo clubPageVo = clubService.getPageWithTypeList(pageNum, pageSize, clubTypeId);
        return ResponseResultUtil.renderSuccess(clubPageVo);
    }
}

