package com.example.demo.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.edu.entity.TextMore;
import com.example.demo.edu.mapper.TextMoreMapper;
import com.example.demo.edu.service.TextMoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 多选题表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Service
public class TextMoreServiceImpl extends ServiceImpl<TextMoreMapper, TextMore> implements TextMoreService {

    @Override
    public List<TextMore> getText(String mq_id) {
        QueryWrapper<TextMore> wrapper=new QueryWrapper();
        wrapper.eq("mq_id",mq_id );
        List<TextMore> list = this.list(wrapper);
        return list;
    }

}
