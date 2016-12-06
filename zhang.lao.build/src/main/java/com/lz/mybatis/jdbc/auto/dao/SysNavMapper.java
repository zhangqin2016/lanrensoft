package com.lz.mybatis.jdbc.auto.dao;

import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNavMapper {
    int countByExample(SysNavExample example);

    int deleteByExample(SysNavExample example);

    int deleteByPrimaryKey(Integer navId);

    int insert(SysNav record);

    int insertSelective(SysNav record);

    List<SysNav> selectByExample(SysNavExample example);

    SysNav selectByPrimaryKey(Integer navId);

    int updateByExampleSelective(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByExample(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByPrimaryKeySelective(SysNav record);

    int updateByPrimaryKey(SysNav record);
}