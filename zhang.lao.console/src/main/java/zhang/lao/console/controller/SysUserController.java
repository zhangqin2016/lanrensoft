package zhang.lao.console.controller;

import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.common.ConsoleContext;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.service.console.base.SysUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
public class SysUserController{
	@Resource
	private SysUserService sysUserService;

	@RequestMapping("/console/sys_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return sysUserService.add();
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_user/edit")
	public String edit(ModelMap modelMap,String id){
		return sysUserService.edit(modelMap,id);
	}
	@RequestMapping("/console/sys_user/list/select")
	public String select(){
		return sysUserService.select();
	}
	@RequestMapping("/console/sys_user/list")
	public String list(){
		return sysUserService.list();
	}

	@RequestMapping("/console/sys_user/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		return sysUserService.json(bootGridReq);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_user/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		return sysUserService.save(formObjectJson);
	}

	@RequestMapping("/console/sys_user/delete")
	public @ResponseBody HttpResult delete(String ids){
		return sysUserService.delete(ids);
	}

	@RequestMapping("/console/sys_user/base")
	public String base(HttpServletRequest request){
		request.getSession().setAttribute("nav", "");
		return sysUserService.base();
	}

	@RequestMapping("/console/sys_user/changepass")
	public String changepass(HttpServletRequest request){
		request.getSession().setAttribute("nav", "");
		return sysUserService.changepass();
	}

	@RequestMapping("/console/sys_user/dochangepass")
	public @ResponseBody
	HttpResult dochangepass(String old_password, String new_password, ConsoleContext consoleContext){
	return sysUserService.dochangepass(old_password,new_password,consoleContext);
	}
	@RequestMapping("/console/sys_user/reset/password")
	public @ResponseBody
	HttpResult resetPassword(String newPassword, String uid, ConsoleContext consoleContext){
		return sysUserService.resetPassword(newPassword,uid,consoleContext);
	}

}
