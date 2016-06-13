package zhang.lao.dao;

import zhang.lao.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Long uId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}