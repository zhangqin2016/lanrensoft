package zhang.lao.dao;

import zhang.lao.model.CommonModType;

public interface CommonModTypeMapper {
    int deleteByPrimaryKey(Integer mtId);

    int insert(CommonModType record);

    int insertSelective(CommonModType record);

    CommonModType selectByPrimaryKey(Integer mtId);

    int updateByPrimaryKeySelective(CommonModType record);

    int updateByPrimaryKey(CommonModType record);
}