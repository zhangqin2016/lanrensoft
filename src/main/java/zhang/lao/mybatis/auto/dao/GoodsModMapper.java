package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.GoodsMod;
import zhang.lao.mybatis.auto.model.GoodsModExample;

public interface GoodsModMapper {
    int countByExample(GoodsModExample example);

    int deleteByExample(GoodsModExample example);

    int deleteByPrimaryKey(Integer mgmId);

    int insert(GoodsMod record);

    int insertSelective(GoodsMod record);

    List<GoodsMod> selectByExample(GoodsModExample example);

    GoodsMod selectByPrimaryKey(Integer mgmId);

    int updateByExampleSelective(@Param("record") GoodsMod record, @Param("example") GoodsModExample example);

    int updateByExample(@Param("record") GoodsMod record, @Param("example") GoodsModExample example);

    int updateByPrimaryKeySelective(GoodsMod record);

    int updateByPrimaryKey(GoodsMod record);
}