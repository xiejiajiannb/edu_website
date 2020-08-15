package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Teacher;
import com.example.demo.edu.query.TeacherQuery;
import com.example.demo.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-27
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("findAll")
    public R findAllTeacher (){

        List<Teacher> list = teacherService.list(null);

        return R.ok().data("items",list);
    }

    @DeleteMapping("{id}")//通过路径传
    public  R removeTeacher(@PathVariable String id){

        boolean flag = teacherService.removeById(id);
        return  flag==true?R.ok():R.error();

    }

    @GetMapping("pageTeacher/{current}/{size}")
    public R pageTeacher(@PathVariable long current,
                         @PathVariable long size){
        Page<Teacher> pageteacher=new Page<>(current,size);
        teacherService.page(pageteacher,null );
        List<Teacher> records = pageteacher.getRecords();
        return R.ok().data("items",records );

    }

    @PostMapping("pageTeacherCondition/{current}/{list}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long list,
                                  @RequestBody(required = false) TeacherQuery teacherQuery
                        ){
        Page<Teacher> pageteacher=new Page<>(current,list);
        QueryWrapper<Teacher> wrapper=new QueryWrapper();
        String name = teacherQuery.getName();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Integer level = teacherQuery.getLevel();
        if(!StringUtils.isEmpty(name))
        {
            wrapper.like("name",name );
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end );
        }




        teacherService.page(pageteacher,wrapper );
        List<Teacher> records = pageteacher.getRecords();
        long total = pageteacher.getTotal();
        return R.ok().data("rows",records ).data("total", total);

    }


    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody Teacher teacher){

        boolean flag = teacherService.save(teacher);
        return  flag==true?R.ok():R.error();
    }

    @GetMapping("findTeacher/{id}")
    public R findTeacher(@PathVariable String id){

        Teacher teacher1 = teacherService.getById(id);

        return  teacher1!=null?R.ok().data("teacher",teacher1):R.error().message("not data");
    }

    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody Teacher teacher) {

        boolean flag = teacherService.updateById(teacher);
        return flag==true?R.ok().message("更新成功"):R.error().message("失败");
    }



}

