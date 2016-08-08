package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.tool.LzStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootstrapQ.QJson;
import zhang.lao.console.service.ConsoleSysRoleService;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.dao.SysRoleMapper;
import zhang.lao.mybatis.auto.dao.SysUserMapper;
import zhang.lao.mybatis.auto.model.*;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;
import zhang.lao.pojo.resp.console.BootStrapGridResp;

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
	private SysRoleMapper modelMapper;
	@Resource
	private SysUserMapper sysUserMapper;
	@Resource
	private SysNavMapper sysNavMapper;
	@Resource
	private ConsoleSysRoleService consoleSysRoleService;
	@RequestMapping("/console/sys_role/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysRole/sysRole_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_role/edit")
	public String edit(ModelMap modelMap,Long id){
			modelMap.put("sysRole", modelMapper.selectByPrimaryKey(id));
		return "console/sysRole/sysRole_form";
	}

	@RequestMapping("/console/sys_role/list")
	public String list(){
		return "console/sysRole/sysRole_table";
	}

	@RequestMapping("/console/sys_role/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysRoleExample sysRoleExample = new SysRoleExample();
        ControllerQueryTool.setSysRoleCriteria(bootGridReq.getQuery(),sysRoleExample.createCriteria());
		List<SysRole> sysRoleList = modelMapper.selectByExample(sysRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysRoleList);
	}
	@RequestMapping("/console/sys_role/test")
	private @ResponseBody String test(){
		SysRoleExample sysRoleExample = new SysRoleExample();
		return JSON.toJSONString(modelMapper.selectByExample(sysRoleExample));
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_role/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		try{
		SysRole sysRole= JSON.parseObject(formObjectJson,SysRole.class);
			Long id=sysRole.getRoleId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysRole);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_role/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Long.valueOf(id));
		}
		return CommonResp.getSuccess();
	}

	//给用户添加角色
	@RequestMapping("/console/sys_role/user_accredit/{user_id}")
	public String  user_accredit(@PathVariable Long user_id,ModelMap modelMap){
		SysUser sysUser=sysUserMapper.selectByPrimaryKey(user_id);
		modelMap.put("sys_roles", consoleSysRoleService.getSelectRoleHtmlByUserId(user_id));
		modelMap.put("sys_user", sysUser);
		return "console/sysRole/sys_user_accredit";
	}
 	/**
	 * 给用户授权
	 */
	@RequestMapping("/console/sys_role/do_user_accredit/{user_id}")
	public @ResponseBody HttpResult do_user_accredit(@PathVariable Long user_id,String ids,ModelMap modelMap){
		String[]idsa=ids.split(",");
		try {
			consoleSysRoleService.updateUserRole(idsa, user_id);
		} catch (Exception e) {
			LogKit.error(e.getMessage());
			return  CommonResp.getError(e.getMessage());
		}
		return CommonResp.getSuccess();
	}

	/**
	 * 给角色添加菜单
	 */
	@RequestMapping("/console/sys_role/nav_accredit/{role_id}")
	public String nav_accredit(@PathVariable Long role_id,ModelMap modelMap){
		SysRole sysRole=modelMapper.selectByPrimaryKey(role_id);
		modelMap.put("sys_role", sysRole);
		return "console/sysRole/sys_nav_accredit";
	}
	@RequestMapping("/console/sys_role/nav/json")
	public @ResponseBody
	List<SysNav> navJson(){
		SysNavExample query=new SysNavExample();
		query.createCriteria().andPidEqualTo(new Long(0));
		return sysNavMapper.selectByExample(query);
	}
	@RequestMapping("/console/sys_role/nav_accredit/json/{role_id}/{sys_id}")
	public @ResponseBody
	QJson nav_accreditJson(@PathVariable Long role_id,@PathVariable Long sys_id, ModelMap modelMap){
		return new QJson().suc(consoleSysRoleService.getRoleNavJson(role_id,sys_id));
	}

	/**
	 * 给菜单授权
	 */
	@RequestMapping("/console/sys_role/do_nav_accredit/{role_id}")
	public @ResponseBody HttpResult do_nav_accredit(@PathVariable Long role_id,String ids,ModelMap modelMap){
		String[]idsa=ids.split(",");
		try {
			consoleSysRoleService.updateRoleNavByNavIdAndRoleId(idsa, role_id);
		} catch (Exception e) {
			LogKit.error(e.getMessage());
			return CommonResp.getError(e.getMessage());
		}
		return CommonResp.getSuccess();
	}
}
