package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.FashionLikeLog;
import zhang.lao.mybatis.auto.model.FashionLikeLogExample;

public interface FashionLikeLogMapper {
    int countByExample(FashionLikeLogExample example);

    int deleteByExample(FashionLikeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FashionLikeLog record);

    int insertSelective(FashionLikeLog record);

    List<FashionLikeLog> selectByExample(FashionLikeLogExample example);

    FashionLikeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FashionLikeLog record, @Param("example") FashionLikeLogExample example);

    int updateByExample(@Param("record") FashionLikeLog record, @Param("example") FashionLikeLogExample example);

    int updateByPrimaryKeySelective(FashionLikeLog record);

    int updateByPrimaryKey(FashionLikeLog record);
}