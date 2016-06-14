package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SearchLog;
import zhang.lao.mybatis.auto.model.SearchLogExample;

public interface SearchLogMapper {
    int countByExample(SearchLogExample example);

    int deleteByExample(SearchLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchLog record);

    int insertSelective(SearchLog record);

    List<SearchLog> selectByExample(SearchLogExample example);

    SearchLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchLog record, @Param("example") SearchLogExample example);

    int updateByExample(@Param("record") SearchLog record, @Param("example") SearchLogExample example);

    int updateByPrimaryKeySelective(SearchLog record);

    int updateByPrimaryKey(SearchLog record);
}