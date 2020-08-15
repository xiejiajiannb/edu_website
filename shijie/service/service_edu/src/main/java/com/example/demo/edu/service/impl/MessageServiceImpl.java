package com.example.demo.edu.service.impl;

import com.example.demo.edu.entity.Message;
import com.example.demo.edu.mapper.MessageMapper;
import com.example.demo.edu.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回复表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
