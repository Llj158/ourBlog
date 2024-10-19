package com.Llj.blog.controller;

import com.Llj.blog.dao.pojo.SysUser;
import com.Llj.blog.utils.UserThreadLocal;
import com.Llj.blog.vo.params.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
