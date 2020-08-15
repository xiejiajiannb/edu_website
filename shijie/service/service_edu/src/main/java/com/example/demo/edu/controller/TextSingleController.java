package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.TextSingle;
import com.example.demo.edu.service.TextSingleService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 单选题表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/eduservice/text_single")
@CrossOrigin
public class TextSingleController {
    @Autowired
    private TextSingleService singleService;

    @PostMapping("creatSingle")
    public R creatTextSingle (@ApiParam(name="TextSingle",value="ans为单字符id为整数",required=true)@RequestBody TextSingle single){

        return singleService.save(single)==true? R.ok().message("本单选创建成功").data("single",single):R.error().message("本单选创建失败");

    }


    @GetMapping("findSingle/{sq_id}")
    public R findSingle (@PathVariable String sq_id){
        List<TextSingle> list = singleService.getText(sq_id);
        return R.ok().data("items",list);
    }

}

