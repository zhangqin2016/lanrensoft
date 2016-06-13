package zhang.lao.dao;

import zhang.lao.model.CommonLabel;

public interface CommonLabelMapper {
    int deleteByPrimaryKey(Integer clId);

    int insert(CommonLabel record);

    int insertSelective(CommonLabel record);

    CommonLabel selectByPrimaryKey(Integer clId);

    int updateByPrimaryKeySelective(CommonLabel record);

    int updateByPrimaryKey(CommonLabel record);
}