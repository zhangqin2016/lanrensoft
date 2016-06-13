package zhang.lao.dao;

import zhang.lao.model.CommonColor;

public interface CommonColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonColor record);

    int insertSelective(CommonColor record);

    CommonColor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonColor record);

    int updateByPrimaryKey(CommonColor record);
}