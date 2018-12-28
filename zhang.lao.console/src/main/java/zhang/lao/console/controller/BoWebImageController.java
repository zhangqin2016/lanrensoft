package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoWebImageService;
import javax.annotation.Resource;
/**
* 画廊
* @author ZhangQin
* @create 2018年06月18日 22:38
**/
@Controller
public class BoWebImageController{
	@Resource
	private BoWebImageService boWebImageService;

	@RequestMapping("/console/bo_web_image/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boWebImageService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_web_image/edit")
	public String edit(ModelMap modelMap,String id){
		return  boWebImageService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_web_image/list")
	public String list(){
		return  boWebImageService.list();
	}

	@RequestMapping("/console/bo_web_image/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boWebImageService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_web_image/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boWebImageService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_web_image/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boWebImageService.delete(ids);
	}
}
