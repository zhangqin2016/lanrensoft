package zhang.lao.dao;

import zhang.lao.model.GoodsLikeLog;

public interface GoodsLikeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsLikeLog record);

    int insertSelective(GoodsLikeLog record);

    GoodsLikeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsLikeLog record);

    int updateByPrimaryKey(GoodsLikeLog record);
}