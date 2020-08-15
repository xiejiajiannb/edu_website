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
 * 单选题表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TextSingle对象", description="单选题表 ")
public class TextSingle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设置该题分数")
    private Integer score;

    @ApiModelProperty(value = "单选题母号")
    private String sqId;

    @ApiModelProperty(value = "单选题子号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "题干")
    private String sqComment;

    @ApiModelProperty(value = "答案")
    private String rightAns;

    @ApiModelProperty(value = "答案解析")
    private String keyWord;

    @ApiModelProperty(value = "选项一")
    private String a;

    @ApiModelProperty(value = "选项二")
    private String b;

    @ApiModelProperty(value = "选项三")
    private String c;

    @ApiModelProperty(value = "选项四")
    private String d;

    @ApiModelProperty(value = "回答")
    private String ans;


}
