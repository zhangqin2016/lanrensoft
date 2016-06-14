package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionHot;
import zhang.lao.mybatis.auto.model.FashionHotExample;

public interface FashionHotMapper {
    int countByExample(FashionHotExample example);

    int deleteByExample(FashionHotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FashionHot record);

    int insertSelective(FashionHot record);

    List<FashionHot> selectByExample(FashionHotExample example);

    FashionHot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FashionHot record, @Param("example") FashionHotExample example);

    int updateByExample(@Param("record") FashionHot record, @Param("example") FashionHotExample example);

    int updateByPrimaryKeySelective(FashionHot record);

    int updateByPrimaryKey(FashionHot record);
}