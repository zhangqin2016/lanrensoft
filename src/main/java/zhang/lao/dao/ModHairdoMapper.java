package zhang.lao.dao;

import zhang.lao.model.ModHairdo;

public interface ModHairdoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModHairdo record);

    int insertSelective(ModHairdo record);

    ModHairdo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModHairdo record);

    int updateByPrimaryKey(ModHairdo record);
}