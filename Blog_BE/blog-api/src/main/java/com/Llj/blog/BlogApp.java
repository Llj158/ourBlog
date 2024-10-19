package com.Llj.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description：
 */

@SpringBootApplication
@MapperScan("com.Llj.blog.dao.mapper")
public class BlogApp {
    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class,args);
    }
}
