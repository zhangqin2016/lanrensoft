package zhang.lao.dao;

import zhang.lao.model.AppToken;

public interface AppTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppToken record);

    int insertSelective(AppToken record);

    AppToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppToken record);

    int updateByPrimaryKey(AppToken record);
}