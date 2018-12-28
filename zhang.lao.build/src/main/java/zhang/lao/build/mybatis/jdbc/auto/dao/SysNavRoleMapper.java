package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRoleExample;

public interface SysNavRoleMapper {
    int countByExample(SysNavRoleExample example);

    int deleteByExample(SysNavRoleExample example);

    int deleteByPrimaryKey(String snrId);

    int insert(SysNavRole record);

    int insertSelective(SysNavRole record);

    List<SysNavRole> selectByExample(SysNavRoleExample example);

    SysNavRole selectByPrimaryKey(String snrId);

    int updateByExampleSelective(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByExample(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByPrimaryKeySelective(SysNavRole record);

    int updateByPrimaryKey(SysNavRole record);
}