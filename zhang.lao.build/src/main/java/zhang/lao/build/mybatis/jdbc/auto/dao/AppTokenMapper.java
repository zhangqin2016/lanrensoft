package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;

public interface AppTokenMapper {
    int countByExample(AppTokenExample example);

    int deleteByExample(AppTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(AppToken record);

    int insertSelective(AppToken record);

    List<AppToken> selectByExample(AppTokenExample example);

    AppToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByExample(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByPrimaryKeySelective(AppToken record);

    int updateByPrimaryKey(AppToken record);
}