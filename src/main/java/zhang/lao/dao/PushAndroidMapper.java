package zhang.lao.dao;

import zhang.lao.model.PushAndroid;

public interface PushAndroidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushAndroid record);

    int insertSelective(PushAndroid record);

    PushAndroid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushAndroid record);

    int updateByPrimaryKeyWithBLOBs(PushAndroid record);

    int updateByPrimaryKey(PushAndroid record);
}