package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonBanner;
import zhang.lao.mybatis.auto.model.CommonBannerExample;

public interface CommonBannerMapper {
    int countByExample(CommonBannerExample example);

    int deleteByExample(CommonBannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonBanner record);

    int insertSelective(CommonBanner record);

    List<CommonBanner> selectByExample(CommonBannerExample example);

    CommonBanner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonBanner record, @Param("example") CommonBannerExample example);

    int updateByExample(@Param("record") CommonBanner record, @Param("example") CommonBannerExample example);

    int updateByPrimaryKeySelective(CommonBanner record);

    int updateByPrimaryKey(CommonBanner record);
}