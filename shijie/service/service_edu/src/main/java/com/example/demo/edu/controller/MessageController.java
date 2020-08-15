package com.example.demo.edu.controller;


import com.example.commonutils.R;
import com.example.demo.edu.entity.Message;
import com.example.demo.edu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 回复表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-06
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @PostMapping("submit")
    public R submitMessage(@RequestBody Message message){

        messageService.save(message);
        return R.ok().message("跟随回复成功");
    }

    @GetMapping("check/{mId}")
    public R checkMessage(@PathVariable String mId){

        Message message = messageService.getById(mId);
        return R.ok().data("Message", message);
    }

    @DeleteMapping("delete/{mId}")
    public R deleteMessage(@PathVariable String mId){

        boolean flag = messageService.removeById(mId);
        return flag==true?R.ok().message("删除跟随回复成功"):R.error().message("删除跟随回复失败");
    }

}

