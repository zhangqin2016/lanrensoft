package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAround;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAroundExample;

public interface BoProgectAroundMapper {
    int countByExample(BoProgectAroundExample example);

    int deleteByExample(BoProgectAroundExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoProgectAround record);

    int insertSelective(BoProgectAround record);

    List<BoProgectAround> selectByExample(BoProgectAroundExample example);

    BoProgectAround selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoProgectAround record, @Param("example") BoProgectAroundExample example);

    int updateByExample(@Param("record") BoProgectAround record, @Param("example") BoProgectAroundExample example);

    int updateByPrimaryKeySelective(BoProgectAround record);

    int updateByPrimaryKey(BoProgectAround record);
}