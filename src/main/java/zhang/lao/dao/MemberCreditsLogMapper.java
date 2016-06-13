package zhang.lao.dao;

import zhang.lao.model.MemberCreditsLog;

public interface MemberCreditsLogMapper {
    int deleteByPrimaryKey(Long clId);

    int insert(MemberCreditsLog record);

    int insertSelective(MemberCreditsLog record);

    MemberCreditsLog selectByPrimaryKey(Long clId);

    int updateByPrimaryKeySelective(MemberCreditsLog record);

    int updateByPrimaryKey(MemberCreditsLog record);
}