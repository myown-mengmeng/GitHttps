package com.lanxin.util;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleException(){

        return "没有该权限";
    }
}
