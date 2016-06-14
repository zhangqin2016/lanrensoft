package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ModBody;
import zhang.lao.mybatis.auto.model.ModBodyExample;

public interface ModBodyMapper {
    int countByExample(ModBodyExample example);

    int deleteByExample(ModBodyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModBody record);

    int insertSelective(ModBody record);

    List<ModBody> selectByExample(ModBodyExample example);

    ModBody selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModBody record, @Param("example") ModBodyExample example);

    int updateByExample(@Param("record") ModBody record, @Param("example") ModBodyExample example);

    int updateByPrimaryKeySelective(ModBody record);

    int updateByPrimaryKey(ModBody record);
}