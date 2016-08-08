package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysUserRole;
import zhang.lao.mybatis.auto.model.SysUserRoleExample;

public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(Long snrId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    SysUserRole selectByPrimaryKey(Long snrId);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}