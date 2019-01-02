package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoTestUserService;
import javax.annotation.Resource;
/**
* 
* @author ZhangQin
* @create 2018年12月28日 18:42
**/
@Controller
public class BoTestUserController{
	@Resource
	private BoTestUserService boTestUserService;

	@RequestMapping("/console/bo_test_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boTestUserService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_test_user/edit")
	public String edit(ModelMap modelMap,String id){
		return  boTestUserService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_test_user/list")
	public String list(){
		return  boTestUserService.list();
	}

	@RequestMapping("/console/bo_test_user/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boTestUserService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_test_user/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boTestUserService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_test_user/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boTestUserService.delete(ids);
	}
}
