package com.example.demo.edu.service.impl;

import com.example.demo.edu.entity.Document;
import com.example.demo.edu.mapper.DocumentMapper;
import com.example.demo.edu.service.DocumentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档表  服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements DocumentService {

}
