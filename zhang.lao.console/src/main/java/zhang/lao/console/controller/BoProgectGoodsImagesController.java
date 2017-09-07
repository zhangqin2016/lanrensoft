package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoProgectGoodsImagesService;
import javax.annotation.Resource;
/**
* 项目图集
* @author ZhangQin
* @create 2017年09月07日 19:25
**/
@Controller
public class BoProgectGoodsImagesController{
	@Resource
	private BoProgectGoodsImagesService boProgectGoodsImagesService;

	@RequestMapping("/console/bo_progect_goods_images/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boProgectGoodsImagesService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_progect_goods_images/edit")
	public String edit(ModelMap modelMap,String id){
		return  boProgectGoodsImagesService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_progect_goods_images/list")
	public String list(){
		return  boProgectGoodsImagesService.list();
	}

	@RequestMapping("/console/bo_progect_goods_images/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boProgectGoodsImagesService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_progect_goods_images/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boProgectGoodsImagesService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_progect_goods_images/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boProgectGoodsImagesService.delete(ids);
	}
}
