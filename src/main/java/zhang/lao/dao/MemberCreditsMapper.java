package zhang.lao.dao;

import zhang.lao.model.MemberCredits;

public interface MemberCreditsMapper {
    int deleteByPrimaryKey(Long mcId);

    int insert(MemberCredits record);

    int insertSelective(MemberCredits record);

    MemberCredits selectByPrimaryKey(Long mcId);

    int updateByPrimaryKeySelective(MemberCredits record);

    int updateByPrimaryKey(MemberCredits record);
}