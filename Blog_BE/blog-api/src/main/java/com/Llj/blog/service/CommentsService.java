package com.Llj.blog.service;

import com.Llj.blog.vo.params.CommentParam;
import com.Llj.blog.vo.params.Result;
import org.springframework.stereotype.Repository;

/**
 * @description：
 */
@Repository
public interface CommentsService {

    Result commentsByArticleId(Long id);

//    添加评论
    Result comment(CommentParam commentParam);
}
