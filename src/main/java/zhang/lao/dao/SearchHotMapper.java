package zhang.lao.dao;

import zhang.lao.model.SearchHot;

public interface SearchHotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SearchHot record);

    int insertSelective(SearchHot record);

    SearchHot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SearchHot record);

    int updateByPrimaryKey(SearchHot record);
}