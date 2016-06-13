package zhang.lao.dao;

import zhang.lao.model.GoodsHot;

public interface GoodsHotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsHot record);

    int insertSelective(GoodsHot record);

    GoodsHot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsHot record);

    int updateByPrimaryKey(GoodsHot record);
}