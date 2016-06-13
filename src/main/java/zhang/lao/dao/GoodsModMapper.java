package zhang.lao.dao;

import zhang.lao.model.GoodsMod;

public interface GoodsModMapper {
    int deleteByPrimaryKey(Integer mgmId);

    int insert(GoodsMod record);

    int insertSelective(GoodsMod record);

    GoodsMod selectByPrimaryKey(Integer mgmId);

    int updateByPrimaryKeySelective(GoodsMod record);

    int updateByPrimaryKey(GoodsMod record);
}