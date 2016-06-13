package zhang.lao.dao;

import zhang.lao.model.FashionLikeLog;

public interface FashionLikeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FashionLikeLog record);

    int insertSelective(FashionLikeLog record);

    FashionLikeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FashionLikeLog record);

    int updateByPrimaryKey(FashionLikeLog record);
}