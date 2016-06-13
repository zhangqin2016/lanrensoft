package zhang.lao.dao;

import zhang.lao.model.LogFitting;

public interface LogFittingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogFitting record);

    int insertSelective(LogFitting record);

    LogFitting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogFitting record);

    int updateByPrimaryKey(LogFitting record);
}