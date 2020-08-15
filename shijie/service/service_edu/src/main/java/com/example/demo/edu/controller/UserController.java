package com.example.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commonutils.R;
import com.example.demo.edu.entity.User;
import com.example.demo.edu.query.UserQuery;
import com.example.demo.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author xjj
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login/{name}/{password}")
    public R login(@PathVariable String name, @PathVariable String password , HttpSession httpSession) {

        QueryWrapper<User> wrapper=new QueryWrapper();
        if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(password)){

            wrapper.eq("name",name );
            wrapper.eq("password",password );
            User user=userService.getOne(wrapper);
            if(user.getName().equals(name)&&user.getPassword().equals(password))
            {
                user.setStatus(true);
                userService.updateById(user);
                httpSession.setAttribute("user", user);
                return R.ok().data("token","admin");
            }else {
                return R.error().data("token","not_right");
            }

        }else {
            return R.error().data("token","not_right");
        }

    }

//    @PostMapping("login")
//    public R login() {
//        return R.ok().data("token","admin");
//    }

    @GetMapping("logout")
    public R logout(HttpSession httpSession) {

        QueryWrapper<User> wrapper=new QueryWrapper();
        User user =(User) httpSession.getAttribute("user");
        if (user!=null)
        {
            String name=user.getName();
            String password=user.getPassword();
            wrapper.eq("name",name );
            wrapper.eq("password",password );
            user.setStatus(false);
            userService.updateById(user);
            httpSession.invalidate();
            return R.ok().message("退出成功");
        }


            else {
                return R.error().data("token","not_right");
            }

}


//    @GetMapping("info")
//    public R info() {
//        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//    }

    @GetMapping("findAll")
    public R findAllUser (){

        List<User> list = userService.list(null);

        return R.ok().data("items",list);
    }

    @DeleteMapping("{id}")//通过路径传
    public  R removeUser(@PathVariable String id){

        boolean flag = userService.removeById(id);
        return  flag==true?R.ok():R.error();

    }

    @DeleteMapping("removeGroupUser")//通过路径传
    public  R removeGroupUser( @RequestBody(required = false) List<String> list){


        boolean flag = userService.removeByIds(list);
        return  flag==true?R.ok():R.error();

    }

    @GetMapping("pageUser/{current}/{size}")
    public R pageUser(@PathVariable long current,
                         @PathVariable long size){
        Page<User> pageUser=new Page<>(current,size);
        userService.page(pageUser,null );
        List<User> records = pageUser.getRecords();
        return R.ok().data("items",records );

    }

    @PostMapping("pageUserCondition/{current}/{list}")
    public R pageUserCondition(@PathVariable long current,
                                  @PathVariable long list,
                                  @RequestBody(required = false) UserQuery UserQuery
    ){
        Page<User> pageUser=new Page<>(current,list);
        QueryWrapper<User> wrapper=new QueryWrapper();
        String name = UserQuery.getName();
        String begin = UserQuery.getBegin();
        String end = UserQuery.getEnd();
        Integer status = UserQuery.getStatus();
        if(!StringUtils.isEmpty(name))
        {
            wrapper.like("name",name );
        }
        if(!StringUtils.isEmpty(status)){
            wrapper.eq("status", status);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end );
        }


        userService.page(pageUser,wrapper );
        List<User> records = pageUser.getRecords();
        long total = pageUser.getTotal();
        return R.ok().data("rows",records ).data("total", total);

    }


    @PostMapping("addUser")
    public R addUser(@RequestBody User User){


        boolean flag = userService.save(User);
        return  flag==true?R.ok():R.error();
    }

    @GetMapping("findUser/{id}")
    public R findUser(@PathVariable String id){

        User User1 = userService.getById(id);

        return  User1!=null?R.ok().data("User",User1):R.error().message("not data");
    }

    @PostMapping("updateUser")
    public R updateUser(@RequestBody User User) {

        boolean flag = userService.updateById(User);
        return flag==true?R.ok().message("更新成功"):R.error().message("失败");
    }


}

