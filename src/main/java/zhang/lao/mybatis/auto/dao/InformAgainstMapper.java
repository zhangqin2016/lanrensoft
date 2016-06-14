package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.InformAgainst;
import zhang.lao.mybatis.auto.model.InformAgainstExample;

public interface InformAgainstMapper {
    int countByExample(InformAgainstExample example);

    int deleteByExample(InformAgainstExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InformAgainst record);

    int insertSelective(InformAgainst record);

    List<InformAgainst> selectByExample(InformAgainstExample example);

    InformAgainst selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InformAgainst record, @Param("example") InformAgainstExample example);

    int updateByExample(@Param("record") InformAgainst record, @Param("example") InformAgainstExample example);

    int updateByPrimaryKeySelective(InformAgainst record);

    int updateByPrimaryKey(InformAgainst record);
}