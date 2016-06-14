package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionBrowseLog;
import zhang.lao.mybatis.auto.model.FashionBrowseLogExample;

public interface FashionBrowseLogMapper {
    int countByExample(FashionBrowseLogExample example);

    int deleteByExample(FashionBrowseLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FashionBrowseLog record);

    int insertSelective(FashionBrowseLog record);

    List<FashionBrowseLog> selectByExample(FashionBrowseLogExample example);

    FashionBrowseLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FashionBrowseLog record, @Param("example") FashionBrowseLogExample example);

    int updateByExample(@Param("record") FashionBrowseLog record, @Param("example") FashionBrowseLogExample example);

    int updateByPrimaryKeySelective(FashionBrowseLog record);

    int updateByPrimaryKey(FashionBrowseLog record);
}