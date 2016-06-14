package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ArticleHot;
import zhang.lao.mybatis.auto.model.ArticleHotExample;

public interface ArticleHotMapper {
    int countByExample(ArticleHotExample example);

    int deleteByExample(ArticleHotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleHot record);

    int insertSelective(ArticleHot record);

    List<ArticleHot> selectByExample(ArticleHotExample example);

    ArticleHot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleHot record, @Param("example") ArticleHotExample example);

    int updateByExample(@Param("record") ArticleHot record, @Param("example") ArticleHotExample example);

    int updateByPrimaryKeySelective(ArticleHot record);

    int updateByPrimaryKey(ArticleHot record);
}