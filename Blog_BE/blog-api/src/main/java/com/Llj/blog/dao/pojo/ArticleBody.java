package com.Llj.blog.dao.pojo;

import lombok.Data;

/**
 * @description：文章内容
 */
@Data
public class ArticleBody {

    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
