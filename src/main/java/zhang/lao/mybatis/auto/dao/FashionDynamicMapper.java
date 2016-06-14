package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionDynamic;
import zhang.lao.mybatis.auto.model.FashionDynamicExample;

public interface FashionDynamicMapper {
    int countByExample(FashionDynamicExample example);

    int deleteByExample(FashionDynamicExample example);

    int deleteByPrimaryKey(Long fdId);

    int insert(FashionDynamic record);

    int insertSelective(FashionDynamic record);

    List<FashionDynamic> selectByExampleWithBLOBs(FashionDynamicExample example);

    List<FashionDynamic> selectByExample(FashionDynamicExample example);

    FashionDynamic selectByPrimaryKey(Long fdId);

    int updateByExampleSelective(@Param("record") FashionDynamic record, @Param("example") FashionDynamicExample example);

    int updateByExampleWithBLOBs(@Param("record") FashionDynamic record, @Param("example") FashionDynamicExample example);

    int updateByExample(@Param("record") FashionDynamic record, @Param("example") FashionDynamicExample example);

    int updateByPrimaryKeySelective(FashionDynamic record);

    int updateByPrimaryKeyWithBLOBs(FashionDynamic record);

    int updateByPrimaryKey(FashionDynamic record);
}