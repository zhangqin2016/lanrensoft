package zhang.lao.dao;

import zhang.lao.model.PushLog;

public interface PushLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushLog record);

    int insertSelective(PushLog record);

    PushLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushLog record);

    int updateByPrimaryKey(PushLog record);
}