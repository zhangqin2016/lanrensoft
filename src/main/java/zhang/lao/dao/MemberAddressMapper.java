package zhang.lao.dao;

import zhang.lao.model.MemberAddress;

public interface MemberAddressMapper {
    int deleteByPrimaryKey(Long maId);

    int insert(MemberAddress record);

    int insertSelective(MemberAddress record);

    MemberAddress selectByPrimaryKey(Long maId);

    int updateByPrimaryKeySelective(MemberAddress record);

    int updateByPrimaryKey(MemberAddress record);
}