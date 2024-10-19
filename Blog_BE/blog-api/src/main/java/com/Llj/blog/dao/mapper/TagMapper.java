package com.Llj.blog.dao.mapper;

import com.Llj.blog.dao.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description：
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询文章列表
     * @param articleId
     * @return
     */
//    通过文章id查找标签
    List<Tag> findTagsByArticleId(Long articleId);

//    查找最热标签id
    List<Long> findHotsTagIds(int limit);

//    通过TagIds查找文章
    List<Tag> findTagsByTagIds(List tagIds);
}
