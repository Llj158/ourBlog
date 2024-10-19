package com.Llj.blog.service;

import com.Llj.blog.vo.TagVo;
import com.Llj.blog.vo.params.Result;

import java.util.List;

/**
 * @description：
 */
public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有标签
     * @return
     */
    Result findAll();

    /**
     * 查询所有标签细节
     * @return
     */
    Result findAllDetail();
    /**
     * 通过Id查询所有标签细节
     * @return
     */
    Result findDetailById(Long id);
}
