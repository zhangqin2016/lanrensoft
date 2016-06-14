package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonStyle;
import zhang.lao.mybatis.auto.model.CommonStyleExample;

public interface CommonStyleMapper {
    int countByExample(CommonStyleExample example);

    int deleteByExample(CommonStyleExample example);

    int deleteByPrimaryKey(Integer csId);

    int insert(CommonStyle record);

    int insertSelective(CommonStyle record);

    List<CommonStyle> selectByExample(CommonStyleExample example);

    CommonStyle selectByPrimaryKey(Integer csId);

    int updateByExampleSelective(@Param("record") CommonStyle record, @Param("example") CommonStyleExample example);

    int updateByExample(@Param("record") CommonStyle record, @Param("example") CommonStyleExample example);

    int updateByPrimaryKeySelective(CommonStyle record);

    int updateByPrimaryKey(CommonStyle record);
}