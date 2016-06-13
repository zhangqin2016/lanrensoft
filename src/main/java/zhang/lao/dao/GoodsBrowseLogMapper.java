package zhang.lao.dao;

import zhang.lao.model.GoodsBrowseLog;

public interface GoodsBrowseLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsBrowseLog record);

    int insertSelective(GoodsBrowseLog record);

    GoodsBrowseLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsBrowseLog record);

    int updateByPrimaryKey(GoodsBrowseLog record);
}