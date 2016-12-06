package zhang.lao.api.service.common;

import java.util.Date;

/**
 * Created by tech6 on 2016/7/18.
 */
public interface TokenService {

    public boolean createToken(String openid, String token, Long time);

    public boolean createToken(String openid, String token, Date createTime, Date outTime);

    /**
     * 查看数据库中token是否过时
     * @param openid
     * @param token
     * @return
     */
    public boolean isUsable(String openid, String token);
    /**
     * 查看缓存中token是否过时
     * @param openid
     * @param token
     * @return
     */
    public boolean isCacheUsable(String openid, String token);

    /**
     * 删除过时的token
     */
    public void delStale();

}
