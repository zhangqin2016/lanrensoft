package zhang.lao.dao;

import zhang.lao.model.FashionDynamic;

public interface FashionDynamicMapper {
    int deleteByPrimaryKey(Long fdId);

    int insert(FashionDynamic record);

    int insertSelective(FashionDynamic record);

    FashionDynamic selectByPrimaryKey(Long fdId);

    int updateByPrimaryKeySelective(FashionDynamic record);

    int updateByPrimaryKeyWithBLOBs(FashionDynamic record);

    int updateByPrimaryKey(FashionDynamic record);
}