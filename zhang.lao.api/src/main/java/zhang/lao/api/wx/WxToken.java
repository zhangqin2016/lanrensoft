package zhang.lao.api.wx;

import com.alibaba.fastjson.JSON;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhang.lao.api.wx.pojo.GeneralToken;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @create 2018-04-03 17:03
 **/
public class WxToken {

    private static  Logger logger = LoggerFactory.getLogger(WxToken.class);

    public static GeneralToken getToken(String appid, String secret){
        GeneralToken gt = null;
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("appid", appid);
            params.put("secret", secret);
            params.put("grant_type", "client_credential");
            String url = "https://api.weixin.qq.com/cgi-bin/token";
            HttpConfig config = HttpConfig.custom();
            //简单调用
            String resp = HttpClientUtil.post(config.url(url));

            gt = JSON.parseObject(resp,GeneralToken.class);
        }  catch (HttpProcessException e) {
            logger.error("get token error message:" + e.getMessage() , e);
        }
        return gt;
    }
    private static Token tokenCache = Token.getInstance();
    public static void reshToken() {
       /* GeneralToken token = WxToken.getToken("", "");
        tokenCache.setToken(token.getAccess_token());*/
        tokenCache.setToken(new Date().getTime()+"");
    }
}
