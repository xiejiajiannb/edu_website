package com.example.expectionhandler;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/7/28 16:36
 */

import com.example.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)

    @ResponseBody

    public R error(Exception e){

        e.printStackTrace();

        return R.error().message("服务器出错，请联系管理员");

    }

    //自定义异常类
    @ExceptionHandler(GuliException.class)

    @ResponseBody

    public R error(GuliException e){
        e.printStackTrace();
        log.error(e.getMsg());
        return R.error().message(e.getMsg()).code(e.getCode());

    }
}
