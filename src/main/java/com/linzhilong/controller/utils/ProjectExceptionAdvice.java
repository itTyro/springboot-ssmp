package com.linzhilong.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)  //拦截错误的类型
    public Result doExceptionAdvice(Exception x) {
        //一系列处理

        x.printStackTrace(); //将错误打印,以便于找到错误
        return new Result(false,null,"服务器出错,请稍后再试");
    }
}
