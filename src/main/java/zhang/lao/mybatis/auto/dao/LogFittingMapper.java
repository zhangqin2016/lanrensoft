package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.LogFitting;
import zhang.lao.mybatis.auto.model.LogFittingExample;

public interface LogFittingMapper {
    int countByExample(LogFittingExample example);

    int deleteByExample(LogFittingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogFitting record);

    int insertSelective(LogFitting record);

    List<LogFitting> selectByExample(LogFittingExample example);

    LogFitting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogFitting record, @Param("example") LogFittingExample example);

    int updateByExample(@Param("record") LogFitting record, @Param("example") LogFittingExample example);

    int updateByPrimaryKeySelective(LogFitting record);

    int updateByPrimaryKey(LogFitting record);
}