package zhang.lao.console.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhang.lao.dao.AppInfoMapper;
import zhang.lao.model.AppInfo;

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
