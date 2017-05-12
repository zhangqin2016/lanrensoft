package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;

public interface SysNavMapper {
    int countByExample(SysNavExample example);

    int deleteByExample(SysNavExample example);

    int deleteByPrimaryKey(String navId);

    int insert(SysNav record);

    int insertSelective(SysNav record);

    List<SysNav> selectByExample(SysNavExample example);

    SysNav selectByPrimaryKey(String navId);

    int updateByExampleSelective(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByExample(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByPrimaryKeySelective(SysNav record);

    int updateByPrimaryKey(SysNav record);
}