package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBanner;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoAppBannerService;
import javax.annotation.Resource;
/**
* Banner轮播
* @author ZhangQin
* @create 2017年09月07日 19:25
**/
@Controller
public class BoAppBannerController{
	@Resource
	private BoAppBannerService boAppBannerService;

	@RequestMapping("/console/bo_app_banner/add/{type}")
	@RepeatSubmit(isAdd = true)
	public String add(@PathVariable String type,ModelMap modelMap){
		BoAppBanner boAppBanner = new BoAppBanner();
		boAppBanner.setType(type);
		modelMap.put("boAppBanner", boAppBanner);
		return "console/boAppBanner/boAppBanner_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_app_banner/edit")
	public String edit(ModelMap modelMap,String id){
		return  boAppBannerService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_app_banner/list/{type}")
	public String list(@PathVariable String type,ModelMap modelMap){
		modelMap.put("type",type);
		return  boAppBannerService.list();
	}

	@RequestMapping("/console/bo_app_banner/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boAppBannerService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_app_banner/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boAppBannerService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_app_banner/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boAppBannerService.delete(ids);
	}
}
