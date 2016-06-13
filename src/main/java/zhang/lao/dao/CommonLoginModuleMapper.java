package zhang.lao.dao;

import zhang.lao.model.CommonLoginModule;

public interface CommonLoginModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonLoginModule record);

    int insertSelective(CommonLoginModule record);

    CommonLoginModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonLoginModule record);

    int updateByPrimaryKeyWithBLOBs(CommonLoginModule record);

    int updateByPrimaryKey(CommonLoginModule record);
}