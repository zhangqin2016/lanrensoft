package com.lz.mybatis.sql.dao;

import org.apache.ibatis.annotations.Param;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;

import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/8/10.
 */
public interface SqlSelectMapper {
    List<Map<String,Object>> selectListMap(@Param("sql") String sql);
}
