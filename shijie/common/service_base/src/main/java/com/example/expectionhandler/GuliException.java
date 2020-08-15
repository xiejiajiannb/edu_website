package com.example.expectionhandler;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/7/30 9:41
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class GuliException extends RuntimeException {
    private Integer code;//状态码

    private String msg;//异常信息
}

