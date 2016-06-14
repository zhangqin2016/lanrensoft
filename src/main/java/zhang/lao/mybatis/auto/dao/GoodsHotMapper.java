package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.GoodsHot;
import zhang.lao.mybatis.auto.model.GoodsHotExample;

public interface GoodsHotMapper {
    int countByExample(GoodsHotExample example);

    int deleteByExample(GoodsHotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsHot record);

    int insertSelective(GoodsHot record);

    List<GoodsHot> selectByExample(GoodsHotExample example);

    GoodsHot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsHot record, @Param("example") GoodsHotExample example);

    int updateByExample(@Param("record") GoodsHot record, @Param("example") GoodsHotExample example);

    int updateByPrimaryKeySelective(GoodsHot record);

    int updateByPrimaryKey(GoodsHot record);
}