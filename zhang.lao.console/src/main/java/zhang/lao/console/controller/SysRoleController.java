package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Sets;
import com.lz.kit.LogKit;
import com.lz.mybatis.jdbc.auto.dao.*;
import com.lz.mybatis.jdbc.auto.model.*;
import com.lz.tool.LzStringUtils;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootstrapQ.QJson;
import zhang.lao.console.service.ConsoleSysRoleService;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.console.BootStrapGridResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.resp.console.CommonResp;
import zhang.lao.pojo.resp.console.HttpResult;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
	private SysNavRoleMapper sysNavRoleMapper;
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
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
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysRole", modelMapper.selectByPrimaryKey(id));
		return "console/sysRole/sysRole_form";
	}

	@RequestMapping("/console/sys_role/list")
	public String list(){
		return "console/sysRole/sysRole_table";
	}

	@RequestMapping("/console/sys_role/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
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
	public @ResponseBody
	HttpResult save(String formObjectJson){
		try{
		SysRole sysRole= JSON.parseObject(formObjectJson,SysRole.class);
			Integer id=sysRole.getRoleId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysRole);
			return CommonResp.getSuccess();
		}else{
			sysRole.setCreateTime(new Date());
			modelMapper.insertSelective(sysRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_role/delete")
	public @ResponseBody
	HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
			sysUserRoleExample.createCriteria().andRoleIdEqualTo(Integer.parseInt(id));
			SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
			sysNavRoleExample.createCriteria().andRoleIdEqualTo(Integer.parseInt(id));
			if(sysUserRoleMapper.countByExample(sysUserRoleExample)>0||sysNavRoleMapper.countByExample(sysNavRoleExample)>0){
				continue;
			}else {
				modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
			}
		}
		return CommonResp.getSuccessByMessage("操作成功!存在角色的菜单不允许删除!");
	}

	//给用户添加角色
	@RequestMapping("/console/sys_role/user_accredit/{user_id}")
	public String  user_accredit(@PathVariable Integer user_id,ModelMap modelMap){
		SysUser sysUser=sysUserMapper.selectByPrimaryKey(user_id);
		modelMap.put("sys_roles", consoleSysRoleService.getSelectRoleHtmlByUserId(user_id));
		modelMap.put("sys_user", sysUser);
		return "console/sysRole/sys_user_accredit";
	}
 	/**
	 * 给用户授权
	 */
	@RequestMapping("/console/sys_role/do_user_accredit/{user_id}")
	public @ResponseBody
	HttpResult do_user_accredit(@PathVariable Integer user_id, String ids, ModelMap modelMap){
		String[]idsa=ids.split(",");
		try {
			consoleSysRoleService.updateUserRole(idsa, user_id);
		} catch (Exception e) {
			LogKit.error(e.getMessage(),e);
			return  CommonResp.getError(e.getMessage());
		}
		return CommonResp.getSuccess();
	}



	/**
	 * 给角色添加菜单
	 */
	@RequestMapping("/console/sys_role/nav_accredit/{role_id}")
	public String nav_accredit(@PathVariable Integer role_id,ModelMap modelMap){
		SysRole sysRole=modelMapper.selectByPrimaryKey(role_id);
		modelMap.put("sys_role", sysRole);
		return "console/sysRole/sys_nav_accredit";
	}
	@RequestMapping("/console/sys_role/nav/json")
	public @ResponseBody
	List<SysNav> navJson(){
		SysNavExample query=new SysNavExample();
		query.createCriteria().andPidEqualTo(new Integer(0));
		return sysNavMapper.selectByExample(query);
	}
	@RequestMapping("/console/sys_role/nav_accredit/json/{role_id}/{sys_id}")
	public @ResponseBody
	QJson nav_accreditJson(@PathVariable Integer role_id, @PathVariable Integer sys_id, ModelMap modelMap){
		return new QJson().suc(consoleSysRoleService.getRoleNavJson(role_id,sys_id));
	}

	/**
	 * 给菜单授权
	 */
	@RequestMapping("/console/sys_role/do_nav_accredit/{role_id}")
	public @ResponseBody
	HttpResult do_nav_accredit(@PathVariable Integer role_id, String ids, ModelMap modelMap){
		String[]idsa=ids.split(",");
		try {
			consoleSysRoleService.updateRoleNavByNavIdAndRoleId(idsa, role_id);
		} catch (Exception e) {
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError(e.getMessage());
		}
		return CommonResp.getSuccess();
	}

	/**
	 * 给角色添加请求权限页面
	 */
	@RequestMapping("/console/sys_role/req_accredit/{role_id}")
	public String req_accredit(@PathVariable Integer role_id,ModelMap modelMap){
		SysRole sysRole=modelMapper.selectByPrimaryKey(role_id);
		modelMap.put("sys_role", sysRole);
		return "console/sysRole/sys_req_accredit";
	}

	/**
	 * 给请求授权
	 */
	@RequestMapping("/console/sys_role/do_req_accredit/{role_id}")
	public @ResponseBody
	HttpResult do_req_accredit(@PathVariable Integer role_id, String urls){
		String[]urlsa=urls.split(",");
		try {
			consoleSysRoleService.updateRoleReqUrl(urlsa, role_id);
		} catch (Exception e) {
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError(e.getMessage());
		}
		return CommonResp.getSuccess();
	}

	@Resource
	private SysReqUrlMapper sysReqUrlMapper;
	@RequestMapping("/console/sys_role/req/group/json")
	public @ResponseBody
	HttpResult reqGroupJson(){
		List<SysReqUrl> list = sysReqUrlMapper.selectByExample(null);
		Set<String> set = Sets.newHashSet();
		for (SysReqUrl sysReqUrl : list) {
			String url = sysReqUrl.getUrl();
			LogKit.info(url);
			int index = url.indexOf("/");
			int index2 = url.indexOf("/",index+1);
			int index3 = url.indexOf("/",index2+1);
			String group = url.substring(0,index3+1);
			if(group.equals("")||group.equals("/")){
				continue;
			}
			set.add(sysReqUrl.getName().split("-")[0]+"("+group+")");
		}
		return CommonResp.getSuccessByData(set.toArray());
	}
	@RequestMapping("/console/sys_role/req_accredit/json")
	public @ResponseBody
	QJson req_accreditJson( Integer role_id,  String url){
		return new QJson().suc(consoleSysRoleService.getRoleReqJson(role_id,url));
	}
}
