package com.example.demo.controller;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/7/31 17:13
 */

import com.example.commonutils.R;
import com.example.demo.service.AppendixService;
import com.example.demo.entity.Appendix;
import com.example.demo.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @Autowired
    private AppendixService appendixService;

    @PostMapping("uploadOssFile/{categorey}")
    public R uploadOssFile(@RequestParam(value="file",required=false)MultipartFile file,@PathVariable Integer categorey){

        String url=ossService.uploadFileAvatar(file);
        Appendix appendix=new Appendix();
        appendix.setUrl(url);
        appendix.setCategorey(categorey);
        appendixService.save(appendix);
        String appendixId = appendix.getAppendixId();

        return R.ok().data("appendixId",appendixId);
    }

    @GetMapping("{appendixId}")//通过路径传
    public  R getUrl(@PathVariable String appendixId){

        Appendix appendix = appendixService.getById(appendixId);

        return  appendix!=null?R.ok().data("appendix",appendix):R.error();

    }
}
