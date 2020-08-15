package com.example.demo.edu.service;

import com.example.demo.edu.entity.TextFill;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 填空题表  服务类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
public interface TextFillService extends IService<TextFill> {

    List<TextFill> getText(String fq_id);
}
