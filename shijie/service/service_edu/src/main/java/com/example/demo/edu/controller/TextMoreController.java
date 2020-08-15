package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.TextMore;
import com.example.demo.edu.entity.TextSingle;
import com.example.demo.edu.service.TextMoreService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 多选题表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/eduservice/text_more")
@CrossOrigin
public class TextMoreController {

    @Autowired
    private TextMoreService moreService;

    @PostMapping("creatMore")
    public R creatTextMore (@ApiParam(name="TextMore",value="ans为最多4字符id为整数",required=true)@RequestBody TextMore more){

        return moreService.save(more)==true? R.ok().message("本多选创建成功"):R.error().message("本多选创建失败");

    }

    @GetMapping("findMore/{mq_id}")
    public R findSingle (@PathVariable String mq_id){

        QueryWrapper<TextMore> wrapper=new QueryWrapper();
        wrapper.eq("mq_id",mq_id );
        //List<TextMore> list = moreService.list(wrapper);
        List<TextMore> list=moreService.getText(mq_id);
        return R.ok().data("items",list);
    }
}

