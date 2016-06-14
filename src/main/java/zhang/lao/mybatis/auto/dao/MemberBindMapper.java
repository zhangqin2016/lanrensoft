package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberBind;
import zhang.lao.mybatis.auto.model.MemberBindExample;

public interface MemberBindMapper {
    int countByExample(MemberBindExample example);

    int deleteByExample(MemberBindExample example);

    int deleteByPrimaryKey(Long mbId);

    int insert(MemberBind record);

    int insertSelective(MemberBind record);

    List<MemberBind> selectByExample(MemberBindExample example);

    MemberBind selectByPrimaryKey(Long mbId);

    int updateByExampleSelective(@Param("record") MemberBind record, @Param("example") MemberBindExample example);

    int updateByExample(@Param("record") MemberBind record, @Param("example") MemberBindExample example);

    int updateByPrimaryKeySelective(MemberBind record);

    int updateByPrimaryKey(MemberBind record);
}