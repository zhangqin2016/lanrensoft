package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;
import com.lz.mybatis.jdbc.auto.model.SysNavRoleExample;
import com.lz.tool.LzStringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.ConsoleMessageAnn;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.dao.ControllerQueryTool;
import zhang.lao.dao.base.SysNavDao;
import zhang.lao.dao.base.SysNavRoleDao;
import zhang.lao.pojo.console.ConsoleCacheNameContanst;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.SysNavService;

import javax.annotation.Resource;
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
public class SysNavController{
	@Resource
	private SysNavService sysNavService;

	@ConsoleMessageAnn(url ="/console/sys_nav/add",message = "菜单新增")
	@RequestMapping("/console/sys_nav/add")
	@RepeatSubmit(isAdd = true)
	public String add(Integer p_id,Short level,ModelMap model){
		return sysNavService.add(p_id,level,model);
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_nav/edit")
	public String edit(ModelMap modelMap,Integer id){
		return sysNavService.edit(modelMap,id);
	}

	@RequestMapping("/console/sys_nav/list")
	public String list(Integer p_id,Short level,ModelMap modelMap)
	{
		return sysNavService.list(p_id,level,modelMap);
	}

	@RequestMapping("/console/sys_nav/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return sysNavService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_nav/save")
	@CacheEvict(value= ConsoleCacheNameContanst.consoleServiceName, allEntries=true)
	public @ResponseBody
	HttpResult save(String formObjectJson){
		return sysNavService.save(formObjectJson);
	}
	@Resource
	private SysNavRoleDao sysNavRoleDao;
	@RequestMapping("/console/sys_nav/delete")
	public @ResponseBody
	HttpResult delete(String ids){
		return sysNavService.delete(ids);
	}
}
