package zhang.lao.api.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhang.lao.api.wx.WxToken;

/**
 * @author
 * @create 2018-04-03 17:28
 **/
public class WxTimer {
        private static final Logger logger = LoggerFactory.getLogger(WxTimer.class);
    public void refreshToken(){
        logger.info("微信tokenchushihua ");
        WxToken.reshToken();

    }
}
