package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberLog;
import zhang.lao.mybatis.auto.model.MemberLogExample;

public interface MemberLogMapper {
    int countByExample(MemberLogExample example);

    int deleteByExample(MemberLogExample example);

    int deleteByPrimaryKey(Long mlId);

    int insert(MemberLog record);

    int insertSelective(MemberLog record);

    List<MemberLog> selectByExampleWithBLOBs(MemberLogExample example);

    List<MemberLog> selectByExample(MemberLogExample example);

    MemberLog selectByPrimaryKey(Long mlId);

    int updateByExampleSelective(@Param("record") MemberLog record, @Param("example") MemberLogExample example);

    int updateByExampleWithBLOBs(@Param("record") MemberLog record, @Param("example") MemberLogExample example);

    int updateByExample(@Param("record") MemberLog record, @Param("example") MemberLogExample example);

    int updateByPrimaryKeySelective(MemberLog record);

    int updateByPrimaryKeyWithBLOBs(MemberLog record);

    int updateByPrimaryKey(MemberLog record);
}