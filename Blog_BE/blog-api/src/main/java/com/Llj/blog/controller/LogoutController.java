package com.Llj.blog.controller;

import com.Llj.blog.service.LoginService;
import com.Llj.blog.vo.params.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 */
@RestController
@RequestMapping("logout")
public class LogoutController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization")String token){

        return loginService.logout(token);
    }
}
