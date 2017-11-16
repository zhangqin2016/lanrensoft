package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestExample;

public interface BoTestMapper {
    int countByExample(BoTestExample example);

    int deleteByExample(BoTestExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoTest record);

    int insertSelective(BoTest record);

    List<BoTest> selectByExample(BoTestExample example);

    BoTest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoTest record, @Param("example") BoTestExample example);

    int updateByExample(@Param("record") BoTest record, @Param("example") BoTestExample example);

    int updateByPrimaryKeySelective(BoTest record);

    int updateByPrimaryKey(BoTest record);
}