package zhang.lao.dao;

import zhang.lao.model.PhoneCode;

public interface PhoneCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PhoneCode record);

    int insertSelective(PhoneCode record);

    PhoneCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhoneCode record);

    int updateByPrimaryKey(PhoneCode record);
}