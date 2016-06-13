package zhang.lao.dao;

import zhang.lao.model.ArticleHot;

public interface ArticleHotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleHot record);

    int insertSelective(ArticleHot record);

    ArticleHot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleHot record);

    int updateByPrimaryKey(ArticleHot record);
}