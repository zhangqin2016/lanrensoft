package zhang.lao.dao;

import zhang.lao.model.FashionTags;

public interface FashionTagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FashionTags record);

    int insertSelective(FashionTags record);

    FashionTags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FashionTags record);

    int updateByPrimaryKey(FashionTags record);
}