package com.example.demo.edu.service;

import com.example.demo.edu.entity.TextSingle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 单选题表  服务类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
public interface TextSingleService extends IService<TextSingle> {

    List<TextSingle> getText(String sq_id);
}
