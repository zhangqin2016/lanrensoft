package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBannerExample;

public interface BoAppBannerMapper {
    int countByExample(BoAppBannerExample example);

    int deleteByExample(BoAppBannerExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoAppBanner record);

    int insertSelective(BoAppBanner record);

    List<BoAppBanner> selectByExample(BoAppBannerExample example);

    BoAppBanner selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoAppBanner record, @Param("example") BoAppBannerExample example);

    int updateByExample(@Param("record") BoAppBanner record, @Param("example") BoAppBannerExample example);

    int updateByPrimaryKeySelective(BoAppBanner record);

    int updateByPrimaryKey(BoAppBanner record);
}