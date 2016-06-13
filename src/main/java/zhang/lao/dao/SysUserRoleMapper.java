package zhang.lao.dao;

import zhang.lao.model.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer snrId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer snrId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}