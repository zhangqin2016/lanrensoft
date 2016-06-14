package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.PushAndroid;
import zhang.lao.mybatis.auto.model.PushAndroidExample;

public interface PushAndroidMapper {
    int countByExample(PushAndroidExample example);

    int deleteByExample(PushAndroidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PushAndroid record);

    int insertSelective(PushAndroid record);

    List<PushAndroid> selectByExampleWithBLOBs(PushAndroidExample example);

    List<PushAndroid> selectByExample(PushAndroidExample example);

    PushAndroid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PushAndroid record, @Param("example") PushAndroidExample example);

    int updateByExampleWithBLOBs(@Param("record") PushAndroid record, @Param("example") PushAndroidExample example);

    int updateByExample(@Param("record") PushAndroid record, @Param("example") PushAndroidExample example);

    int updateByPrimaryKeySelective(PushAndroid record);

    int updateByPrimaryKeyWithBLOBs(PushAndroid record);

    int updateByPrimaryKey(PushAndroid record);
}