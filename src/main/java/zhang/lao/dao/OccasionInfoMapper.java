package zhang.lao.dao;

import zhang.lao.model.OccasionInfo;

public interface OccasionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OccasionInfo record);

    int insertSelective(OccasionInfo record);

    OccasionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OccasionInfo record);

    int updateByPrimaryKey(OccasionInfo record);
}