package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProject;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectExample;

public interface BoProjectMapper {
    int countByExample(BoProjectExample example);

    int deleteByExample(BoProjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoProject record);

    int insertSelective(BoProject record);

    List<BoProject> selectByExample(BoProjectExample example);

    BoProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoProject record, @Param("example") BoProjectExample example);

    int updateByExample(@Param("record") BoProject record, @Param("example") BoProjectExample example);

    int updateByPrimaryKeySelective(BoProject record);

    int updateByPrimaryKey(BoProject record);
}