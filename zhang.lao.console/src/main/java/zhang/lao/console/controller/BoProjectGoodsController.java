package zhang.lao.console.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.BoProjectGoodsService;
import javax.annotation.Resource;
/**
* 地产项目商品
* @author ZhangQin
* @create 2017年09月07日 19:25
**/
@Controller
public class BoProjectGoodsController{
	@Resource
	private BoProjectGoodsService boProjectGoodsService;

	@RequestMapping("/console/bo_project_goods/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return boProjectGoodsService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/bo_project_goods/edit")
	public String edit(ModelMap modelMap,String id){
		return  boProjectGoodsService.edit(modelMap,id);
	}

	@RequestMapping("/console/bo_project_goods/list")
	public String list(){
		return  boProjectGoodsService.list();
	}

	@RequestMapping("/console/bo_project_goods/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return boProjectGoodsService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/bo_project_goods/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		return boProjectGoodsService.save(formObjectJson);

	}

	@RequestMapping("/console/bo_project_goods/delete")
	public @ResponseBody HttpResult delete(String ids){
        return boProjectGoodsService.delete(ids);
	}
}
