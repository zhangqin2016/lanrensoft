package zhang.lao.dao;

import zhang.lao.model.InformAgainst;

public interface InformAgainstMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InformAgainst record);

    int insertSelective(InformAgainst record);

    InformAgainst selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InformAgainst record);

    int updateByPrimaryKey(InformAgainst record);
}