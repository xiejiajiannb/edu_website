package com.example.demo.edu.controller;


import com.example.commonutils.R;
import com.example.demo.edu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService service;

    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){

        service.saveSubject(file, service);

        return R.ok();
    }
}

