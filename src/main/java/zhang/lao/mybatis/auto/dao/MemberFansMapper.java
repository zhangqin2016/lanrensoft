package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberFans;
import zhang.lao.mybatis.auto.model.MemberFansExample;

public interface MemberFansMapper {
    int countByExample(MemberFansExample example);

    int deleteByExample(MemberFansExample example);

    int deleteByPrimaryKey(Long mfId);

    int insert(MemberFans record);

    int insertSelective(MemberFans record);

    List<MemberFans> selectByExample(MemberFansExample example);

    MemberFans selectByPrimaryKey(Long mfId);

    int updateByExampleSelective(@Param("record") MemberFans record, @Param("example") MemberFansExample example);

    int updateByExample(@Param("record") MemberFans record, @Param("example") MemberFansExample example);

    int updateByPrimaryKeySelective(MemberFans record);

    int updateByPrimaryKey(MemberFans record);
}