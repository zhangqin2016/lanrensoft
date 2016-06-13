package zhang.lao.dao;

import zhang.lao.model.MemberBind;

public interface MemberBindMapper {
    int deleteByPrimaryKey(Long mbId);

    int insert(MemberBind record);

    int insertSelective(MemberBind record);

    MemberBind selectByPrimaryKey(Long mbId);

    int updateByPrimaryKeySelective(MemberBind record);

    int updateByPrimaryKey(MemberBind record);
}