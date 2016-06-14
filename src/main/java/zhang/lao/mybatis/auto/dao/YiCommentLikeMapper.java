package zhang.lao.mybatis.auto.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhang.lao.mybatis.auto.model.YiCommentLike;
import zhang.lao.mybatis.auto.model.YiCommentLikeExample;

public interface YiCommentLikeMapper {
    int countByExample(YiCommentLikeExample example);

    int deleteByExample(YiCommentLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(YiCommentLike record);

    int insertSelective(YiCommentLike record);

    List<YiCommentLike> selectByExample(YiCommentLikeExample example);

    YiCommentLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") YiCommentLike record, @Param("example") YiCommentLikeExample example);

    int updateByExample(@Param("record") YiCommentLike record, @Param("example") YiCommentLikeExample example);

    int updateByPrimaryKeySelective(YiCommentLike record);

    int updateByPrimaryKey(YiCommentLike record);
}