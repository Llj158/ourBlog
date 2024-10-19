package com.Llj.blog.service;

import com.Llj.blog.dao.mapper.ArticleMapper;
import com.Llj.blog.dao.pojo.Article;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description：
 */
@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article){
        try {
            int viewCount = article.getViewCounts();
            Article articleUpdate = new Article();
            articleUpdate.setViewCounts(viewCount + 1);
            LambdaQueryWrapper<Article> qw = new LambdaQueryWrapper<>();
            qw.eq(Article::getId,article.getId());
            //保证线程安全
            qw.eq(Article::getViewCounts,article.getViewCounts());
            articleMapper.update(articleUpdate,qw);
            Thread.sleep(5000);
            System.out.println("更新完成了...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
