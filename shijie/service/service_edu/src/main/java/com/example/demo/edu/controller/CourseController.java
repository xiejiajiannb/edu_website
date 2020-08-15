package com.example.demo.edu.controller;


import com.example.commonutils.R;

import com.example.demo.edu.entity.Course;
import com.example.demo.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping("submit")
    public R submitCourse(@RequestBody Course course){

        boolean save = service.save(course);
      return save==true?R.ok().data("course",course):R.error();

    }

    @GetMapping("check/{course_id}")
    public R checkCourse(@PathVariable String course_id){
        Course course = service.getById(course_id);

        return  course!=null?R.ok().message("查询成功").data("course",course):R.error().message("回复失败");

    }
    @DeleteMapping("delete/{course_id}")
    public R deleteCourse(@PathVariable String course_id){
        boolean remove = service.removeById(course_id);
        return  remove==true?R.ok().message("删除课程成功"):R.error().message("删除课程失败");

    }


}



