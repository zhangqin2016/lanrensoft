package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBlog;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBlogExample;

public interface BoBlogMapper {
    int countByExample(BoBlogExample example);

    int deleteByExample(BoBlogExample example);

    int deleteByPrimaryKey(String blogId);

    int insert(BoBlog record);

    int insertSelective(BoBlog record);

    List<BoBlog> selectByExampleWithBLOBs(BoBlogExample example);

    List<BoBlog> selectByExample(BoBlogExample example);

    BoBlog selectByPrimaryKey(String blogId);

    int updateByExampleSelective(@Param("record") BoBlog record, @Param("example") BoBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") BoBlog record, @Param("example") BoBlogExample example);

    int updateByExample(@Param("record") BoBlog record, @Param("example") BoBlogExample example);

    int updateByPrimaryKeySelective(BoBlog record);

    int updateByPrimaryKeyWithBLOBs(BoBlog record);

    int updateByPrimaryKey(BoBlog record);
}