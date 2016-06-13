package zhang.lao.dao;

import zhang.lao.model.ModComplexion;

public interface ModComplexionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModComplexion record);

    int insertSelective(ModComplexion record);

    ModComplexion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModComplexion record);

    int updateByPrimaryKey(ModComplexion record);
}