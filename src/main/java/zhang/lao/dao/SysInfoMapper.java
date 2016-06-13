package zhang.lao.dao;

import zhang.lao.model.SysInfo;

public interface SysInfoMapper {
    int deleteByPrimaryKey(Integer sysId);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    SysInfo selectByPrimaryKey(Integer sysId);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKeyWithBLOBs(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}