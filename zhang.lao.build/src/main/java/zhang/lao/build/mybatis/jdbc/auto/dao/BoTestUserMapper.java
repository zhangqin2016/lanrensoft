package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestUser;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestUserExample;

public interface BoTestUserMapper {
    int countByExample(BoTestUserExample example);

    int deleteByExample(BoTestUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoTestUser record);

    int insertSelective(BoTestUser record);

    List<BoTestUser> selectByExampleWithBLOBs(BoTestUserExample example);

    List<BoTestUser> selectByExample(BoTestUserExample example);

    BoTestUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoTestUser record, @Param("example") BoTestUserExample example);

    int updateByExampleWithBLOBs(@Param("record") BoTestUser record, @Param("example") BoTestUserExample example);

    int updateByExample(@Param("record") BoTestUser record, @Param("example") BoTestUserExample example);

    int updateByPrimaryKeySelective(BoTestUser record);

    int updateByPrimaryKeyWithBLOBs(BoTestUser record);

    int updateByPrimaryKey(BoTestUser record);
}