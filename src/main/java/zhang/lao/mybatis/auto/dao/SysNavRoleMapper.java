package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysNavRole;
import zhang.lao.mybatis.auto.model.SysNavRoleExample;

public interface SysNavRoleMapper {
    int countByExample(SysNavRoleExample example);

    int deleteByExample(SysNavRoleExample example);

    int deleteByPrimaryKey(Integer snrId);

    int insert(SysNavRole record);

    int insertSelective(SysNavRole record);

    List<SysNavRole> selectByExample(SysNavRoleExample example);

    SysNavRole selectByPrimaryKey(Integer snrId);

    int updateByExampleSelective(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByExample(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByPrimaryKeySelective(SysNavRole record);

    int updateByPrimaryKey(SysNavRole record);
}