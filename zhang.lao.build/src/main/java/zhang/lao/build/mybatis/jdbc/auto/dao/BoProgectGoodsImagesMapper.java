package zhang.lao.build.mybatis.jdbc.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImagesExample;

public interface BoProgectGoodsImagesMapper {
    int countByExample(BoProgectGoodsImagesExample example);

    int deleteByExample(BoProgectGoodsImagesExample example);

    int deleteByPrimaryKey(String id);

    int insert(BoProgectGoodsImages record);

    int insertSelective(BoProgectGoodsImages record);

    List<BoProgectGoodsImages> selectByExample(BoProgectGoodsImagesExample example);

    BoProgectGoodsImages selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BoProgectGoodsImages record, @Param("example") BoProgectGoodsImagesExample example);

    int updateByExample(@Param("record") BoProgectGoodsImages record, @Param("example") BoProgectGoodsImagesExample example);

    int updateByPrimaryKeySelective(BoProgectGoodsImages record);

    int updateByPrimaryKey(BoProgectGoodsImages record);
}