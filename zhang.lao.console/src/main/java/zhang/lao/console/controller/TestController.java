package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.lz.mybatis.jdbc.auto.model.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.dao.base.TestDao;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangqin on 2017/3/11.
 */
@Controller
public class TestController {

    @Resource
    private TestDao testDao;

    @RequestMapping("/test/mybatis")
    public @ResponseBody  HttpResult test(){
       List<AppInfo> appInfoList= testDao.selectByExample(null);
        for (AppInfo appInfo : appInfoList) {
           Map map= testDao.selectApp(appInfo.getAppId());
            System.out.println(JSON.toJSONString(map));
        }

        return CommonResp.getSuccess();
    }
}
