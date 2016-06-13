package zhang.lao.dao;

import zhang.lao.model.BrandInfo;

public interface BrandInfoMapper {
    int deleteByPrimaryKey(Integer brandId);

    int insert(BrandInfo record);

    int insertSelective(BrandInfo record);

    BrandInfo selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(BrandInfo record);

    int updateByPrimaryKeyWithBLOBs(BrandInfo record);

    int updateByPrimaryKey(BrandInfo record);
}