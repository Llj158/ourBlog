package com.Llj.blog.vo.params;

import com.Llj.blog.vo.CategoryVo;
import com.Llj.blog.vo.TagVo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @description：
 */
@Data
public class ArticleParam {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;

}

