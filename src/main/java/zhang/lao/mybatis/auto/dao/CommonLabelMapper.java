package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonLabel;
import zhang.lao.mybatis.auto.model.CommonLabelExample;

public interface CommonLabelMapper {
    int countByExample(CommonLabelExample example);

    int deleteByExample(CommonLabelExample example);

    int deleteByPrimaryKey(Integer clId);

    int insert(CommonLabel record);

    int insertSelective(CommonLabel record);

    List<CommonLabel> selectByExample(CommonLabelExample example);

    CommonLabel selectByPrimaryKey(Integer clId);

    int updateByExampleSelective(@Param("record") CommonLabel record, @Param("example") CommonLabelExample example);

    int updateByExample(@Param("record") CommonLabel record, @Param("example") CommonLabelExample example);

    int updateByPrimaryKeySelective(CommonLabel record);

    int updateByPrimaryKey(CommonLabel record);
}