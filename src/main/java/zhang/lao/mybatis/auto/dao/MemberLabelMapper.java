package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.MemberLabel;
import zhang.lao.mybatis.auto.model.MemberLabelExample;

public interface MemberLabelMapper {
    int countByExample(MemberLabelExample example);

    int deleteByExample(MemberLabelExample example);

    int deleteByPrimaryKey(Integer ulId);

    int insert(MemberLabel record);

    int insertSelective(MemberLabel record);

    List<MemberLabel> selectByExample(MemberLabelExample example);

    MemberLabel selectByPrimaryKey(Integer ulId);

    int updateByExampleSelective(@Param("record") MemberLabel record, @Param("example") MemberLabelExample example);

    int updateByExample(@Param("record") MemberLabel record, @Param("example") MemberLabelExample example);

    int updateByPrimaryKeySelective(MemberLabel record);

    int updateByPrimaryKey(MemberLabel record);
}