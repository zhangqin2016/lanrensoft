package zhang.lao.dao;

import zhang.lao.model.ArticleLike;

public interface ArticleLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleLike record);

    int insertSelective(ArticleLike record);

    ArticleLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleLike record);

    int updateByPrimaryKey(ArticleLike record);
}