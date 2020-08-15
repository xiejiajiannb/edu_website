package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 附件表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_appendix")
@ApiModel(value="Appendix对象", description="附件表 ")
public class Appendix implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件号")
    @TableId(value = "appendix_id", type = IdType.ID_WORKER_STR)
    private String appendixId;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "类别")
    private Integer categorey;


}
