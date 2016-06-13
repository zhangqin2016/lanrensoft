package zhang.lao.dao;

import zhang.lao.model.MemberFans;

public interface MemberFansMapper {
    int deleteByPrimaryKey(Long mfId);

    int insert(MemberFans record);

    int insertSelective(MemberFans record);

    MemberFans selectByPrimaryKey(Long mfId);

    int updateByPrimaryKeySelective(MemberFans record);

    int updateByPrimaryKey(MemberFans record);
}