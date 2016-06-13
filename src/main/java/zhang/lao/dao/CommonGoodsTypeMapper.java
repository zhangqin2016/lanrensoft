package zhang.lao.dao;

import zhang.lao.model.CommonGoodsType;

public interface CommonGoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonGoodsType record);

    int insertSelective(CommonGoodsType record);

    CommonGoodsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonGoodsType record);

    int updateByPrimaryKey(CommonGoodsType record);
}