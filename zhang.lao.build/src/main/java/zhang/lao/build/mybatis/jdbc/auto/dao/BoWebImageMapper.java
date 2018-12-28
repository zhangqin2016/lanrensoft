package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebImage;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebImageExample;

public interface BoWebImageMapper {
    int countByExample(BoWebImageExample example);

    int deleteByExample(BoWebImageExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoWebImage record);

    int insertSelective(BoWebImage record);

    List<BoWebImage> selectByExample(BoWebImageExample example);

    BoWebImage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoWebImage record, @Param("example") BoWebImageExample example);

    int updateByExample(@Param("record") BoWebImage record, @Param("example") BoWebImageExample example);

    int updateByPrimaryKeySelective(BoWebImage record);

    int updateByPrimaryKey(BoWebImage record);
}