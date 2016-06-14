package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberStature;
import zhang.lao.mybatis.auto.model.MemberStatureExample;

public interface MemberStatureMapper {
    int countByExample(MemberStatureExample example);

    int deleteByExample(MemberStatureExample example);

    int deleteByPrimaryKey(Long msId);

    int insert(MemberStature record);

    int insertSelective(MemberStature record);

    List<MemberStature> selectByExample(MemberStatureExample example);

    MemberStature selectByPrimaryKey(Long msId);

    int updateByExampleSelective(@Param("record") MemberStature record, @Param("example") MemberStatureExample example);

    int updateByExample(@Param("record") MemberStature record, @Param("example") MemberStatureExample example);

    int updateByPrimaryKeySelective(MemberStature record);

    int updateByPrimaryKey(MemberStature record);
}