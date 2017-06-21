package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoUserService;
import javax.annotation.Resource;
/**
* 用户表
* @author ZhangQin
* @create 2017年06月21日 10:31
**/
@Controller
public class BoUserController{
	@Resource
	private BoUserService boUserService;

	@RequestMapping("/console/bo_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boUserService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_user/edit")
	public String edit(ModelMap modelMap,String id){
		return  boUserService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_user/list")
	public String list(){
		return  boUserService.list();
	}

	@RequestMapping("/console/bo_user/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boUserService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_user/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boUserService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_user/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boUserService.delete(ids);
	}
}
