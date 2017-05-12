package zhang.lao.api.service.common;

import zhang.lao.build.kit.ehcache.CacheKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.AppTokenMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;
import zhang.lao.build.tool.ListUtils;
import zhang.lao.build.tool.UUIDTool;
import org.springframework.stereotype.Service;
import zhang.lao.api.constant.CacheKey;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tech6 on 2016/7/18.
 */
@Service
public class TokenServiceImp implements TokenService {

    @Resource
    private AppTokenMapper appTokenMapper;

    public boolean createToken(String openid,String token,Long time){
        AppToken systemToken=new AppToken();
        Date date=new Date();
        systemToken.setToken(token);
        systemToken.setCreateTime(date);
        Long now=date.getTime()+time;
        systemToken.setExpiresTime(new Date(now));
        systemToken.setOpenid(openid);
        systemToken.setUuid(UUIDTool.getUUID());
        return appTokenMapper.insertSelective(systemToken)>0;
    }


    public boolean isUsable(String openid,String token){
        AppTokenExample appTokenExample = new AppTokenExample();
        appTokenExample.createCriteria().andExpiresTimeGreaterThan(new Date()).andOpenidEqualTo(openid).andTokenEqualTo(token);
        return ListUtils.getFirst(appTokenMapper.selectByExample(appTokenExample))==null?false:true;
    }


    @Override
    public void delStale() {
        AppTokenExample appTokenExample = new AppTokenExample();
        appTokenExample.createCriteria().andExpiresTimeLessThan(new Date());
        appTokenMapper.deleteByExample(appTokenExample);
    }


    @Override
    public boolean isCacheUsable(String openid, String token) {

        return CacheKit.get(CacheKey.CACHEKEY, openid + ":" + token)==null?false:true;
    }


    @Override
    public boolean createToken(String openid, String token, Date createTime,
                               Date outTime) {
        AppToken systemToken=new AppToken();
        systemToken.setCreateTime(createTime);
        systemToken.setToken(token);
        systemToken.setExpiresTime(outTime);
        systemToken.setOpenid(openid);
        systemToken.setUuid( UUIDTool.getUUID());
        return appTokenMapper.insertSelective(systemToken)>0;
    }

}
