package com.example.demo.edu.controller;


import com.example.commonutils.R;
import com.example.demo.edu.entity.*;
import com.example.demo.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 测试题表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/eduservice/text")
@CrossOrigin
public class EduTextController {

    @Autowired
    private EduTextService textservice;

    @Autowired
    private TextSingleService singleService;
    @Autowired
    private TextMoreService moreService;
    @Autowired
    private TextFillService fillService;
    @Autowired
    private TextAnswerService answerService;

    @GetMapping("findAllText")
    public R findAllText (){

        List<EduText> list = textservice.list(null);

        return R.ok().data("items",list);
    }

    @PostMapping("creatText/{name}/{tid}")
    public R creatText (@PathVariable String name,
                        @PathVariable String tid){


        EduText text=new EduText();
        text.setName(name);
        text.setTid(tid);
        text.setAqId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        text.setFqId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        text.setMqId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));
        text.setSqId(UUID.randomUUID().toString().replace("-","" ).substring(0,19 ));

        boolean save = textservice.save(text);
        return  save==true?R.ok().data("item",text).message("试卷初始化成功"):R.error().message("试卷初始化失败");
    }

    @GetMapping("findText/{id}")
    public R findTextById (@PathVariable String id){

        EduText text = textservice.getById(id);
        String aqId = text.getAqId();
        String fqId = text.getFqId();
        String mqId = text.getMqId();
        String sqId = text.getSqId();
        List<TextSingle> singles = singleService.getText(sqId);
        List<TextMore> mores = moreService.getText(mqId);
        List<TextFill> fills=fillService.getText(fqId);
        List<TextAnswer> answers = answerService.getText(aqId);

        return R.ok().data("singles",singles).data("mores",mores).data("fills",fills).data("answers",answers);
    }



}

