package zhang.lao.dao;

import zhang.lao.model.SearchLog;

public interface SearchLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchLog record);

    int insertSelective(SearchLog record);

    SearchLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchLog record);

    int updateByPrimaryKey(SearchLog record);
}