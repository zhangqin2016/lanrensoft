package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.GoodsBrowseLog;
import zhang.lao.mybatis.auto.model.GoodsBrowseLogExample;

public interface GoodsBrowseLogMapper {
    int countByExample(GoodsBrowseLogExample example);

    int deleteByExample(GoodsBrowseLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsBrowseLog record);

    int insertSelective(GoodsBrowseLog record);

    List<GoodsBrowseLog> selectByExample(GoodsBrowseLogExample example);

    GoodsBrowseLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsBrowseLog record, @Param("example") GoodsBrowseLogExample example);

    int updateByExample(@Param("record") GoodsBrowseLog record, @Param("example") GoodsBrowseLogExample example);

    int updateByPrimaryKeySelective(GoodsBrowseLog record);

    int updateByPrimaryKey(GoodsBrowseLog record);
}