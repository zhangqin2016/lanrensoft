package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;

public interface SysNavMapper {
    int countByExample(SysNavExample example);

    int deleteByExample(SysNavExample example);

    int deleteByPrimaryKey(Long navId);

    int insert(SysNav record);

    int insertSelective(SysNav record);

    List<SysNav> selectByExample(SysNavExample example);

    SysNav selectByPrimaryKey(Long navId);

    int updateByExampleSelective(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByExample(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByPrimaryKeySelective(SysNav record);

    int updateByPrimaryKey(SysNav record);
}