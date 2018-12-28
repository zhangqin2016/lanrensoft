package zhang.lao.api.wx.pojo;

import zhang.lao.pojo.api.req.ApiReqBody;

/**
 * Created by Administrator on 2018/4/17.
 */
public class JsApiReq extends ApiReqBody {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
