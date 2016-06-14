package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.ArticleBrowseLog;
import zhang.lao.mybatis.auto.model.ArticleBrowseLogExample;

public interface ArticleBrowseLogMapper {
    int countByExample(ArticleBrowseLogExample example);

    int deleteByExample(ArticleBrowseLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleBrowseLog record);

    int insertSelective(ArticleBrowseLog record);

    List<ArticleBrowseLog> selectByExample(ArticleBrowseLogExample example);

    ArticleBrowseLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleBrowseLog record, @Param("example") ArticleBrowseLogExample example);

    int updateByExample(@Param("record") ArticleBrowseLog record, @Param("example") ArticleBrowseLogExample example);

    int updateByPrimaryKeySelective(ArticleBrowseLog record);

    int updateByPrimaryKey(ArticleBrowseLog record);
}