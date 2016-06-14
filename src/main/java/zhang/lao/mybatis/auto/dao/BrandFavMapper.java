package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.BrandFav;
import zhang.lao.mybatis.auto.model.BrandFavExample;

public interface BrandFavMapper {
    int countByExample(BrandFavExample example);

    int deleteByExample(BrandFavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandFav record);

    int insertSelective(BrandFav record);

    List<BrandFav> selectByExample(BrandFavExample example);

    BrandFav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandFav record, @Param("example") BrandFavExample example);

    int updateByExample(@Param("record") BrandFav record, @Param("example") BrandFavExample example);

    int updateByPrimaryKeySelective(BrandFav record);

    int updateByPrimaryKey(BrandFav record);
}