package zhang.lao.dao;

import zhang.lao.model.MemberStature;

public interface MemberStatureMapper {
    int deleteByPrimaryKey(Long msId);

    int insert(MemberStature record);

    int insertSelective(MemberStature record);

    MemberStature selectByPrimaryKey(Long msId);

    int updateByPrimaryKeySelective(MemberStature record);

    int updateByPrimaryKey(MemberStature record);
}