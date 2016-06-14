package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonColor;
import zhang.lao.mybatis.auto.model.CommonColorExample;

public interface CommonColorMapper {
    int countByExample(CommonColorExample example);

    int deleteByExample(CommonColorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonColor record);

    int insertSelective(CommonColor record);

    List<CommonColor> selectByExample(CommonColorExample example);

    CommonColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonColor record, @Param("example") CommonColorExample example);

    int updateByExample(@Param("record") CommonColor record, @Param("example") CommonColorExample example);

    int updateByPrimaryKeySelective(CommonColor record);

    int updateByPrimaryKey(CommonColor record);
}