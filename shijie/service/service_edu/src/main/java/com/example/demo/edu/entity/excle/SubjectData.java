package com.example.demo.edu.entity.excle;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/8/3 15:16
 *
 */

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SubjectData {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
