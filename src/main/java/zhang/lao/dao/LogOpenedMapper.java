package zhang.lao.dao;

import zhang.lao.model.LogOpened;

public interface LogOpenedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogOpened record);

    int insertSelective(LogOpened record);

    LogOpened selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogOpened record);

    int updateByPrimaryKey(LogOpened record);
}