package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonLoginModule;
import zhang.lao.mybatis.auto.model.CommonLoginModuleExample;

public interface CommonLoginModuleMapper {
    int countByExample(CommonLoginModuleExample example);

    int deleteByExample(CommonLoginModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonLoginModule record);

    int insertSelective(CommonLoginModule record);

    List<CommonLoginModule> selectByExampleWithBLOBs(CommonLoginModuleExample example);

    List<CommonLoginModule> selectByExample(CommonLoginModuleExample example);

    CommonLoginModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonLoginModule record, @Param("example") CommonLoginModuleExample example);

    int updateByExampleWithBLOBs(@Param("record") CommonLoginModule record, @Param("example") CommonLoginModuleExample example);

    int updateByExample(@Param("record") CommonLoginModule record, @Param("example") CommonLoginModuleExample example);

    int updateByPrimaryKeySelective(CommonLoginModule record);

    int updateByPrimaryKeyWithBLOBs(CommonLoginModule record);

    int updateByPrimaryKey(CommonLoginModule record);
}