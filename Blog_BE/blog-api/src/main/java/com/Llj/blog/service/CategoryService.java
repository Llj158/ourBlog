package com.Llj.blog.service;

import com.Llj.blog.vo.CategoryVo;
import com.Llj.blog.vo.params.Result;

/**
 * @description：
 */
public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);
}
