package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonGoodsType;
import zhang.lao.mybatis.auto.model.CommonGoodsTypeExample;

public interface CommonGoodsTypeMapper {
    int countByExample(CommonGoodsTypeExample example);

    int deleteByExample(CommonGoodsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonGoodsType record);

    int insertSelective(CommonGoodsType record);

    List<CommonGoodsType> selectByExample(CommonGoodsTypeExample example);

    CommonGoodsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonGoodsType record, @Param("example") CommonGoodsTypeExample example);

    int updateByExample(@Param("record") CommonGoodsType record, @Param("example") CommonGoodsTypeExample example);

    int updateByPrimaryKeySelective(CommonGoodsType record);

    int updateByPrimaryKey(CommonGoodsType record);
}