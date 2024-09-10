package com.zzw.exception;

import com.zzw.enums.ErrorEnum;
import com.zzw.error.CommonError;

public class AuthenticationFailException extends RuntimeException implements CommonError {
    private int code;
    private String msg;
    public AuthenticationFailException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public AuthenticationFailException(ErrorEnum errorEnum) {
        this(errorEnum.getCode(), errorEnum.getMsg());
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
