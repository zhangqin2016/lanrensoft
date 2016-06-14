package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ModComplexion;
import zhang.lao.mybatis.auto.model.ModComplexionExample;

public interface ModComplexionMapper {
    int countByExample(ModComplexionExample example);

    int deleteByExample(ModComplexionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModComplexion record);

    int insertSelective(ModComplexion record);

    List<ModComplexion> selectByExample(ModComplexionExample example);

    ModComplexion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModComplexion record, @Param("example") ModComplexionExample example);

    int updateByExample(@Param("record") ModComplexion record, @Param("example") ModComplexionExample example);

    int updateByPrimaryKeySelective(ModComplexion record);

    int updateByPrimaryKey(ModComplexion record);
}