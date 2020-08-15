package com.example.demo.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.edu.entity.TextSingle;
import com.example.demo.edu.mapper.TextSingleMapper;
import com.example.demo.edu.service.TextSingleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 单选题表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Service
public class TextSingleServiceImpl extends ServiceImpl<TextSingleMapper, TextSingle> implements TextSingleService {



    @Override
    public List<TextSingle> getText(String sq_id) {
        QueryWrapper<TextSingle> wrapper=new QueryWrapper();
        wrapper.eq("sq_id",sq_id );
        List<TextSingle> list = this.list(wrapper);
        return list;
    }
}
