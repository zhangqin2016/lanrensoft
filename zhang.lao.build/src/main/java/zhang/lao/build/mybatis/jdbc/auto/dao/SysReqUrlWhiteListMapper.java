package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteList;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteListExample;

public interface SysReqUrlWhiteListMapper {
    int countByExample(SysReqUrlWhiteListExample example);

    int deleteByExample(SysReqUrlWhiteListExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysReqUrlWhiteList record);

    int insertSelective(SysReqUrlWhiteList record);

    List<SysReqUrlWhiteList> selectByExample(SysReqUrlWhiteListExample example);

    SysReqUrlWhiteList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysReqUrlWhiteList record, @Param("example") SysReqUrlWhiteListExample example);

    int updateByExample(@Param("record") SysReqUrlWhiteList record, @Param("example") SysReqUrlWhiteListExample example);

    int updateByPrimaryKeySelective(SysReqUrlWhiteList record);

    int updateByPrimaryKey(SysReqUrlWhiteList record);
}