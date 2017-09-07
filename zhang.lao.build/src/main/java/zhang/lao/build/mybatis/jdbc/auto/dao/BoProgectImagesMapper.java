package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImagesExample;

public interface BoProgectImagesMapper {
    int countByExample(BoProgectImagesExample example);

    int deleteByExample(BoProgectImagesExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoProgectImages record);

    int insertSelective(BoProgectImages record);

    List<BoProgectImages> selectByExample(BoProgectImagesExample example);

    BoProgectImages selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoProgectImages record, @Param("example") BoProgectImagesExample example);

    int updateByExample(@Param("record") BoProgectImages record, @Param("example") BoProgectImagesExample example);

    int updateByPrimaryKeySelective(BoProgectImages record);

    int updateByPrimaryKey(BoProgectImages record);
}