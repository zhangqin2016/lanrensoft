package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ArticlePost;
import zhang.lao.mybatis.auto.model.ArticlePostExample;

public interface ArticlePostMapper {
    int countByExample(ArticlePostExample example);

    int deleteByExample(ArticlePostExample example);

    int deleteByPrimaryKey(Integer postId);

    int insert(ArticlePost record);

    int insertSelective(ArticlePost record);

    List<ArticlePost> selectByExampleWithBLOBs(ArticlePostExample example);

    List<ArticlePost> selectByExample(ArticlePostExample example);

    ArticlePost selectByPrimaryKey(Integer postId);

    int updateByExampleSelective(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int updateByExample(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int updateByPrimaryKeySelective(ArticlePost record);

    int updateByPrimaryKeyWithBLOBs(ArticlePost record);

    int updateByPrimaryKey(ArticlePost record);
}