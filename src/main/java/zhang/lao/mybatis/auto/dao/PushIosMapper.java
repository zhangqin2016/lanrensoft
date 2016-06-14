package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.PushIos;
import zhang.lao.mybatis.auto.model.PushIosExample;

public interface PushIosMapper {
    int countByExample(PushIosExample example);

    int deleteByExample(PushIosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PushIos record);

    int insertSelective(PushIos record);

    List<PushIos> selectByExampleWithBLOBs(PushIosExample example);

    List<PushIos> selectByExample(PushIosExample example);

    PushIos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PushIos record, @Param("example") PushIosExample example);

    int updateByExampleWithBLOBs(@Param("record") PushIos record, @Param("example") PushIosExample example);

    int updateByExample(@Param("record") PushIos record, @Param("example") PushIosExample example);

    int updateByPrimaryKeySelective(PushIos record);

    int updateByPrimaryKeyWithBLOBs(PushIos record);

    int updateByPrimaryKey(PushIos record);
}