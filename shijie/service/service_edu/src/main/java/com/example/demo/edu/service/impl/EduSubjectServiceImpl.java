package com.example.demo.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.demo.edu.entity.EduSubject;
import com.example.demo.edu.entity.excle.SubjectData;
import com.example.demo.edu.listener.SubjectExcelListener;
import com.example.demo.edu.mapper.EduSubjectMapper;
import com.example.demo.edu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author xjj
 * @since 2020-08-03
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {



    @Override
    public void saveSubject(MultipartFile file,EduSubjectService subjectService) {

        try {
            InputStream inputStream=file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead(); {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
