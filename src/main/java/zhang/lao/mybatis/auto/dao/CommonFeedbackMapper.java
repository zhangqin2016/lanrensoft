package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.CommonFeedback;
import zhang.lao.mybatis.auto.model.CommonFeedbackExample;

public interface CommonFeedbackMapper {
    int countByExample(CommonFeedbackExample example);

    int deleteByExample(CommonFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonFeedback record);

    int insertSelective(CommonFeedback record);

    List<CommonFeedback> selectByExampleWithBLOBs(CommonFeedbackExample example);

    List<CommonFeedback> selectByExample(CommonFeedbackExample example);

    CommonFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonFeedback record, @Param("example") CommonFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") CommonFeedback record, @Param("example") CommonFeedbackExample example);

    int updateByExample(@Param("record") CommonFeedback record, @Param("example") CommonFeedbackExample example);

    int updateByPrimaryKeySelective(CommonFeedback record);

    int updateByPrimaryKeyWithBLOBs(CommonFeedback record);

    int updateByPrimaryKey(CommonFeedback record);
}