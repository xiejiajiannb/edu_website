package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Document;
import com.example.demo.edu.entity.Video;
import com.example.demo.edu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 视频表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/eduservice/video")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping("submit")
    public R submitVideo(@RequestBody Video video){
        boolean save = service.save(video);
        return save==true?R.ok().data("video",video):R.error();
    }
    @GetMapping("check/{id}")
    public R checkVideo(@PathVariable String id){
        Video video = service.getById(id);
        return  video!=null?R.ok().message("查询成功").data("video",video):R.error().message("回复失败");

    }

    @GetMapping("checkChapterVideo/{v_id}")
    public R checkChapterVideo(@PathVariable String d_id){
        QueryWrapper<Video> wrapper=new QueryWrapper();
        wrapper.eq("d_id", d_id);
        List<Video> list = service.list(wrapper);
        return  list!=null?R.ok().message("查询成功").data("list",list):R.error().message("查询文档失败");

    }


    @DeleteMapping("delete/{video_id}")
    public R deleteVideo(@PathVariable String video_id){
        boolean remove = service.removeById(video_id);
        return  remove==true?R.ok().message("删除该视频成功"):R.error().message("删除删除该视频");

    }
}

