package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRoleExample;

public interface SysReqUrlRoleMapper {
    int countByExample(SysReqUrlRoleExample example);

    int deleteByExample(SysReqUrlRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysReqUrlRole record);

    int insertSelective(SysReqUrlRole record);

    List<SysReqUrlRole> selectByExample(SysReqUrlRoleExample example);

    SysReqUrlRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysReqUrlRole record, @Param("example") SysReqUrlRoleExample example);

    int updateByExample(@Param("record") SysReqUrlRole record, @Param("example") SysReqUrlRoleExample example);

    int updateByPrimaryKeySelective(SysReqUrlRole record);

    int updateByPrimaryKey(SysReqUrlRole record);
}