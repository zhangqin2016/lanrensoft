package zhang.lao.dao;

import zhang.lao.model.FashionHot;

public interface FashionHotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FashionHot record);

    int insertSelective(FashionHot record);

    FashionHot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FashionHot record);

    int updateByPrimaryKey(FashionHot record);
}