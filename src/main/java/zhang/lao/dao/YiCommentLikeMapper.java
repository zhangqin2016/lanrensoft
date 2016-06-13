package zhang.lao.dao;

import zhang.lao.model.YiCommentLike;

public interface YiCommentLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YiCommentLike record);

    int insertSelective(YiCommentLike record);

    YiCommentLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YiCommentLike record);

    int updateByPrimaryKey(YiCommentLike record);
}