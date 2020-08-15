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
 * 回答表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_ans")
@ApiModel(value="Ans对象", description="回答表 ")
public class Ans implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "测试题号")
    private String id;

    @ApiModelProperty(value = "学号")
    private String uid;

    @ApiModelProperty(value = "单项选择题母号")
    private String sqId;

    @ApiModelProperty(value = "多项选择题母号")
    private String mqId;

    @ApiModelProperty(value = "填空题母号")
    private String fqId;

    @ApiModelProperty(value = "简答题母号")
    private String aqId;

    @ApiModelProperty(value = "成绩")
    private Integer gore;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更改时间")
    private Date gmtModified;


}
