package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoContactUsService;
import javax.annotation.Resource;
/**
* 客户意向
* @author ZhangQin
* @create 2018年06月18日 22:38
**/
@Controller
public class BoContactUsController{
	@Resource
	private BoContactUsService boContactUsService;

	@RequestMapping("/console/bo_contact_us/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boContactUsService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_contact_us/edit")
	public String edit(ModelMap modelMap,String id){
		return  boContactUsService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_contact_us/list")
	public String list(){
		return  boContactUsService.list();
	}

	@RequestMapping("/console/bo_contact_us/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boContactUsService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_contact_us/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boContactUsService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_contact_us/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boContactUsService.delete(ids);
	}
}
