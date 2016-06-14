package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ModHairdo;
import zhang.lao.mybatis.auto.model.ModHairdoExample;

public interface ModHairdoMapper {
    int countByExample(ModHairdoExample example);

    int deleteByExample(ModHairdoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModHairdo record);

    int insertSelective(ModHairdo record);

    List<ModHairdo> selectByExample(ModHairdoExample example);

    ModHairdo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModHairdo record, @Param("example") ModHairdoExample example);

    int updateByExample(@Param("record") ModHairdo record, @Param("example") ModHairdoExample example);

    int updateByPrimaryKeySelective(ModHairdo record);

    int updateByPrimaryKey(ModHairdo record);
}