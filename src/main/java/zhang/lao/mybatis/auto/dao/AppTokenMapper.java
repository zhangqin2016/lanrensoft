package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.AppToken;
import zhang.lao.mybatis.auto.model.AppTokenExample;

public interface AppTokenMapper {
    int countByExample(AppTokenExample example);

    int deleteByExample(AppTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppToken record);

    int insertSelective(AppToken record);

    List<AppToken> selectByExample(AppTokenExample example);

    AppToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByExample(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByPrimaryKeySelective(AppToken record);

    int updateByPrimaryKey(AppToken record);
}