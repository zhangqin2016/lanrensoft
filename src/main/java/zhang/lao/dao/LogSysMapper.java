package zhang.lao.dao;

import zhang.lao.model.LogSys;

public interface LogSysMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogSys record);

    int insertSelective(LogSys record);

    LogSys selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogSys record);

    int updateByPrimaryKeyWithBLOBs(LogSys record);

    int updateByPrimaryKey(LogSys record);
}