package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Discuss;
import com.example.demo.edu.entity.Reply;
import com.example.demo.edu.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 回复表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("submit")
    public R submitDiscuss(@RequestBody Reply reply){

        boolean save = replyService.save(reply);
        return  save==true?R.ok().message("回复成功"):R.error().message("回复失败");
    }




    @GetMapping("check/{did}")
    public R checkDiscuss(@PathVariable String did){

        QueryWrapper<Reply> wrapper=new QueryWrapper();
        wrapper.eq("d_id",did );
        List<Reply> list = replyService.list(wrapper);
        return  list!=null? R.ok().data("list", list):R.error();
    }

    @DeleteMapping("delete/{rid}")
    public R deleteDiscuss(@PathVariable String rid){

        boolean flag = replyService.removeById(rid);
        return flag==true?R.ok().message("删除消息成功"):R.error().message("删除消息失败");
    }

}

