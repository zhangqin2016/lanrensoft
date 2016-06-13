package zhang.lao.dao;

import zhang.lao.model.CommonFeedback;

public interface CommonFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonFeedback record);

    int insertSelective(CommonFeedback record);

    CommonFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonFeedback record);

    int updateByPrimaryKeyWithBLOBs(CommonFeedback record);

    int updateByPrimaryKey(CommonFeedback record);
}