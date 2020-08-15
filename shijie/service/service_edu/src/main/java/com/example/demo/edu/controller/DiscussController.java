package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Ans;
import com.example.demo.edu.entity.Discuss;
import com.example.demo.edu.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讨论表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/discuss")
public class DiscussController {
    @Autowired
    private DiscussService discussService;

    @GetMapping("checkAll/{cid}")
    public R checkAllDiscuss(@PathVariable String cid){
        QueryWrapper<Discuss> wrapper=new QueryWrapper();
        wrapper.eq("c_id",cid );
        List<Discuss> list = discussService.list(wrapper);
        return list!=null? R.ok().data("list", list):R.error();
    }


    @PostMapping("submit")
    public R submitDiscuss(@RequestBody Discuss discuss){

        return  discussService.save(discuss)==true?R.ok().data("discuss",discuss):R.error().message("创建讨论失败");
    }

    @GetMapping("check/{did}")
    public R checkDiscuss(@PathVariable String did){

        Discuss discuss = discussService.getById(did);
        return R.ok().data("discuss", discuss);
    }

    @DeleteMapping("delete/{did}")
    public R deleteDiscuss(@PathVariable String did){

        boolean flag = discussService.removeById(did);
        return flag==true?R.ok().message("删除评论成功"):R.error().message("删除评论失败");
    }



}

