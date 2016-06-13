package zhang.lao.dao;

import zhang.lao.model.LogStature;

public interface LogStatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogStature record);

    int insertSelective(LogStature record);

    LogStature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogStature record);

    int updateByPrimaryKey(LogStature record);
}