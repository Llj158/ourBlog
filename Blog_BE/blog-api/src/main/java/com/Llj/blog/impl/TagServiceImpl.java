package com.Llj.blog.impl;

import com.Llj.blog.dao.mapper.TagMapper;
import com.Llj.blog.dao.pojo.Tag;
import com.Llj.blog.service.TagService;
import com.Llj.blog.vo.TagVo;
import com.Llj.blog.vo.params.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description：
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tagList = tagMapper.findTagsByArticleId(articleId);
        return copyList(tagList);
    }

    @Override
    public Result hots(int limit) {

        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
//        通过tagIds查询tag对象
        List<Tag> tagList =  tagMapper.findTagsByTagIds(tagIds);
        return Result.success(tagList);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> qw = new LambdaQueryWrapper<>();
        qw.select(Tag::getId, Tag::getTagName);
        List<Tag> tags = tagMapper.selectList(qw);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tags = tagMapper.selectList(null);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findDetailById(Long id) {
        Tag tag = tagMapper.selectById(id);
        return Result.success(copy(tag));
    }
}
