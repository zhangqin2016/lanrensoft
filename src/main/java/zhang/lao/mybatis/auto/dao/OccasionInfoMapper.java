package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.OccasionInfo;
import zhang.lao.mybatis.auto.model.OccasionInfoExample;

public interface OccasionInfoMapper {
    int countByExample(OccasionInfoExample example);

    int deleteByExample(OccasionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OccasionInfo record);

    int insertSelective(OccasionInfo record);

    List<OccasionInfo> selectByExample(OccasionInfoExample example);

    OccasionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OccasionInfo record, @Param("example") OccasionInfoExample example);

    int updateByExample(@Param("record") OccasionInfo record, @Param("example") OccasionInfoExample example);

    int updateByPrimaryKeySelective(OccasionInfo record);

    int updateByPrimaryKey(OccasionInfo record);
}