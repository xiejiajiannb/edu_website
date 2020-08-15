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
@TableName("edu_reply")
@ApiModel(value="Reply对象", description="回复表 ")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讨论号")
    private String dId;

    @ApiModelProperty(value = "回复号")
    @TableId(value = "r_id", type = IdType.ID_WORKER_STR)
    private String rId;

    @ApiModelProperty(value = "回复者")
    private String uId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "回复创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "逻辑删除")
    @TableId
    private Boolean isDeleted;

    @ApiModelProperty(value = "回复内容")
    private String comment;

    @ApiModelProperty(value = "附件号")
    private String appendixId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "回复更改时间")
    private Date gmtModified;


}
