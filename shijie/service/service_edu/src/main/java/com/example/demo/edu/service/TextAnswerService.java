package com.example.demo.edu.service;

import com.example.demo.edu.entity.TextAnswer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.edu.entity.TextSingle;

import java.util.List;

/**
 * <p>
 * 简答题表  服务类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
public interface TextAnswerService extends IService<TextAnswer> {

    List<TextAnswer> getText(String aqId);
}
