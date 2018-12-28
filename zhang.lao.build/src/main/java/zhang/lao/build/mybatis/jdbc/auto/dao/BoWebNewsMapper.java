package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNewsExample;

public interface BoWebNewsMapper {
    int countByExample(BoWebNewsExample example);

    int deleteByExample(BoWebNewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoWebNews record);

    int insertSelective(BoWebNews record);

    List<BoWebNews> selectByExampleWithBLOBs(BoWebNewsExample example);

    List<BoWebNews> selectByExample(BoWebNewsExample example);

    BoWebNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoWebNews record, @Param("example") BoWebNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") BoWebNews record, @Param("example") BoWebNewsExample example);

    int updateByExample(@Param("record") BoWebNews record, @Param("example") BoWebNewsExample example);

    int updateByPrimaryKeySelective(BoWebNews record);

    int updateByPrimaryKeyWithBLOBs(BoWebNews record);

    int updateByPrimaryKey(BoWebNews record);
}