package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.TextFill;
import com.example.demo.edu.entity.TextMore;
import com.example.demo.edu.service.TextFillService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 填空题表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/eduservice/text_fill")
@CrossOrigin
public class TextFillController {

    @Autowired
    private TextFillService service;


    @PostMapping("creatFill")
    public R creatTextFill (@ApiParam(name="TextFill",value="ans为最多255字符id为整数",required=true)@RequestBody TextFill fill){

        return service.save(fill)==true? R.ok().message("本填空题创建成功"):R.error().message("本填空题创建失败");

    }

    @GetMapping("findFill/{fq_id}")
    public R findFill (@PathVariable String fq_id){

        QueryWrapper<TextFill> wrapper=new QueryWrapper();
        wrapper.eq("fq_id",fq_id );
        List<TextFill> list = service.getText(fq_id);
        return R.ok().data("items",list);
    }
}

