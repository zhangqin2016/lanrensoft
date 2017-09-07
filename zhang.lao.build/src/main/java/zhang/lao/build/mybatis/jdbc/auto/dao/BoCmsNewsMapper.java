package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNewsExample;

public interface BoCmsNewsMapper {
    int countByExample(BoCmsNewsExample example);

    int deleteByExample(BoCmsNewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoCmsNews record);

    int insertSelective(BoCmsNews record);

    List<BoCmsNews> selectByExampleWithBLOBs(BoCmsNewsExample example);

    List<BoCmsNews> selectByExample(BoCmsNewsExample example);

    BoCmsNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoCmsNews record, @Param("example") BoCmsNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") BoCmsNews record, @Param("example") BoCmsNewsExample example);

    int updateByExample(@Param("record") BoCmsNews record, @Param("example") BoCmsNewsExample example);

    int updateByPrimaryKeySelective(BoCmsNews record);

    int updateByPrimaryKeyWithBLOBs(BoCmsNews record);

    int updateByPrimaryKey(BoCmsNews record);
}