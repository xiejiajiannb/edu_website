package com.example.demo.edu.service;

import com.example.demo.edu.entity.TextMore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 多选题表  服务类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
public interface TextMoreService extends IService<TextMore> {

    List<TextMore> getText(String mq_id);

}
