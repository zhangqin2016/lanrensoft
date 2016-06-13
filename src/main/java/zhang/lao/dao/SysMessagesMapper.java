package zhang.lao.dao;

import zhang.lao.model.SysMessages;

public interface SysMessagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMessages record);

    int insertSelective(SysMessages record);

    SysMessages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMessages record);

    int updateByPrimaryKeyWithBLOBs(SysMessages record);

    int updateByPrimaryKey(SysMessages record);
}