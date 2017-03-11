package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysReqUrlRoleDao;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlRole;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlRoleExample;
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
public class SysReqUrlRoleService{
	@Resource
	private SysReqUrlRoleDao sysReqUrlRoleDao;

	public String add(){
		return "console/sysReqUrlRole/sysReqUrlRole_form";
	}

	public String edit(ModelMap modelMap,String id){
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
		try{
		SysReqUrlRole sysReqUrlRole= JSON.parseObject(formObjectJson,SysReqUrlRole.class);
			String id=sysReqUrlRole.getId();
		if (id!=null) {
			sysReqUrlRoleDao.updateByPrimaryKeySelective(sysReqUrlRole);
			return CommonResp.getSuccess();
		}else{
			sysReqUrlRoleDao.insertSelective(sysReqUrlRole);
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
		sysReqUrlRoleDao.deleteByPrimaryKey(String.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
