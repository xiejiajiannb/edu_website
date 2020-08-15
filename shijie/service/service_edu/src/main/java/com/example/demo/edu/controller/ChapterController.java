package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.Chapter;
import com.example.demo.edu.entity.User;
import com.example.demo.edu.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 章节表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class ChapterController {
    @Autowired
    private ChapterService service;

    @PostMapping("submit/{chaptername}/{courseid}")
    public R submitChapter(@PathVariable String chaptername,
                           @PathVariable String courseid){

        Chapter chapter1 =new Chapter();
        chapter1.setDId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        chapter1.setVId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        chapter1.setTId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        chapter1.setChapterName(chaptername);
        chapter1.setCourseId(courseid);

        boolean save = service.save(chapter1);
        return save==true?R.ok().data("chapter",chapter1):R.error();
    }

    @GetMapping("check/{chapter_id}")
    public R checkChapter(@PathVariable String chapter_id)

    {
        Chapter chapter = service.getById(chapter_id);
        return  chapter!=null?R.ok().message("查询成功").data("chapter",chapter):R.error().message("回复失败");

    }

    @GetMapping("checkCondition/{course_id}")
    public R checkCondition(@PathVariable String course_id)
    {
        QueryWrapper<Chapter> wrapper=new QueryWrapper();
        wrapper.eq("course_id",course_id );
        List<Chapter> chapters = service.list(wrapper);
        return chapters!=null?R.ok().data("chapters",chapters):R.error().message("该课程没有项目");

    }


    @DeleteMapping("delete/{chapter_id}")
    public R deleteChapter(@PathVariable String chapter_id)
    {
        boolean remove = service.removeById(chapter_id);
        return  remove==true?R.ok().message("删除章节成功"):R.error().message("删除章节失败");

    }

}

