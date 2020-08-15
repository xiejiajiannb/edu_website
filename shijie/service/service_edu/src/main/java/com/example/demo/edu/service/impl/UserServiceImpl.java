package com.example.demo.edu.service.impl;

import com.example.demo.edu.entity.User;
import com.example.demo.edu.mapper.UserMapper;
import com.example.demo.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
