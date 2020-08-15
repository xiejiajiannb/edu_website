package com.example.demo.edu.service.impl;

import com.example.demo.edu.entity.Text;
import com.example.demo.edu.mapper.TextMapper;
import com.example.demo.edu.service.TextService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试题表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-14
 */
@Service
public class TextServiceImpl extends ServiceImpl<TextMapper, Text> implements TextService {

}
