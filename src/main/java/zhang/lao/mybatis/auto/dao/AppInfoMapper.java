package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.AppInfo;
import zhang.lao.mybatis.auto.model.AppInfoExample;

public interface AppInfoMapper {
    int countByExample(AppInfoExample example);

    int deleteByExample(AppInfoExample example);

    int deleteByPrimaryKey(Integer daId);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Integer daId);

    int updateByExampleSelective(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByExample(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}