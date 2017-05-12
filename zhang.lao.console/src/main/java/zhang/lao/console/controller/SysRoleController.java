package zhang.lao.console.controller;

import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.dao.base.*;
import zhang.lao.pojo.console.bootstrapQ.QJson;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.SysRoleService;

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
public class SysRoleController{
	@Resource
	private SysRoleService sysRoleService;
	@RequestMapping("/console/sys_role/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return sysRoleService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_role/edit")
	public String edit(ModelMap modelMap,Integer id){
		return sysRoleService.edit(modelMap,id);
	}

	@RequestMapping("/console/sys_role/list")
	public String list(){
		return sysRoleService.list();
	}

	@RequestMapping("/console/sys_role/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return sysRoleService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_role/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		return sysRoleService.save(formObjectJson);

	}

	@RequestMapping("/console/sys_role/delete")
	public @ResponseBody
	HttpResult delete(String ids){
		return sysRoleService.delete(ids);
	}

	//给用户添加角色
	@RequestMapping("/console/sys_role/user_accredit/{user_id}")
	public String  user_accredit(@PathVariable Integer user_id,ModelMap modelMap){
		return sysRoleService.user_accredit(user_id,modelMap);
	}
 	/**
	 * 给用户授权
	 */
	@RequestMapping("/console/sys_role/do_user_accredit/{user_id}")
	public @ResponseBody
	HttpResult do_user_accredit(@PathVariable Integer user_id, String ids, ModelMap modelMap){

		return sysRoleService.do_user_accredit(user_id,ids,modelMap);
	}



	/**
	 * 给角色添加菜单
	 */
	@RequestMapping("/console/sys_role/nav_accredit/{role_id}")
	public String nav_accredit(@PathVariable Integer role_id,ModelMap modelMap){
		return sysRoleService.nav_accredit(role_id,modelMap);
	}
	@RequestMapping("/console/sys_role/nav/json")
	public @ResponseBody
	List<SysNav> navJson(){
		return sysRoleService.navJson();
	}
	@RequestMapping("/console/sys_role/nav_accredit/json/{role_id}/{sys_id}")
	public @ResponseBody
	QJson nav_accreditJson(@PathVariable Integer role_id, @PathVariable Integer sys_id, ModelMap modelMap){
		return sysRoleService.nav_accreditJson(role_id,sys_id,modelMap);
	}

	/**
	 * 给菜单授权
	 */
	@RequestMapping("/console/sys_role/do_nav_accredit/{role_id}")
	public @ResponseBody
	HttpResult do_nav_accredit(@PathVariable Integer role_id, String ids, ModelMap modelMap){
		 return sysRoleService.do_nav_accredit(role_id,ids,modelMap);
	}

	/**
	 * 给角色添加请求权限页面
	 */
	@RequestMapping("/console/sys_role/req_accredit/{role_id}")
	public String req_accredit(@PathVariable Integer role_id,ModelMap modelMap){
		return sysRoleService.req_accredit(role_id,modelMap);
	}

	/**
	 * 给请求授权
	 */
	@RequestMapping("/console/sys_role/do_req_accredit/{role_id}")
	public @ResponseBody
	HttpResult do_req_accredit(@PathVariable Integer role_id, String urls){
		return sysRoleService.do_req_accredit(role_id,urls);
	}

	@Resource
	private SysReqUrlDao sysReqUrlDao;
	@RequestMapping("/console/sys_role/req/group/json")
	public @ResponseBody
	HttpResult reqGroupJson(){
		return sysRoleService.reqGroupJson();
	}

	@RequestMapping("/console/sys_role/req_accredit/json")
	public @ResponseBody
	QJson req_accreditJson( Integer role_id,  String url){
		return sysRoleService.req_accreditJson(role_id,url);
	}
}
