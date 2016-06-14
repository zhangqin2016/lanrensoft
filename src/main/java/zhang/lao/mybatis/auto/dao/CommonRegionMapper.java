package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonRegion;
import zhang.lao.mybatis.auto.model.CommonRegionExample;

public interface CommonRegionMapper {
    int countByExample(CommonRegionExample example);

    int deleteByExample(CommonRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonRegion record);

    int insertSelective(CommonRegion record);

    List<CommonRegion> selectByExample(CommonRegionExample example);

    CommonRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonRegion record, @Param("example") CommonRegionExample example);

    int updateByExample(@Param("record") CommonRegion record, @Param("example") CommonRegionExample example);

    int updateByPrimaryKeySelective(CommonRegion record);

    int updateByPrimaryKey(CommonRegion record);
}