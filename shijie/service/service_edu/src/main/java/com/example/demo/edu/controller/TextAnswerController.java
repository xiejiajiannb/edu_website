package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.TextAnswer;
import com.example.demo.edu.entity.TextFill;
import com.example.demo.edu.entity.TextMore;
import com.example.demo.edu.service.TextAnswerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 简答题表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/eduservice/text_answer")
@CrossOrigin
public class TextAnswerController {

    @Autowired
    private TextAnswerService service;

    @PostMapping("creatAnswer")
    public R creatTextAnswer (@ApiParam(name="TextAnswer",value="ans为最多255字符id为整数",required=true)@RequestBody TextAnswer answer){

        return service.save(answer)==true? R.ok().message("本简答题创建成功"):R.error().message("本简答题创建失败");

    }

    @GetMapping("findFill/{aq_id}")
    public R findAnswer  (@PathVariable String aq_id){

        QueryWrapper<TextAnswer> wrapper=new QueryWrapper();
        wrapper.eq("aq_id",aq_id );
        List<TextAnswer> list = service.list(wrapper);
        return R.ok().data("items",list);
    }

}

