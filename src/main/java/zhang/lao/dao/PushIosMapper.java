package zhang.lao.dao;

import zhang.lao.model.PushIos;

public interface PushIosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushIos record);

    int insertSelective(PushIos record);

    PushIos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushIos record);

    int updateByPrimaryKeyWithBLOBs(PushIos record);

    int updateByPrimaryKey(PushIos record);
}