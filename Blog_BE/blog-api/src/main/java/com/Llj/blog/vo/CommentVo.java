package com.Llj.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @description：
 */

@Data
public class CommentVo  {

//    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;
}
