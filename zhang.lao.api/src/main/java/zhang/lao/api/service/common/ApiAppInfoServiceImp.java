package zhang.lao.api.service.common;

import zhang.lao.build.mybatis.jdbc.auto.dao.AppInfoMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfo;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfoExample;
import zhang.lao.build.tool.ListUtils;
import zhang.lao.build.tool.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tech6 on 2016/7/18.
 */
@Service
public class ApiAppInfoServiceImp implements ApiAppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;
    @Override

    public String getAppKey(String appKey) {
        AppInfoExample appInfoExample = new AppInfoExample();
        appInfoExample.createCriteria().andAppKeyEqualTo(appKey);
        AppInfo authorization= ListUtils.getFirst(appInfoMapper.selectByExample(appInfoExample));
        return authorization==null?null:authorization.getAppSecret();
    }

    public boolean verify(String appid,String t,String h,String openid) {
        StringBuffer buffer=new StringBuffer(appid);
        buffer.append(t);
        buffer.append(getAppKey(appid));
        buffer.append(openid);
        if(MD5.MD5Encode(buffer.toString()).equals(h.toLowerCase())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getAppUUID(String appKey) {
        AppInfoExample appInfoExample = new AppInfoExample();
        appInfoExample.createCriteria().andAppKeyEqualTo(appKey);
        AppInfo authorization= ListUtils.getFirst(appInfoMapper.selectByExample(appInfoExample));
        return authorization==null?null:authorization.getAppSecret();
    }
}
