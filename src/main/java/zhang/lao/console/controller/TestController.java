package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.mybatis.auto.dao.AppInfoMapper;
import zhang.lao.mybatis.auto.model.AppInfo;

import javax.annotation.Resource;

@Controller
public class TestController {

	@Resource
	private AppInfoMapper appInfoMapper;

	@RequestMapping("/index")
	public @ResponseBody String helloWorld(ModelMap map){
		AppInfo appInfo =  appInfoMapper.selectByPrimaryKey(1);
		return JSON.toJSONString(appInfo);
	}

}
