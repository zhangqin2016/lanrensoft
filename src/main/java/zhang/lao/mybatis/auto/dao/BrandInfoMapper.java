package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.BrandInfo;
import zhang.lao.mybatis.auto.model.BrandInfoExample;

public interface BrandInfoMapper {
    int countByExample(BrandInfoExample example);

    int deleteByExample(BrandInfoExample example);

    int deleteByPrimaryKey(Integer brandId);

    int insert(BrandInfo record);

    int insertSelective(BrandInfo record);

    List<BrandInfo> selectByExampleWithBLOBs(BrandInfoExample example);

    List<BrandInfo> selectByExample(BrandInfoExample example);

    BrandInfo selectByPrimaryKey(Integer brandId);

    int updateByExampleSelective(@Param("record") BrandInfo record, @Param("example") BrandInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BrandInfo record, @Param("example") BrandInfoExample example);

    int updateByExample(@Param("record") BrandInfo record, @Param("example") BrandInfoExample example);

    int updateByPrimaryKeySelective(BrandInfo record);

    int updateByPrimaryKeyWithBLOBs(BrandInfo record);

    int updateByPrimaryKey(BrandInfo record);
}