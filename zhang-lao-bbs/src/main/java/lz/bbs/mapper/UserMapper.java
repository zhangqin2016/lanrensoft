package lz.bbs.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user WHERE nick_name = #{userName}")
    Map findByName(@Param("userName") String userName);


}