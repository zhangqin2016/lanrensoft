package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoProjectService;
import javax.annotation.Resource;
/**
* 地产项目
* @author ZhangQin
* @create 2017年09月07日 19:25
**/
@Controller
public class BoProjectController{
	@Resource
	private BoProjectService boProjectService;

	@RequestMapping("/console/bo_project/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boProjectService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_project/edit")
	public String edit(ModelMap modelMap,String id){
		return  boProjectService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_project/list")
	public String list(){
		return  boProjectService.list();
	}

	@RequestMapping("/console/bo_project/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boProjectService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_project/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boProjectService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_project/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boProjectService.delete(ids);
	}
}
