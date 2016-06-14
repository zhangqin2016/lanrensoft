package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonModType;
import zhang.lao.mybatis.auto.model.CommonModTypeExample;

public interface CommonModTypeMapper {
    int countByExample(CommonModTypeExample example);

    int deleteByExample(CommonModTypeExample example);

    int deleteByPrimaryKey(Integer mtId);

    int insert(CommonModType record);

    int insertSelective(CommonModType record);

    List<CommonModType> selectByExample(CommonModTypeExample example);

    CommonModType selectByPrimaryKey(Integer mtId);

    int updateByExampleSelective(@Param("record") CommonModType record, @Param("example") CommonModTypeExample example);

    int updateByExample(@Param("record") CommonModType record, @Param("example") CommonModTypeExample example);

    int updateByPrimaryKeySelective(CommonModType record);

    int updateByPrimaryKey(CommonModType record);
}