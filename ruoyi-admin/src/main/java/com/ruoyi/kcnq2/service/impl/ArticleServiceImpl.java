package com.ruoyi.kcnq2.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.ArticleMapper;
import com.ruoyi.kcnq2.domain.Article;
import com.ruoyi.kcnq2.service.IArticleService;

/**
 * 文章管理Service业务层处理
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
@Service
public class ArticleServiceImpl implements IArticleService 
{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    @Override
    public Article selectArticleById(Long id)
    {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询文章管理列表
     * 
     * @param article 文章管理
     * @return 文章管理
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增文章管理
     * 
     * @param article 文章管理
     * @return 结果
     */
    @Override
    public int insertArticle(Article article)
    {
        article.setCreateTime(DateUtils.getNowDate());
        article.setCreateBy(SecurityUtils.getUsername());
        article.setUpdateBy(SecurityUtils.getUsername());

        //TODO 刘飞波 这里需要将文章详情的内容，转存到MongoDB中，然后获取到MongoDB的ID之后，再存到MySQL中


        return articleMapper.insertArticle(article);
    }

    /**
     * 修改文章管理
     * 
     * @param article 文章管理
     * @return 结果
     */
    @Override
    public int updateArticle(Article article)
    {
        article.setUpdateTime(DateUtils.getNowDate());
        article.setUpdateBy(SecurityUtils.getUsername());
        return articleMapper.updateArticle(article);
    }

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(Long[] ids)
    {
        return articleMapper.updateArticleDeleteStatusByIds(ids, SecurityUtils.getUsername());
    }

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleById(Long id)
    {
        return articleMapper.updateArticleDeleteStatusByIds(new Long[] { id }, SecurityUtils.getUsername());
    }
}
