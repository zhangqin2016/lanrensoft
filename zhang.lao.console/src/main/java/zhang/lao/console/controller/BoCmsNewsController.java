package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoCmsNewsService;
import javax.annotation.Resource;
/**
* 新闻
* @author ZhangQin
* @create 2017年05月24日 14:19
**/
@Controller
public class BoCmsNewsController{
	@Resource
	private BoCmsNewsService boCmsNewsService;

	@RequestMapping("/console/bo_cms_news/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boCmsNewsService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_cms_news/edit")
	public String edit(ModelMap modelMap,String id){
		return  boCmsNewsService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_cms_news/list")
	public String list(){
		return  boCmsNewsService.list();
	}

	@RequestMapping("/console/bo_cms_news/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boCmsNewsService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_cms_news/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boCmsNewsService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_cms_news/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boCmsNewsService.delete(ids);
	}
}
