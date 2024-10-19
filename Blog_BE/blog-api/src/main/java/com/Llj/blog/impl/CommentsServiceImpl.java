package com.Llj.blog.impl;

import com.Llj.blog.dao.mapper.CommentMapper;
import com.Llj.blog.dao.pojo.Comment;
import com.Llj.blog.dao.pojo.SysUser;
import com.Llj.blog.service.CommentsService;
import com.Llj.blog.service.SysUserService;
import com.Llj.blog.utils.UserThreadLocal;
import com.Llj.blog.vo.CommentVo;
import com.Llj.blog.vo.UserVo;
import com.Llj.blog.vo.params.CommentParam;
import com.Llj.blog.vo.params.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    SysUserService sysUserService;

    @Override
    public Result commentsByArticleId(Long articleId) {
        LambdaQueryWrapper<Comment> qw = new LambdaQueryWrapper<>();
        qw.eq(Comment::getArticleId,articleId);
        qw.eq(Comment::getLevel,1);
        List<Comment> comments = commentMapper.selectList(qw);
        List<CommentVo> commentVoList = copyList(comments);
        return Result.success(commentVoList);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            comment.setLevel(1);
        }else{
            comment.setLevel(2);
        }
        comment.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId == null ? 0 : toUserId);
        this.commentMapper.insert(comment);
        return Result.success(null);
    }

    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : comments) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        commentVo.setId(String.valueOf(comment.getId()));
        Long authorId = comment.getAuthorId();
        UserVo userVo = this.sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //子评论
        Integer level = comment.getLevel();
        if(1 == level){
            Long id = comment.getId();
            List<CommentVo> commentVoList = findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);
        }
        //给谁评论
        if(level > 1){
            Long toUid = comment.getToUid();
            UserVo toUserVo = this.sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> qw = new LambdaQueryWrapper<>();
        qw.eq(Comment::getParentId,id);
        qw.eq(Comment::getLevel,2);

        return copyList(commentMapper.selectList(qw));
    }
}
