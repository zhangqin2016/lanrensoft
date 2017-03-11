package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysRoleDao;
import com.lz.mybatis.jdbc.auto.model.SysRole;
import com.lz.mybatis.jdbc.auto.model.SysRoleExample;
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
public class SysRoleService{
	@Resource
	private SysRoleDao sysRoleDao;

	public String add(){
		return "console/sysRole/sysRole_form";
	}

	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysRole", sysRoleDao.selectByPrimaryKey(id));
		return "console/sysRole/sysRole_form";
	}

	public String list(){
		return "console/sysRole/sysRole_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysRoleExample sysRoleExample = new SysRoleExample();
        ControllerQueryTool.setSysRoleCriteria(bootGridReq.getQuery(),sysRoleExample.createCriteria());
		List<SysRole> sysRoleList = sysRoleDao.selectByExample(sysRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysRoleList);
	}

	public HttpResult save(String formObjectJson){
		try{
		SysRole sysRole= JSON.parseObject(formObjectJson,SysRole.class);
			Integer id=sysRole.getRoleId();
		if (id!=null) {
			sysRoleDao.updateByPrimaryKeySelective(sysRole);
			return CommonResp.getSuccess();
		}else{
			sysRoleDao.insertSelective(sysRole);
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
		sysRoleDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
