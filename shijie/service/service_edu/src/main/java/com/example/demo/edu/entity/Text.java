package com.example.demo.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试题表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_text")
@ApiModel(value="Text对象", description="测试题表 ")
public class Text implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "测试题号")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "测试题名字")
    private String name;

    @ApiModelProperty(value = "单项选择题号")
    private String sqId;

    @ApiModelProperty(value = "多项选择题号")
    private String mqId;

    @ApiModelProperty(value = "填空题号")
    private String fqId;

    @ApiModelProperty(value = "简答题号")
    private String aqId;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更改时间")
    private Date gmtModified;

    private String tid;


}
