package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoContactUs;
import zhang.lao.build.mybatis.jdbc.auto.model.BoContactUsExample;

public interface BoContactUsMapper {
    int countByExample(BoContactUsExample example);

    int deleteByExample(BoContactUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoContactUs record);

    int insertSelective(BoContactUs record);

    List<BoContactUs> selectByExample(BoContactUsExample example);

    BoContactUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoContactUs record, @Param("example") BoContactUsExample example);

    int updateByExample(@Param("record") BoContactUs record, @Param("example") BoContactUsExample example);

    int updateByPrimaryKeySelective(BoContactUs record);

    int updateByPrimaryKey(BoContactUs record);
}