package zhang.lao.api.service.common;

/**
 * Created by tech6 on 2016/7/18.
 */
public interface ApiAppInfoService {


    /**
     * 更具appid获取appkey
     * @param appKey
     * @return
     */
    public String getAppKey(String appKey);

    /**
     * 更具appid获取appuuid
     * @param appKey
     * @return
     */
    public String getAppUUID(String appKey);

    /**
     * 验证
     * @param appKey
     * @param t
     * @param h
     * @param openid
     * @return
     */
    public boolean verify(String appKey, String t, String h, String openid);
}
