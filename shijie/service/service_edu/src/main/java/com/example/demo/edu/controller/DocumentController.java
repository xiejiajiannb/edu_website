package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Document;
import com.example.demo.edu.entity.Video;
import com.example.demo.edu.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 文档表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/eduservice/document")
@CrossOrigin
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping("submit")
    public R submitDocument(@RequestBody Document document){
        boolean save = service.save(document);
        return save==true?R.ok().data("document",document):R.error();
    }
    @GetMapping("checkChapterDocument/{d_id}")
    public R checkChapterDocument(@PathVariable String d_id){
        QueryWrapper<Document> wrapper=new QueryWrapper();
        wrapper.eq("d_id", d_id);
        List<Document> list = service.list(wrapper);
        return  list!=null?R.ok().message("查询成功").data("list",list):R.error().message("查询文档失败");

    }

    @GetMapping("check/{id}")
    public R checkDocument(@PathVariable String id){
        Document document = service.getById(id);
        return  document!=null?R.ok().message("查询成功").data("document",document):R.error().message("回复失败");

    }

    @DeleteMapping("delete/{id}")
    public R deleteDocument(@PathVariable String id){
        boolean remove = service.removeById(id);
        return  remove==true?R.ok().message("删除该文档成功"):R.error().message("删除该文档失败");

    }
}

