package com.example.demo.edu.query;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/8/2 12:11
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名称,模糊查询")

    private String name;


    @ApiModelProperty(value = "在线状态 1不在线 2在线")

    private Integer status;


    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;


    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")

    private String end;
}
