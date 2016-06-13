package zhang.lao.dao;

import zhang.lao.model.MemberLabel;

public interface MemberLabelMapper {
    int deleteByPrimaryKey(Integer ulId);

    int insert(MemberLabel record);

    int insertSelective(MemberLabel record);

    MemberLabel selectByPrimaryKey(Integer ulId);

    int updateByPrimaryKeySelective(MemberLabel record);

    int updateByPrimaryKey(MemberLabel record);
}