package com.Llj.blog.controller;

import com.Llj.blog.common.aop.LogAnnotation;
import com.Llj.blog.common.cache.Cache;
import com.Llj.blog.service.ArticleService;
import com.Llj.blog.vo.params.ArticleParam;
import com.Llj.blog.vo.params.PageParams;
import com.Llj.blog.vo.params.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description：
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    /**
     * 首页 文章列表
     * @param pageParams
     * @return
     */

    @Autowired
    private ArticleService articleService;

    @LogAnnotation(module = "文章",operator = "获取文章列表")
    @Cache(expire = 5 * 60 * 1000,name = "获取文章列表")
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        //ArticleVo 页面接收的数据
//         Result  articles = articleService.listArticle(pageParams);

        return articleService.listArticle(pageParams);
    }

    /**
     * 最热文章
     * @return
     */
    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }


    /**
     * 最新文章
     * @return
     */
    @PostMapping("new")
    @Cache(expire = 5 * 60 * 1000,name = "new_article")
    public Result newArticles(){
        int limit = 5;
        return articleService.newArticles(limit);
    }

    @PostMapping("listArchives")  //archives   档案
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    /**
     * 写文章
     * @param articleParam
     * @return
     */
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }

}
