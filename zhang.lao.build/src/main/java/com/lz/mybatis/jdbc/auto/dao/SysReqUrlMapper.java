package com.lz.mybatis.jdbc.auto.dao;

import com.lz.mybatis.jdbc.auto.model.SysReqUrl;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysReqUrlMapper {
    int countByExample(SysReqUrlExample example);

    int deleteByExample(SysReqUrlExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysReqUrl record);

    int insertSelective(SysReqUrl record);

    List<SysReqUrl> selectByExample(SysReqUrlExample example);

    SysReqUrl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysReqUrl record, @Param("example") SysReqUrlExample example);

    int updateByExample(@Param("record") SysReqUrl record, @Param("example") SysReqUrlExample example);

    int updateByPrimaryKeySelective(SysReqUrl record);

    int updateByPrimaryKey(SysReqUrl record);
}