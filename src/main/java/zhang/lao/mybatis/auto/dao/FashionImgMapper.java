package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionImg;
import zhang.lao.mybatis.auto.model.FashionImgExample;

public interface FashionImgMapper {
    int countByExample(FashionImgExample example);

    int deleteByExample(FashionImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FashionImg record);

    int insertSelective(FashionImg record);

    List<FashionImg> selectByExample(FashionImgExample example);

    FashionImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FashionImg record, @Param("example") FashionImgExample example);

    int updateByExample(@Param("record") FashionImg record, @Param("example") FashionImgExample example);

    int updateByPrimaryKeySelective(FashionImg record);

    int updateByPrimaryKey(FashionImg record);
}