package zhang.lao.build.tool;

import zhang.lao.build.kit.PropKit;

/**
 * @author
 * @create 2018-04-03 17:49
 **/
public class SysProperties {

    static {
        WXAPPSERET= PropKit.use("sys.properties").get("wx.appsecret");
        WXAPPID=PropKit.use("sys.properties").get("wx.appid");
        WXTOKEN=PropKit.use("sys.properties").get("wx.token");
        APIDOMAIN=PropKit.use("sys.properties").get("api.domain");
        CONSOLEDOMAIN=PropKit.use("sys.properties").get("console.domain");
    }
    public static final String HTTP="http://";
    public static final String WXAPPID;
    public static final String WXTOKEN;
    public static final String WXAPPSERET;
    public static final String APIDOMAIN;
    public static final String CONSOLEDOMAIN;
}
