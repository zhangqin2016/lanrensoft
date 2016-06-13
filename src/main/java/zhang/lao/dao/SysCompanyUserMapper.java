package zhang.lao.dao;

import zhang.lao.model.SysCompanyUser;

public interface SysCompanyUserMapper {
    int deleteByPrimaryKey(Integer cuId);

    int insert(SysCompanyUser record);

    int insertSelective(SysCompanyUser record);

    SysCompanyUser selectByPrimaryKey(Integer cuId);

    int updateByPrimaryKeySelective(SysCompanyUser record);

    int updateByPrimaryKey(SysCompanyUser record);
}