package zhang.lao.dao;

import zhang.lao.model.SysNav;

public interface SysNavMapper {
    int deleteByPrimaryKey(Integer navId);

    int insert(SysNav record);

    int insertSelective(SysNav record);

    SysNav selectByPrimaryKey(Integer navId);

    int updateByPrimaryKeySelective(SysNav record);

    int updateByPrimaryKey(SysNav record);
}