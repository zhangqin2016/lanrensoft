package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysNavRoleDao;
import com.lz.mybatis.jdbc.auto.model.SysNavRole;
import com.lz.mybatis.jdbc.auto.model.SysNavRoleExample;
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
public class SysNavRoleService{
	@Resource
	private SysNavRoleDao sysNavRoleDao;

	public String add(){
		return "console/sysNavRole/sysNavRole_form";
	}

	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNavRole", sysNavRoleDao.selectByPrimaryKey(id));
		return "console/sysNavRole/sysNavRole_form";
	}

	public String list(){
		return "console/sysNavRole/sysNavRole_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
        ControllerQueryTool.setSysNavRoleCriteria(bootGridReq.getQuery(),sysNavRoleExample.createCriteria());
		List<SysNavRole> sysNavRoleList = sysNavRoleDao.selectByExample(sysNavRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysNavRoleList);
	}

	public HttpResult save(String formObjectJson){
		try{
		SysNavRole sysNavRole= JSON.parseObject(formObjectJson,SysNavRole.class);
			Integer id=sysNavRole.getSnrId();
		if (id!=null) {
			sysNavRoleDao.updateByPrimaryKeySelective(sysNavRole);
			return CommonResp.getSuccess();
		}else{
			sysNavRoleDao.insertSelective(sysNavRole);
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
		sysNavRoleDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
