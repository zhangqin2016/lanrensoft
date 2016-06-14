package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberCreditsLog;
import zhang.lao.mybatis.auto.model.MemberCreditsLogExample;

public interface MemberCreditsLogMapper {
    int countByExample(MemberCreditsLogExample example);

    int deleteByExample(MemberCreditsLogExample example);

    int deleteByPrimaryKey(Long clId);

    int insert(MemberCreditsLog record);

    int insertSelective(MemberCreditsLog record);

    List<MemberCreditsLog> selectByExample(MemberCreditsLogExample example);

    MemberCreditsLog selectByPrimaryKey(Long clId);

    int updateByExampleSelective(@Param("record") MemberCreditsLog record, @Param("example") MemberCreditsLogExample example);

    int updateByExample(@Param("record") MemberCreditsLog record, @Param("example") MemberCreditsLogExample example);

    int updateByPrimaryKeySelective(MemberCreditsLog record);

    int updateByPrimaryKey(MemberCreditsLog record);
}