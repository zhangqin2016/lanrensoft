package zhang.lao.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.pojo.resp.api.ApiRespData;

/**
 * Created by zhangqin on 2016/12/6.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public ApiRespData index(){
        return ApiRespData.buildSucc();
    }
}
