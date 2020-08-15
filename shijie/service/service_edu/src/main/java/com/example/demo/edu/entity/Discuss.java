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
 * 讨论表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_discuss")
@ApiModel(value="Discuss对象", description="讨论表 ")
public class Discuss implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讨论号")
    @TableId(value = "d_id", type = IdType.ID_WORKER_STR)
    private String dId;

    @ApiModelProperty(value = "发起讨论者学号")
    private String uId;

    @ApiModelProperty(value = "类别")
    private Integer category;

    @ApiModelProperty(value = "课程号")
    private String cId;

    @ApiModelProperty(value = "讨论题目")
    private String tile;

    @ApiModelProperty(value = "讨论内容")
    private String comment;

    @ApiModelProperty(value = "附件号")
    private String appendixId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "讨论更改时间")
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "讨论创建时间")
    private Date gmtCreate;


    @TableId
    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;


}
