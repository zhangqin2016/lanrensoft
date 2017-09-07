package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoProgectAroundService;
import javax.annotation.Resource;
/**
* 项目图集
* @author ZhangQin
* @create 2017年09月07日 19:25
**/
@Controller
public class BoProgectAroundController{
	@Resource
	private BoProgectAroundService boProgectAroundService;

	@RequestMapping("/console/bo_progect_around/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boProgectAroundService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_progect_around/edit")
	public String edit(ModelMap modelMap,String id){
		return  boProgectAroundService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_progect_around/list")
	public String list(){
		return  boProgectAroundService.list();
	}

	@RequestMapping("/console/bo_progect_around/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boProgectAroundService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_progect_around/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boProgectAroundService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_progect_around/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boProgectAroundService.delete(ids);
	}
}
