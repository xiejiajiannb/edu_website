package com.example.handler;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/7/28 14:24
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override

    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("gmtCreate", new Date(), metaObject);

        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }


    @Override

    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("gmtModified", new Date(), metaObject);


    }

}