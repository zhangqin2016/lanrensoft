package zhang.lao.dao.base;

import com.lz.mybatis.jdbc.auto.dao.AppInfoMapper;
import com.lz.mybatis.jdbc.auto.model.AppInfo;

import java.util.Map;

/**
 * Created by zhangqin on 2017/3/11.
 */

public interface TestDao extends AppInfoMapper {
    public Map selectApp(int id);

}
