package zhang.lao.dao;

import zhang.lao.model.CommonStyle;

public interface CommonStyleMapper {
    int deleteByPrimaryKey(Integer csId);

    int insert(CommonStyle record);

    int insertSelective(CommonStyle record);

    CommonStyle selectByPrimaryKey(Integer csId);

    int updateByPrimaryKeySelective(CommonStyle record);

    int updateByPrimaryKey(CommonStyle record);
}