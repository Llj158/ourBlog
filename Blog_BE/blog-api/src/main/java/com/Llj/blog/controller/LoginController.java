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
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
