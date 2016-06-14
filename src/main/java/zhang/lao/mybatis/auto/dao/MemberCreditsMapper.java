package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberCredits;
import zhang.lao.mybatis.auto.model.MemberCreditsExample;

public interface MemberCreditsMapper {
    int countByExample(MemberCreditsExample example);

    int deleteByExample(MemberCreditsExample example);

    int deleteByPrimaryKey(Long mcId);

    int insert(MemberCredits record);

    int insertSelective(MemberCredits record);

    List<MemberCredits> selectByExample(MemberCreditsExample example);

    MemberCredits selectByPrimaryKey(Long mcId);

    int updateByExampleSelective(@Param("record") MemberCredits record, @Param("example") MemberCreditsExample example);

    int updateByExample(@Param("record") MemberCredits record, @Param("example") MemberCreditsExample example);

    int updateByPrimaryKeySelective(MemberCredits record);

    int updateByPrimaryKey(MemberCredits record);
}