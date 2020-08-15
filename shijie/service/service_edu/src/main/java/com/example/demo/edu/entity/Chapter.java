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
 * 章节表 
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_chapter")
@ApiModel(value="Chapter对象", description="章节表 ")
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "章节名字")
    private String chapterName;

    @ApiModelProperty(value = "章节号")
    @TableId(value = "chapter_id", type = IdType.ID_WORKER_STR)
    private String chapterId;

    @ApiModelProperty(value = "课程号")
    private String courseId;

    @TableId(value = "v_id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "章节视频号")
    private String vId;

    @TableId(value = "t_id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "章节测试题号")
    private String tId;

    @TableId(value = "d_id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "章节文档资料号")
    private String dId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "讨论更改时间")
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "讨论创建时间")
    private Date gmtCreate;


}
