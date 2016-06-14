package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.PhoneCode;
import zhang.lao.mybatis.auto.model.PhoneCodeExample;

public interface PhoneCodeMapper {
    int countByExample(PhoneCodeExample example);

    int deleteByExample(PhoneCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhoneCode record);

    int insertSelective(PhoneCode record);

    List<PhoneCode> selectByExample(PhoneCodeExample example);

    PhoneCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByExample(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByPrimaryKeySelective(PhoneCode record);

    int updateByPrimaryKey(PhoneCode record);
}