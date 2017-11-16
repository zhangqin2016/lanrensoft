package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoTestService;
import javax.annotation.Resource;
/**
* 
* @author ZhangQin
* @create 2017年11月16日 17:40
**/
@Controller
public class BoTestController{
	@Resource
	private BoTestService boTestService;

	@RequestMapping("/console/bo_test/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boTestService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_test/edit")
	public String edit(ModelMap modelMap,String id){
		return  boTestService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_test/list")
	public String list(){
		return  boTestService.list();
	}

	@RequestMapping("/console/bo_test/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boTestService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_test/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boTestService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_test/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boTestService.delete(ids);
	}
}
