package zhang.lao.dao;

import zhang.lao.model.YiComment;

public interface YiCommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(YiComment record);

    int insertSelective(YiComment record);

    YiComment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(YiComment record);

    int updateByPrimaryKeyWithBLOBs(YiComment record);

    int updateByPrimaryKey(YiComment record);
}