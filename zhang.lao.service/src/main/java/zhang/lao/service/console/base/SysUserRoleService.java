package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysUserRoleDao;
import com.lz.mybatis.jdbc.auto.model.SysUserRole;
import com.lz.mybatis.jdbc.auto.model.SysUserRoleExample;
import com.lz.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.dao.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

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
public class SysUserRoleService{
	@Resource
	private SysUserRoleDao sysUserRoleDao;

	public String add(){
		return "console/sysUserRole/sysUserRole_form";
	}

	public String edit(ModelMap modelMap,Integer id){
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
		try{
		SysUserRole sysUserRole= JSON.parseObject(formObjectJson,SysUserRole.class);
			Integer id=sysUserRole.getSnrId();
		if (id!=null) {
			sysUserRoleDao.updateByPrimaryKeySelective(sysUserRole);
			return CommonResp.getSuccess();
		}else{
			sysUserRoleDao.insertSelective(sysUserRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}

	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysUserRoleDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
