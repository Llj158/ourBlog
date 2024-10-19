package com.Llj.blog.controller;

import com.Llj.blog.service.LoginService;
import com.Llj.blog.vo.params.LoginParam;
import com.Llj.blog.vo.params.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 */
@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){
//        sso,单点登录
        return loginService.register(loginParam);
    }

}
