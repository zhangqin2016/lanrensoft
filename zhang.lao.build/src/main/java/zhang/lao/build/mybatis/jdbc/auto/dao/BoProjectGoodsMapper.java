package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoods;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoodsExample;

public interface BoProjectGoodsMapper {
    int countByExample(BoProjectGoodsExample example);

    int deleteByExample(BoProjectGoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoProjectGoods record);

    int insertSelective(BoProjectGoods record);

    List<BoProjectGoods> selectByExampleWithBLOBs(BoProjectGoodsExample example);

    List<BoProjectGoods> selectByExample(BoProjectGoodsExample example);

    BoProjectGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoProjectGoods record, @Param("example") BoProjectGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") BoProjectGoods record, @Param("example") BoProjectGoodsExample example);

    int updateByExample(@Param("record") BoProjectGoods record, @Param("example") BoProjectGoodsExample example);

    int updateByPrimaryKeySelective(BoProjectGoods record);

    int updateByPrimaryKeyWithBLOBs(BoProjectGoods record);

    int updateByPrimaryKey(BoProjectGoods record);
}