package zhang.lao.dao;

import zhang.lao.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer suId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer suId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}