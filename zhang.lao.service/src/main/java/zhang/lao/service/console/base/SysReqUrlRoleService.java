package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import zhang.lao.dao.base.SysReqUrlRoleDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRoleExample;
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
public class SysReqUrlRoleService{
	@Resource
	private SysReqUrlRoleDao sysReqUrlRoleDao;

	public String add(){
		return "console/sysReqUrlRole/sysReqUrlRole_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysReqUrlRole", sysReqUrlRoleDao.selectByPrimaryKey(id));
		return "console/sysReqUrlRole/sysReqUrlRole_form";
	}

	public String list(){
		return "console/sysReqUrlRole/sysReqUrlRole_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysReqUrlRoleExample sysReqUrlRoleExample = new SysReqUrlRoleExample();
        ControllerQueryTool.setSysReqUrlRoleCriteria(bootGridReq.getQuery(),sysReqUrlRoleExample.createCriteria());
		List<SysReqUrlRole> sysReqUrlRoleList = sysReqUrlRoleDao.selectByExample(sysReqUrlRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlRoleList);
	}

	public HttpResult save(String formObjectJson){
		SysReqUrlRole sysReqUrlRole= JSON.parseObject(formObjectJson,SysReqUrlRole.class);
			java.lang.String id=sysReqUrlRole.getId();
		if (id!=null) {
			sysReqUrlRoleDao.updateByPrimaryKeySelective(sysReqUrlRole);

		}else{
			sysReqUrlRole.setId(UUIDTool.getUUID());
			sysReqUrlRoleDao.insertSelective(sysReqUrlRole);
		}

		return HttpResultUtil.buildSuccess();
	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysReqUrlRoleDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}
