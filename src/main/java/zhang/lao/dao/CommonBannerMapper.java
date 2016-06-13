package zhang.lao.dao;

import zhang.lao.model.CommonBanner;

public interface CommonBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonBanner record);

    int insertSelective(CommonBanner record);

    CommonBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonBanner record);

    int updateByPrimaryKey(CommonBanner record);
}