package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoWebNewsService;
import javax.annotation.Resource;
/**
* 新闻
* @author ZhangQin
* @create 2018年06月18日 22:38
**/
@Controller
public class BoWebNewsController{
	@Resource
	private BoWebNewsService boWebNewsService;

	@RequestMapping("/console/bo_web_news/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boWebNewsService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_web_news/edit")
	public String edit(ModelMap modelMap,String id){
		return  boWebNewsService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_web_news/list")
	public String list(){
		return  boWebNewsService.list();
	}

	@RequestMapping("/console/bo_web_news/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boWebNewsService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_web_news/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boWebNewsService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_web_news/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boWebNewsService.delete(ids);
	}
}
