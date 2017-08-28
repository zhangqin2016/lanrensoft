package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.build.mybatis.jdbc.auto.model.SysDictionary;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.SysDictionaryService;
import javax.annotation.Resource;
/**
* 数据字段
* @author ZhangQin
* @create 2017年08月28日 13:49
**/
@Controller
public class SysDictionaryController{
	@Resource
	private SysDictionaryService sysDictionaryService;

	@RequestMapping("/console/sys_dictionary/add/{code}")
	@RepeatSubmit(isAdd = true)
	public String add(ModelMap modelMap , @PathVariable String code){
		SysDictionary sysDictionary = new SysDictionary();
		sysDictionary.setCode(code);
		modelMap.put("sysDictionary",sysDictionary);
		return sysDictionaryService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_dictionary/edit")
	public String edit(ModelMap modelMap,String id){
		return  sysDictionaryService.edit(modelMap,id);
	}

	@RequestMapping("/console/sys_dictionary/list/{code}")
	public String list(ModelMap modelMap , @PathVariable String code){
		modelMap.put("code",code);
		return  sysDictionaryService.list();
	}

	@RequestMapping("/console/sys_dictionary/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return sysDictionaryService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_dictionary/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return sysDictionaryService.save(formObjectJson);

	}

	@RequestMapping("/console/sys_dictionary/delete")
	public @ResponseBody HttpResult delete(String ids){
        return sysDictionaryService.delete(ids);
	}
}
