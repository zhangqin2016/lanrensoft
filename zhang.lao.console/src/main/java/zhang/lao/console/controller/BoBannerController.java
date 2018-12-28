package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoBannerService;
import javax.annotation.Resource;
/**
* Banner轮播
* @author ZhangQin
* @create 2018年06月18日 22:38
**/
@Controller
public class BoBannerController{
	@Resource
	private BoBannerService boBannerService;

	@RequestMapping("/console/bo_banner/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boBannerService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_banner/edit")
	public String edit(ModelMap modelMap,String id){
		return  boBannerService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_banner/list")
	public String list(){
		return  boBannerService.list();
	}

	@RequestMapping("/console/bo_banner/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boBannerService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_banner/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boBannerService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_banner/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boBannerService.delete(ids);
	}
}
