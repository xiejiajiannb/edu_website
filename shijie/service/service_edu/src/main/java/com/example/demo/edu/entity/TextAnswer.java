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
 * 简答题表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TextAnswer对象", description="简答题表 ")
public class TextAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设置该题分数")
    private Integer score;

    @ApiModelProperty(value = "简答题母号")
    private String aqId;

    @ApiModelProperty(value = "简答题干")
    private String aqComment;

    @ApiModelProperty(value = "回答")
    private String ans;

    @ApiModelProperty(value = "答案")
    private String rightAns;

    @ApiModelProperty(value = "答案解析")
    private String keyWord;

    @ApiModelProperty(value = "简答题子号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
