package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.GoodsLikeLog;
import zhang.lao.mybatis.auto.model.GoodsLikeLogExample;

public interface GoodsLikeLogMapper {
    int countByExample(GoodsLikeLogExample example);

    int deleteByExample(GoodsLikeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsLikeLog record);

    int insertSelective(GoodsLikeLog record);

    List<GoodsLikeLog> selectByExample(GoodsLikeLogExample example);

    GoodsLikeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsLikeLog record, @Param("example") GoodsLikeLogExample example);

    int updateByExample(@Param("record") GoodsLikeLog record, @Param("example") GoodsLikeLogExample example);

    int updateByPrimaryKeySelective(GoodsLikeLog record);

    int updateByPrimaryKey(GoodsLikeLog record);
}