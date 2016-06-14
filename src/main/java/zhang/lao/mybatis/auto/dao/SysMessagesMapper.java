package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.SysMessages;
import zhang.lao.mybatis.auto.model.SysMessagesExample;

public interface SysMessagesMapper {
    int countByExample(SysMessagesExample example);

    int deleteByExample(SysMessagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMessages record);

    int insertSelective(SysMessages record);

    List<SysMessages> selectByExampleWithBLOBs(SysMessagesExample example);

    List<SysMessages> selectByExample(SysMessagesExample example);

    SysMessages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMessages record, @Param("example") SysMessagesExample example);

    int updateByExampleWithBLOBs(@Param("record") SysMessages record, @Param("example") SysMessagesExample example);

    int updateByExample(@Param("record") SysMessages record, @Param("example") SysMessagesExample example);

    int updateByPrimaryKeySelective(SysMessages record);

    int updateByPrimaryKeyWithBLOBs(SysMessages record);

    int updateByPrimaryKey(SysMessages record);
}