package com.example.demo.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_course")
@ApiModel(value="Course对象", description="课程表 ")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程号")
    @TableId(value = "course_id", type = IdType.ID_WORKER_STR)
    private String courseId;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "课程图片")
    private String appendixId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "讨论更改时间")
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "讨论创建时间")
    private Date gmtCreate;


    @ApiModelProperty(value = "课程简介")
    private String comment;


}
