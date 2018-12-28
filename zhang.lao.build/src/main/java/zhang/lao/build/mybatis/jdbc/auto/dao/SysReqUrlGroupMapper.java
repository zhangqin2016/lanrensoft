package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroup;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroupExample;

public interface SysReqUrlGroupMapper {
    int countByExample(SysReqUrlGroupExample example);

    int deleteByExample(SysReqUrlGroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysReqUrlGroup record);

    int insertSelective(SysReqUrlGroup record);

    List<SysReqUrlGroup> selectByExample(SysReqUrlGroupExample example);

    SysReqUrlGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysReqUrlGroup record, @Param("example") SysReqUrlGroupExample example);

    int updateByExample(@Param("record") SysReqUrlGroup record, @Param("example") SysReqUrlGroupExample example);

    int updateByPrimaryKeySelective(SysReqUrlGroup record);

    int updateByPrimaryKey(SysReqUrlGroup record);
}