package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.LogStature;
import zhang.lao.mybatis.auto.model.LogStatureExample;

public interface LogStatureMapper {
    int countByExample(LogStatureExample example);

    int deleteByExample(LogStatureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogStature record);

    int insertSelective(LogStature record);

    List<LogStature> selectByExample(LogStatureExample example);

    LogStature selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogStature record, @Param("example") LogStatureExample example);

    int updateByExample(@Param("record") LogStature record, @Param("example") LogStatureExample example);

    int updateByPrimaryKeySelective(LogStature record);

    int updateByPrimaryKey(LogStature record);
}