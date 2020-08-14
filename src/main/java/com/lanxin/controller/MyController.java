package com.lanxin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/login")
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);


        //发起认证请求
        try {

            subject.login(token);

            return "登陆成功";

        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "密码错误";
        }catch(UnknownAccountException un){
            System.out.println("账户不正确");
            return "账户不正确";
        }

    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "退出成功";
    }

    @RequestMapping("/notlogin")
    public String notlogin(){

        return "没有登录";
    }

    @RequiresPermissions("user:select")
    @RequestMapping("/select")
    public String select(){

        return "查询成功";
    }

    @RequiresPermissions("user:update")
    @RequestMapping("/update")
    public String update(){

        return "修改成功";
    }

    @RequiresPermissions("user:save")
    @RequestMapping("/save")
    public String save(){

        return "添加成功";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String delete(){

        return "删除成功";
    }
}
