package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest2;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest2Example;

public interface BoTest2Mapper {
    int countByExample(BoTest2Example example);

    int deleteByExample(BoTest2Example example);

    int deleteByPrimaryKey(String id);

    int insert(BoTest2 record);

    int insertSelective(BoTest2 record);

    List<BoTest2> selectByExample(BoTest2Example example);

    BoTest2 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoTest2 record, @Param("example") BoTest2Example example);

    int updateByExample(@Param("record") BoTest2 record, @Param("example") BoTest2Example example);

    int updateByPrimaryKeySelective(BoTest2 record);

    int updateByPrimaryKey(BoTest2 record);
}