package zhang.lao.dao;

import zhang.lao.model.ArticlePost;

public interface ArticlePostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(ArticlePost record);

    int insertSelective(ArticlePost record);

    ArticlePost selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(ArticlePost record);

    int updateByPrimaryKeyWithBLOBs(ArticlePost record);

    int updateByPrimaryKey(ArticlePost record);
}