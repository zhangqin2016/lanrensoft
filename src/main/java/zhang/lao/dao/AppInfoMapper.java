package zhang.lao.dao;

import zhang.lao.model.AppInfo;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Integer daId);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Integer daId);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}