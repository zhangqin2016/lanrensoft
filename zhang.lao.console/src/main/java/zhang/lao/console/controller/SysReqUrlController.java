package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.kit.Prop;
import com.lz.kit.PropKit;
import com.lz.mybatis.jdbc.auto.model.SysReqUrl;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlExample;
import com.lz.tool.LzStringUtils;
import com.lz.tool.ToolClassSearcher;
import com.lz.tool.UUIDTool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.dao.ControllerQueryTool;
import zhang.lao.dao.base.SysReqUrlDao;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.SysReqUrlService;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:
 * </p>
 *
 * @create 张钦
 * @update
 * @version 1.0
 * @date
 */
@Controller
public class SysReqUrlController{
	@Resource
	private SysReqUrlService sysReqUrlService;

	@RequestMapping("/console/sys_req_url/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return sysReqUrlService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_req_url/edit")
	public String edit(ModelMap modelMap,String id){
		return sysReqUrlService.edit(modelMap,id);
	}

	@RequestMapping("/console/sys_req_url/list")
	public String list(){
		return sysReqUrlService.list();
	}

	@RequestMapping("/console/sys_req_url/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return sysReqUrlService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_req_url/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		return sysReqUrlService.save(formObjectJson);

	}

	@RequestMapping("/console/sys_req_url/delete")
	public @ResponseBody HttpResult delete(String ids){
		return sysReqUrlService.delete(ids);
	}

	@RequestMapping("/console/sys_req_url/init")
	public  @ResponseBody HttpResult getListReq() {
		return sysReqUrlService.getListReq();
	}
}
