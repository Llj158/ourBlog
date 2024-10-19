package com.Llj.blog.controller;

import com.Llj.blog.service.CommentsService;
import com.Llj.blog.vo.params.CommentParam;
import com.Llj.blog.vo.params.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description：
 */
@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long id){
        return commentsService.commentsByArticleId(id);
    }
    @PostMapping("create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentsService.comment(commentParam);
    }

}
