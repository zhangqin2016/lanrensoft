package zhang.lao.dao;

import zhang.lao.model.CommonTemplate;

public interface CommonTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonTemplate record);

    int insertSelective(CommonTemplate record);

    CommonTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonTemplate record);

    int updateByPrimaryKey(CommonTemplate record);
}