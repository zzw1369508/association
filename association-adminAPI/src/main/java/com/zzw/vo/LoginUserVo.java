package com.zzw.vo;

import com.zzw.entity.User;
import lombok.Data;

@Data
public class LoginUserVo extends User{
    private String code;
}
