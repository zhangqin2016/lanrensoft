package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysInfo;
import zhang.lao.mybatis.auto.model.SysInfoExample;

public interface SysInfoMapper {
    int countByExample(SysInfoExample example);

    int deleteByExample(SysInfoExample example);

    int deleteByPrimaryKey(Integer sysId);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    List<SysInfo> selectByExampleWithBLOBs(SysInfoExample example);

    List<SysInfo> selectByExample(SysInfoExample example);

    SysInfo selectByPrimaryKey(Integer sysId);

    int updateByExampleSelective(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByExample(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKeyWithBLOBs(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}