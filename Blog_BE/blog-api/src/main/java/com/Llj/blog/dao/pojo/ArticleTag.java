package com.Llj.blog.dao.pojo;

import lombok.Data;

/**
 * @description：
 */
@Data
public class ArticleTag {

    private Long id;

    private Long articleId;

    private Long tagId;
}
