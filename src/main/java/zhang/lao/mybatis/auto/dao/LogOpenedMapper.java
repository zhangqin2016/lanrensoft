package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.LogOpened;
import zhang.lao.mybatis.auto.model.LogOpenedExample;

public interface LogOpenedMapper {
    int countByExample(LogOpenedExample example);

    int deleteByExample(LogOpenedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogOpened record);

    int insertSelective(LogOpened record);

    List<LogOpened> selectByExample(LogOpenedExample example);

    LogOpened selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogOpened record, @Param("example") LogOpenedExample example);

    int updateByExample(@Param("record") LogOpened record, @Param("example") LogOpenedExample example);

    int updateByPrimaryKeySelective(LogOpened record);

    int updateByPrimaryKey(LogOpened record);
}