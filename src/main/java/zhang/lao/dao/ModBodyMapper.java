package zhang.lao.dao;

import zhang.lao.model.ModBody;

public interface ModBodyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModBody record);

    int insertSelective(ModBody record);

    ModBody selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModBody record);

    int updateByPrimaryKey(ModBody record);
}