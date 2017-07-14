package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.SysUserRoleDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRoleExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import javax.annotation.Resource;
import java.util.List;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.pojo.console.resp.HttpResultUtil;

/**
* 
* @author 
* @create 
**/
 @Service
public class SysUserRoleService{
	@Resource
	private SysUserRoleDao sysUserRoleDao;

	public String add(){
		return "console/sysUserRole/sysUserRole_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysUserRole", sysUserRoleDao.selectByPrimaryKey(id));
		return "console/sysUserRole/sysUserRole_form";
	}

	public String list(){
		return "console/sysUserRole/sysUserRole_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        ControllerQueryTool.setSysUserRoleCriteria(bootGridReq.getQuery(),sysUserRoleExample.createCriteria());
		List<SysUserRole> sysUserRoleList = sysUserRoleDao.selectByExample(sysUserRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysUserRoleList);
	}

	public HttpResult save(String formObjectJson){
		SysUserRole sysUserRole= JSON.parseObject(formObjectJson,SysUserRole.class);
			java.lang.String id=sysUserRole.getSnrId();
		if (id!=null) {
			sysUserRoleDao.updateByPrimaryKeySelective(sysUserRole);
		}else{
			sysUserRole.setSnrId(UUIDTool.getUUID());
			sysUserRoleDao.insertSelective(sysUserRole);
		}

		return HttpResultUtil.buildSuccess();
	}

	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysUserRoleDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}
