package com.example.demo.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.edu.entity.TextFill;
import com.example.demo.edu.mapper.TextFillMapper;
import com.example.demo.edu.service.TextFillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 填空题表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@Service
public class TextFillServiceImpl extends ServiceImpl<TextFillMapper, TextFill> implements TextFillService {

    @Override
    public List<TextFill> getText(String fq_id) {
        QueryWrapper<TextFill> wrapper=new QueryWrapper();
        wrapper.eq("fq_id",fq_id );
        List<TextFill> list = this.list(wrapper);
        return list;
    }
}
