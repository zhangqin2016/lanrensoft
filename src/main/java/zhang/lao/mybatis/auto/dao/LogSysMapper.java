package zhang.lao.mybatis.auto.dao;

import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.LogSys;
import zhang.lao.mybatis.auto.model.LogSysExample;

import java.util.List;

public interface LogSysMapper {
    int countByExample(LogSysExample example);

    int deleteByExample(LogSysExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogSys record);

    int insertSelective(LogSys record);

    List<LogSys> selectByExampleWithBLOBs(LogSysExample example);

    List<LogSys> selectByExample(LogSysExample example);

    LogSys selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogSys record, @Param("example") LogSysExample example);

    int updateByExampleWithBLOBs(@Param("record") LogSys record, @Param("example") LogSysExample example);

    int updateByExample(@Param("record") LogSys record, @Param("example") LogSysExample example);

    int updateByPrimaryKeySelective(LogSys record);

    int updateByPrimaryKeyWithBLOBs(LogSys record);

    int updateByPrimaryKey(LogSys record);
}