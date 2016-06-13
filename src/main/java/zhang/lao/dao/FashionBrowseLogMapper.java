package zhang.lao.dao;

import zhang.lao.model.FashionBrowseLog;

public interface FashionBrowseLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FashionBrowseLog record);

    int insertSelective(FashionBrowseLog record);

    FashionBrowseLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FashionBrowseLog record);

    int updateByPrimaryKey(FashionBrowseLog record);
}