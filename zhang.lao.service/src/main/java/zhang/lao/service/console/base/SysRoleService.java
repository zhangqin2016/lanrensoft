package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Sets;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import zhang.lao.build.mybatis.jdbc.auto.model.*;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.dao.base.*;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.pojo.console.bootstrapQ.QJson;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.service.console.ConsoleSysRoleService;

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
@Service
public class SysRoleService{
	@Resource
	private SysRoleDao sysRoleDao;
	@Resource
	private SysNavRoleDao sysNavRoleDao;
	@Resource
	private SysUserRoleDao sysUserRoleDao;
	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private SysNavDao sysNavDao;
	@Resource
	private ConsoleSysRoleService consoleSysRoleService;
	@Resource
	private SysReqUrlDao sysReqUrlDao;
	@Resource
	private SysReqUrlGroupDao sysReqUrlGroupDao;
	@Resource
	private SysReqUrlRoleDao sysReqUrlRoleDao;
	public String add(){
		return "console/sysRole/sysRole_form";
	}

	public String edit(ModelMap modelMap,String id){
		modelMap.put("sysRole", sysRoleDao.selectByPrimaryKey(id));
		return "console/sysRole/sysRole_form";
	}

	public String list(){
		return "console/sysRole/sysRole_table";
	}

	public
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
		if(bootGridReq.getSort()!=null) {
			page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
		}
		SysRoleExample sysRoleExample = new SysRoleExample();
		ControllerQueryTool.setSysRoleCriteria(bootGridReq.getQuery(),sysRoleExample.createCriteria());
		List<SysRole> sysRoleList = sysRoleDao.selectByExample(sysRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysRoleList);
	}
	private String test(){
		SysRoleExample sysRoleExample = new SysRoleExample();
		return JSON.toJSONString(sysRoleDao.selectByExample(sysRoleExample));
	}

	public
	HttpResult save(String formObjectJson){
			SysRole sysRole= JSON.parseObject(formObjectJson,SysRole.class);
			String id=sysRole.getRoleId();
			if (id!=null) {
				sysRoleDao.updateByPrimaryKeySelective(sysRole);
			}else{
				sysRole.setCreateTime(new Date());
				sysRole.setRoleId(UUIDTool.getUUID());
				sysRoleDao.insertSelective(sysRole);
			}

		return HttpResultUtil.buildSuccess();
	}
	@Transactional
	public
	HttpResult clearNavRole(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
			sysNavRoleExample.createCriteria().andRoleIdEqualTo(id);
			sysNavRoleDao.deleteByExample(sysNavRoleExample);
		}
		return HttpResultUtil.buildSuccess();
	}
	@Transactional
	public
	HttpResult clearReqRole(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysReqUrlRoleExample sysReqUrlRoleExample = new SysReqUrlRoleExample();
			sysReqUrlRoleExample.createCriteria().andRoleIdEqualTo(id);
			sysReqUrlRoleDao.deleteByExample(sysReqUrlRoleExample);
		}
		return HttpResultUtil.buildSuccess();
	}
	@Transactional
	public
	HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
			sysUserRoleExample.createCriteria().andRoleIdEqualTo(id);
			SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
			sysNavRoleExample.createCriteria().andRoleIdEqualTo(id);
			SysReqUrlRoleExample sysReqUrlRoleExample = new SysReqUrlRoleExample();
			sysReqUrlRoleExample.createCriteria().andRoleIdEqualTo(id);
			sysReqUrlRoleDao.deleteByExample(sysReqUrlRoleExample);
			sysUserRoleDao.deleteByExample(sysUserRoleExample);
			sysNavRoleDao.deleteByExample(sysNavRoleExample);
			sysRoleDao.deleteByPrimaryKey(String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}

	//给用户添加角色
	public String  user_accredit(@PathVariable String user_id, ModelMap modelMap){
		SysUser sysUser=sysUserDao.selectByPrimaryKey(user_id);
		modelMap.put("sys_roles", consoleSysRoleService.getSelectRoleHtmlByUserId(user_id));
		modelMap.put("sys_user", sysUser);
		return "console/sysRole/sys_user_accredit";
	}
	/**
	 * 给用户授权
	 */
	public
	HttpResult do_user_accredit(@PathVariable String user_id, String ids, ModelMap modelMap){
		String[]idsa=ids.split(",");
			consoleSysRoleService.updateUserRole(idsa, user_id);
		return HttpResultUtil.buildSuccess();
	}



	/**
	 * 给角色添加菜单
	 */
	public String nav_accredit(@PathVariable String role_id,ModelMap modelMap){
		SysRole sysRole= sysRoleDao.selectByPrimaryKey(role_id);
		modelMap.put("sys_role", sysRole);
		return "console/sysRole/sys_nav_accredit";
	}
	public
	List<SysNav> navJson(){
		SysNavExample query=new SysNavExample();
		query.createCriteria().andPidEqualTo("0");
		return sysNavDao.selectByExample(query);
	}
	public
	QJson nav_accreditJson(@PathVariable String role_id, @PathVariable String sys_id, ModelMap modelMap){
		return new QJson().suc(consoleSysRoleService.getRoleNavJson(role_id,sys_id));
	}

	/**
	 * 给菜单授权
	 */
	public
	HttpResult do_nav_accredit(@PathVariable String role_id, String ids, ModelMap modelMap){
		String[]idsa=ids.split(",");
			consoleSysRoleService.updateRoleNavByNavIdAndRoleId(idsa, role_id);
		return HttpResultUtil.buildSuccess();
	}

	/**
	 * 给角色添加请求权限页面
	 */
	public String req_accredit(@PathVariable String role_id,ModelMap modelMap){
		SysRole sysRole= sysRoleDao.selectByPrimaryKey(role_id);
		modelMap.put("sys_role", sysRole);
		return "console/sysRole/sys_req_accredit";
	}

	/**
	 * 给请求授权
	 */
	public
	HttpResult do_req_accredit(@PathVariable String role_id, String urls){
		String[]urlsa=urls.split(",");
			consoleSysRoleService.updateRoleReqUrl(urlsa, role_id);
		return HttpResultUtil.buildSuccess();
	}


	/**
	 * 请求分组
	 * @return
	 */
	public
	HttpResult reqGroupJson(){
		List<SysReqUrlGroup> list = sysReqUrlGroupDao.selectByExample(null);
		Set<String> set = Sets.newHashSet();
		for (SysReqUrlGroup sysReqUrl : list) {
			set.add(sysReqUrl.getId());
		}
		return HttpResultUtil.buildSuccess(set.toArray());
	}

	public
	QJson req_accreditJson( String role_id,  String groupId){
		return new QJson().suc(consoleSysRoleService.getRoleReqJson(role_id,groupId));
	}

}
