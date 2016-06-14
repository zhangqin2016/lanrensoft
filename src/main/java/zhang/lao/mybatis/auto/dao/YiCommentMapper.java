package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.YiComment;
import zhang.lao.mybatis.auto.model.YiCommentExample;

public interface YiCommentMapper {
    int countByExample(YiCommentExample example);

    int deleteByExample(YiCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(YiComment record);

    int insertSelective(YiComment record);

    List<YiComment> selectByExampleWithBLOBs(YiCommentExample example);

    List<YiComment> selectByExample(YiCommentExample example);

    YiComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") YiComment record, @Param("example") YiCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") YiComment record, @Param("example") YiCommentExample example);

    int updateByExample(@Param("record") YiComment record, @Param("example") YiCommentExample example);

    int updateByPrimaryKeySelective(YiComment record);

    int updateByPrimaryKeyWithBLOBs(YiComment record);

    int updateByPrimaryKey(YiComment record);
}