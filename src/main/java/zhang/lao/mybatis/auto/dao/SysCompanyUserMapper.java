package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysCompanyUser;
import zhang.lao.mybatis.auto.model.SysCompanyUserExample;

public interface SysCompanyUserMapper {
    int countByExample(SysCompanyUserExample example);

    int deleteByExample(SysCompanyUserExample example);

    int deleteByPrimaryKey(Integer cuId);

    int insert(SysCompanyUser record);

    int insertSelective(SysCompanyUser record);

    List<SysCompanyUser> selectByExample(SysCompanyUserExample example);

    SysCompanyUser selectByPrimaryKey(Integer cuId);

    int updateByExampleSelective(@Param("record") SysCompanyUser record, @Param("example") SysCompanyUserExample example);

    int updateByExample(@Param("record") SysCompanyUser record, @Param("example") SysCompanyUserExample example);

    int updateByPrimaryKeySelective(SysCompanyUser record);

    int updateByPrimaryKey(SysCompanyUser record);
}