package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionTags;
import zhang.lao.mybatis.auto.model.FashionTagsExample;

public interface FashionTagsMapper {
    int countByExample(FashionTagsExample example);

    int deleteByExample(FashionTagsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FashionTags record);

    int insertSelective(FashionTags record);

    List<FashionTags> selectByExample(FashionTagsExample example);

    FashionTags selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FashionTags record, @Param("example") FashionTagsExample example);

    int updateByExample(@Param("record") FashionTags record, @Param("example") FashionTagsExample example);

    int updateByPrimaryKeySelective(FashionTags record);

    int updateByPrimaryKey(FashionTags record);
}