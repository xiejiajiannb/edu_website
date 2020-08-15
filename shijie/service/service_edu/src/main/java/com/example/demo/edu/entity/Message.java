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
 * 回复表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_message")
@ApiModel(value="Message对象", description="回复表 ")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回复号")
    private String rId;

    @ApiModelProperty(value = "信息号")
    @TableId(value = "m_id", type = IdType.ID_WORKER_STR)
    private String mId;

    @ApiModelProperty(value = "回复者")
    private String uId;



    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "信息内容")
    private String comment;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更改时间")
    private Date gmtModified;


}
