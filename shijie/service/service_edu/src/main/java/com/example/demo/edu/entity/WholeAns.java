package com.example.demo.edu.entity;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/8/5 15:15
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class WholeAns implements Serializable {
    private Ans ans;
    private List<AnsSingle> singles;
    private List<AnsMore> mores;
    private List<AnsFill> fills;
    private List<AnsAnswer> answers;

}
