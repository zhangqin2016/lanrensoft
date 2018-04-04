package zhang.lao.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.api.pojo.req.TestReq;
import zhang.lao.api.pojo.resp.TestResp;
import zhang.lao.api.wx.Token;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.extents.spring.handle.ApiData;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.resp.ApiRespData;

import java.io.IOException;

/**
 * Created by zhangqin on 2016/12/6.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public @ResponseBody
    ModelAndView index(){
        return ViewFactory.buildApiJsonpView(zhang.lao.pojo.api.resp.ApiRespData.buildSucc());
    }

    @RequestMapping("/api/test")
    public @ResponseBody
    ModelAndView test(){
        return ViewFactory.buildApiJsonpView(ApiRespData.buildSucc(Token.getInstance().getToken()));
    }

}
