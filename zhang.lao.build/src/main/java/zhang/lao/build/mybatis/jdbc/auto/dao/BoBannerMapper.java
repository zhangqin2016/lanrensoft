package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBannerExample;

public interface BoBannerMapper {
    int countByExample(BoBannerExample example);

    int deleteByExample(BoBannerExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoBanner record);

    int insertSelective(BoBanner record);

    List<BoBanner> selectByExample(BoBannerExample example);

    BoBanner selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoBanner record, @Param("example") BoBannerExample example);

    int updateByExample(@Param("record") BoBanner record, @Param("example") BoBannerExample example);

    int updateByPrimaryKeySelective(BoBanner record);

    int updateByPrimaryKey(BoBanner record);
}