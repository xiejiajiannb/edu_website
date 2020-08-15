package com.example.demo.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 填空题表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TextFill对象", description="填空题表 ")
public class TextFill implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "设置该题分数")
    private Integer score;

    @ApiModelProperty(value = "填空题母号")
    private String fqId;

    @ApiModelProperty(value = "填空题干")
    private String fqComment;

    @ApiModelProperty(value = "回答")
    private String ans;

    @ApiModelProperty(value = "答案")
    private String rightAns;

    @ApiModelProperty(value = "答案解析")
    private String keyWord;

    @ApiModelProperty(value = "填空题子号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
