package zhang.lao.mybatis.sql.dao;

import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;

import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/8/10.
 */
public interface SqlSelectMapper {
    List<Map<String,Object>> selectListMap(@Param("sql") String sql);
}
