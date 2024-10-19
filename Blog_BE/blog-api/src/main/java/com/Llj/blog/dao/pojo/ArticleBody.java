package com.Llj.blog.dao.pojo;

import lombok.Data;

/**
 * @description：
 */
@Data
public class ArticleBody {

    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
