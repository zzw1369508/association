package com.zzw.controller;

import com.zzw.entity.ResponseResult;
import com.zzw.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
@Api(tags = "系统配置接口")
public class SystemController {
    @Value("${system.frontIndex}")
    private String accessFrontUrl;

    @GetMapping("/frontUrl")
    public ResponseResult getSystemAccessFrontUrl() {
        return ResponseResultUtil.renderSuccess(accessFrontUrl);
    }
}
