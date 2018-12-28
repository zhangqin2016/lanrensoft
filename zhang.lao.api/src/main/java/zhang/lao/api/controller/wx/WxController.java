package zhang.lao.api.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.api.wx.pojo.JsApiReq;
import zhang.lao.api.wx.pojo.WxJsapiResp;
import zhang.lao.build.tool.SysProperties;
import zhang.lao.build.tool.WXJSAPISign;
import zhang.lao.extents.spring.handle.ApiData;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.resp.ApiRespData;
import zhang.lao.pojo.api.resp.ApiResultEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @create 2018-04-03 17:48
 **/
@Controller
public class WxController {

    @RequestMapping(value = "/app/user/login/wx", method = {RequestMethod.GET})
    public String userwxLogin() {
        String callBack = "%2Fapp%2Fuser%2Flogin%2Fwx%2Fcallback";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SysProperties.WXAPPID + "&redirect_uri=http%3A%2F%2F" + SysProperties.APIDOMAIN + callBack + "&response_type=code&scope=snsapi_userinfo&state=myapp#wechat_redirect";
        System.out.println(url);
        return "redirect:"+url;
    }


    @RequestMapping(value = "/app/user/login/wx/callback", method = {RequestMethod.GET})
    public @ResponseBody
    ApiRespData userwxLoginCallback(String code) {
        String getAccossToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + SysProperties.WXAPPID + "&secret=" + SysProperties.WXAPPSERET + "&code=" + code + "&grant_type=authorization_code";
        HttpConfig config = HttpConfig.custom();
        //简单调用
        try {
            String resp = HttpClientUtil.get(config.url(getAccossToken));
            JSONObject jsonObject = JSON.parseObject(resp);
            String access_token = jsonObject.getString("access_token");
            if (StringUtils.isNotBlank(access_token)) {
                String openid = jsonObject.getString("openid");
                String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN";

                String userInfoString = HttpClientUtil.get(config.url(getUserInfo));
                return ApiRespData.buildSucc(userInfoString);
            }
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return ApiRespData.buildFail(ApiResultEnum.ERR500);
    }

    @RequestMapping(value = "/wx/jsapi/get", method = {RequestMethod.GET})
    public @ResponseBody ApiRespData getJsTicketGet (HttpServletRequest request, String url){
        JsTicket jsTicket = JsTicketApi.getTicket(JsTicketApi.JsApiType.jsapi);
        WxJsapiResp wxJsapiResp = new WxJsapiResp();
        String ticket =jsTicket.getTicket();
        if(ticket!=null) {
            JSONObject map = WXJSAPISign.sign(ticket, url);
            if (map != null) {
                wxJsapiResp.setAppId(SysProperties.WXAPPID);
                wxJsapiResp.setJsapiTicket(map.getString("jsapi_ticket"));
                wxJsapiResp.setUrl(map.getString("url"));
                wxJsapiResp.setNonceStr(map.getString("nonceStr"));
                wxJsapiResp.setTimestamp(map.getString("timestamp"));
                wxJsapiResp.setSignature(map.getString("signature"));
            }
        }
        return ApiRespData.buildSucc(wxJsapiResp);
    }

    @RequestMapping(value = "/wx/jsapi/get", method = {RequestMethod.POST})
    public @ResponseBody ApiRespData getJsTicketPost (@ApiData ApiReqData<JsApiReq> apiReqData){
        JsTicket jsTicket = JsTicketApi.getTicket(JsTicketApi.JsApiType.jsapi);
        WxJsapiResp wxJsapiResp = new WxJsapiResp();
        String ticket =jsTicket.getTicket();
        if(ticket!=null) {
            JSONObject map = WXJSAPISign.sign(ticket, apiReqData.getBody().getUrl());
            if (map != null) {
                wxJsapiResp.setAppId(SysProperties.WXAPPID);
                wxJsapiResp.setJsapiTicket(map.getString("jsapi_ticket"));
                wxJsapiResp.setUrl(map.getString("url"));
                wxJsapiResp.setNonceStr(map.getString("nonceStr"));
                wxJsapiResp.setTimestamp(map.getString("timestamp"));
                wxJsapiResp.setSignature(map.getString("signature"));
            }
        }
        return ApiRespData.buildSucc(wxJsapiResp);
    }
}
