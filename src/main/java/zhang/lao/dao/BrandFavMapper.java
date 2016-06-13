package zhang.lao.dao;

import zhang.lao.model.BrandFav;

public interface BrandFavMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandFav record);

    int insertSelective(BrandFav record);

    BrandFav selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrandFav record);

    int updateByPrimaryKey(BrandFav record);
}