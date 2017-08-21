package zhang.lao.console.controller;/**
 * Created by zhangqin on 2017/8/21.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

/**
 * 测试controller
 *
 * @author
 * @create 2017-08-21 15:04
 **/
@RestController
public class TestController {

    @RequestMapping("/console/test/{fload}/user/a")
    public HttpResult testJson2(@PathVariable String fload){
        return HttpResultUtil.buildSuccess();
    }
    @RequestMapping("/console/{test}/fload/user/a")
    public HttpResult testJson(@PathVariable String test){
        return HttpResultUtil.buildSuccess();
    }
}
