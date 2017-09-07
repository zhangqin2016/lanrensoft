package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUser;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUserExample;

public interface BoUserMapper {
    int countByExample(BoUserExample example);

    int deleteByExample(BoUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoUser record);

    int insertSelective(BoUser record);

    List<BoUser> selectByExample(BoUserExample example);

    BoUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoUser record, @Param("example") BoUserExample example);

    int updateByExample(@Param("record") BoUser record, @Param("example") BoUserExample example);

    int updateByPrimaryKeySelective(BoUser record);

    int updateByPrimaryKey(BoUser record);
}