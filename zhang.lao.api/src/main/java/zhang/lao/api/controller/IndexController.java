package zhang.lao.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.pojo.api.resp.ApiRespData;

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
}
