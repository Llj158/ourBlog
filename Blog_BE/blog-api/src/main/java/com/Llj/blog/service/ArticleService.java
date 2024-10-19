package com.Llj.blog.service;

import com.Llj.blog.vo.params.ArticleParam;
import com.Llj.blog.vo.params.PageParams;
import com.Llj.blog.vo.params.Result;

/**
 * @description：
 */
public interface ArticleService {

    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticles(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 通过id查看文章详情
     * @return
     */
    Result findArticleById(Long articleId);

    /**
     * 写文章
     * @return
     * @param articleParam
     */
    Result publish(ArticleParam articleParam);
}
