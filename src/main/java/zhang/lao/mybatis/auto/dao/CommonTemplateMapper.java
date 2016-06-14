package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonTemplate;
import zhang.lao.mybatis.auto.model.CommonTemplateExample;

public interface CommonTemplateMapper {
    int countByExample(CommonTemplateExample example);

    int deleteByExample(CommonTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonTemplate record);

    int insertSelective(CommonTemplate record);

    List<CommonTemplate> selectByExample(CommonTemplateExample example);

    CommonTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonTemplate record, @Param("example") CommonTemplateExample example);

    int updateByExample(@Param("record") CommonTemplate record, @Param("example") CommonTemplateExample example);

    int updateByPrimaryKeySelective(CommonTemplate record);

    int updateByPrimaryKey(CommonTemplate record);
}