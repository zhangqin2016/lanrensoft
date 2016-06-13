package zhang.lao.dao;

import zhang.lao.model.FashionImg;

public interface FashionImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FashionImg record);

    int insertSelective(FashionImg record);

    FashionImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FashionImg record);

    int updateByPrimaryKey(FashionImg record);
}