package com.example.demo.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.edu.entity.TextAnswer;
import com.example.demo.edu.entity.TextSingle;
import com.example.demo.edu.mapper.TextAnswerMapper;
import com.example.demo.edu.service.TextAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 简答题表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Service
public class TextAnswerServiceImpl extends ServiceImpl<TextAnswerMapper, TextAnswer> implements TextAnswerService {

    @Override
    public List<TextAnswer> getText(String aqId) {
        QueryWrapper<TextAnswer> wrapper=new QueryWrapper();
        wrapper.eq("aq_id",aqId );
        List<TextAnswer> list = this.list(wrapper);
        return list;

    }
}
