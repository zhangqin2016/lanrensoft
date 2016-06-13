package zhang.lao.dao;

import zhang.lao.model.MemberLog;

public interface MemberLogMapper {
    int deleteByPrimaryKey(Long mlId);

    int insert(MemberLog record);

    int insertSelective(MemberLog record);

    MemberLog selectByPrimaryKey(Long mlId);

    int updateByPrimaryKeySelective(MemberLog record);

    int updateByPrimaryKeyWithBLOBs(MemberLog record);

    int updateByPrimaryKey(MemberLog record);
}