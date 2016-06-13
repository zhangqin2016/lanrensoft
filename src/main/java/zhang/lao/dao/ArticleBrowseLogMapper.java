package zhang.lao.dao;

import zhang.lao.model.ArticleBrowseLog;

public interface ArticleBrowseLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleBrowseLog record);

    int insertSelective(ArticleBrowseLog record);

    ArticleBrowseLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleBrowseLog record);

    int updateByPrimaryKey(ArticleBrowseLog record);
}