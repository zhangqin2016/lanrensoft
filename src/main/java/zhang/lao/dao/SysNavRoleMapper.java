package zhang.lao.dao;

import zhang.lao.model.SysNavRole;

public interface SysNavRoleMapper {
    int deleteByPrimaryKey(Integer snrId);

    int insert(SysNavRole record);

    int insertSelective(SysNavRole record);

    SysNavRole selectByPrimaryKey(Integer snrId);

    int updateByPrimaryKeySelective(SysNavRole record);

    int updateByPrimaryKey(SysNavRole record);
}