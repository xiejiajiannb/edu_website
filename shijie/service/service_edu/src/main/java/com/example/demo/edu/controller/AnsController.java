package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commonutils.R;
import com.example.demo.edu.entity.*;
import com.example.demo.edu.service.*;
import com.example.expectionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 回答表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/eduservice/ans")
@CrossOrigin
public class AnsController {

    //插入答题表的service
    @Autowired
    private AnsService ansService;

    @Autowired
    private AnsSingleService singleService;

    @Autowired
    private AnsMoreService moreService;

    @Autowired
    private AnsFillService fillService;



    //简答题的service
    @Autowired
    private AnsAnswerService answerService;

    //同学提交，改好客观题
    @PostMapping("submit")
    public R submitText(@RequestBody WholeAns whole) {


//        获取json数据封装成对象先
        Ans ans = whole.getAns();
        List<AnsSingle> singles=whole.getSingles();
        List<AnsMore> mores=whole.getMores();
        List<AnsFill> fills=whole.getFills();
        List<AnsAnswer> answers=whole.getAnswers();
        //1存储作答记录
        singleService.saveBatch(singles);
        moreService.saveBatch(mores);
        fillService.saveBatch(fills);
        answerService.saveBatch(answers);

        int rs_sum = 0;
        int rm_sum = 0;


        for (AnsSingle single : singles) {
            boolean flag = single.getRightAns().equals(single.getAns());
            if (flag) {
                //给分
                single.setRscore(single.getScore());
                rs_sum+=single.getScore();

            }else{
                single.setRscore(0);
            }

        }

        for (AnsMore more : mores) {
            boolean flag = more.getRightAns().equals(more.getAns());
            if (flag) {
                more.setScore(more.getScore());
                rm_sum+=more.getScore();
            }else {
                more.setScore(0);
            }

        }


        ans.setGore(rm_sum+rs_sum);


        ansService.save(ans);

        //返回分数即可
        return R.ok().data("客观题总分", ans.getGore()).data("单选择题总分", rs_sum).data("多选择题总分", rm_sum).message("客观题等老师评价");
    }

    //老师批改主观题步骤

    //通过测试题id找出该套题作答情况
    @GetMapping("getAllAnsById/{id}")
    public R getAllAnsById(@PathVariable String id){

        QueryWrapper<Ans> wrapper=new QueryWrapper();
        wrapper.eq("id",id );
        List<Ans> list = ansService.list(wrapper);
        return R.ok().data("list", list);
    }

    //通过简答题id及该同学uid给出该生答题作答情况
    @PostMapping("checkAnswer/{aqId}/{uid}")
    public R checkAnswerText(@PathVariable String aqId,@PathVariable String uid){

        QueryWrapper<AnsAnswer> wrapper=new QueryWrapper();
        wrapper.eq("aq_id",aqId );
        wrapper.eq("uid",uid );
        List<AnsAnswer> list =answerService.list(wrapper);
        return R.ok().data("list", list);
    }

    //对该生简答题评分，前端把Rscore填充好，已ListAns<Fill> json串回传完成更新
    @PostMapping("correctAnswer")
    public R correctAnswerText(@RequestBody List<AnsAnswer> list){

        int sum=0;
        for (AnsAnswer ans:list) {
            QueryWrapper<AnsAnswer> wrapper=new QueryWrapper();
            wrapper.eq("aq_id",ans.getAqId() );
            wrapper.eq("uid",ans.getUid() );
            sum+=ans.getRscore();
            answerService.update(ans,wrapper );
        }

        //查其之前该测试题的分数
        QueryWrapper<Ans> wrapper=new QueryWrapper();
        wrapper.eq("aq_id",list.get(0).getAqId() );
        List<Ans> list1 = ansService.list(wrapper);

        if(list1.size()>1)
        {
            throw new GuliException(20001,"此处含有两个填空题，联系管理员");
        }

        Ans ans = list1.get(0);

        Integer score = ans.getGore();
        ans.setGore(score+sum);
        ansService.updateById(ans);

        return R.ok().message("该生简答题判分完成,简答题成绩为："+sum+"分");
    }

    //通过填空题id及该同学uid给出该生答题作答情况
    @PostMapping("checkFill/{fqId}/{uid}")
    public R checkFillText(@PathVariable String fqId,@PathVariable String uid){

        QueryWrapper<AnsFill> wrapper=new QueryWrapper();
        wrapper.eq("fq_id",fqId );
        wrapper.eq("uid",uid );
        List<AnsFill> list = fillService.list(wrapper);

        return R.ok().data("list", list);
    }


    //对该生填空题评分,前端把Rscore填充好，已ListAns<Fill> json串回传完成更新
    @PostMapping("correctFill")
    public R correctFillText(@RequestBody List<AnsFill> list){

        int sum=0;
        for (AnsFill ans:list) {
            QueryWrapper<AnsFill> wrapper=new QueryWrapper();
            wrapper.eq("sq_id",ans.getSqId() );
            wrapper.eq("uid",ans.getUid() );
            sum+=ans.getRscore();
            fillService.update(ans,wrapper );
        }


        //查出该生之前的评分加上去就可以了
        QueryWrapper<Ans> wrapper=new QueryWrapper();
        wrapper.eq("fq_id",list.get(0).getSqId() );
        List<Ans> list1 = ansService.list(wrapper);
        if(list1.size()>1)
        {
         throw new GuliException(20001,"此处含有两个相同题，联系管理员");
        }

        Ans ans = list1.get(0);

        Integer score = ans.getGore();
        ans.setGore(score+sum);


        ansService.updateById(ans);
        
        return R.ok().message("该生填空题判分完成,填空题成绩为："+sum+"分");
    }





}

