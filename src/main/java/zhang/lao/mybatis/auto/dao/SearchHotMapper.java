package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SearchHot;
import zhang.lao.mybatis.auto.model.SearchHotExample;

public interface SearchHotMapper {
    int countByExample(SearchHotExample example);

    int deleteByExample(SearchHotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SearchHot record);

    int insertSelective(SearchHot record);

    List<SearchHot> selectByExample(SearchHotExample example);

    SearchHot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SearchHot record, @Param("example") SearchHotExample example);

    int updateByExample(@Param("record") SearchHot record, @Param("example") SearchHotExample example);

    int updateByPrimaryKeySelective(SearchHot record);

    int updateByPrimaryKey(SearchHot record);
}