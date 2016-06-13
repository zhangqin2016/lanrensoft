package zhang.lao.dao;

import zhang.lao.model.CommonRegion;

public interface CommonRegionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonRegion record);

    int insertSelective(CommonRegion record);

    CommonRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonRegion record);

    int updateByPrimaryKey(CommonRegion record);
}