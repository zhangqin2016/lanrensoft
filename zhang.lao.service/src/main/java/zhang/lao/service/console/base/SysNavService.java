package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.dao.base.SysNavDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.dao.base.SysNavRoleDao;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

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
@Service
public class SysNavService{
	@Resource
	private SysNavDao sysNavDao;
	@Resource
	private SysNavRoleDao sysNavRoleDao;
	public String add(String p_id,Short level,ModelMap model){
		SysNav nav=new SysNav();
		nav.setPid(p_id);
		nav.setLevels(level);
		model.put("sysNav", nav);
		return "console/sysNav/sysNav_form";
	}

	public String edit(ModelMap modelMap,String id){
		modelMap.put("sysNav", sysNavDao.selectByPrimaryKey(id));
		return "console/sysNav/sysNav_form";
	}

	public String list(String p_id,Short level,ModelMap modelMap)
	{
		modelMap.put("p_id",p_id);
		modelMap.put("level",level);
		return "console/sysNav/sysNav_table";
	}

	public
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
		if(bootGridReq.getSort()!=null) {
			page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
		}
		SysNavExample sysNavExample = new SysNavExample();
		ControllerQueryTool.setSysNavCriteria(bootGridReq.getQuery(),sysNavExample.createCriteria());
		List<SysNav> sysNavList = sysNavDao.selectByExample(sysNavExample);
		return new BootStrapGridResp(page.getTotal(),sysNavList);
	}

	public
	HttpResult save(String formObjectJson){
			SysNav sysNav= JSON.parseObject(formObjectJson,SysNav.class);
			String id=sysNav.getNavId();
			if (id!=null) {
				sysNavDao.updateByPrimaryKeySelective(sysNav);
				return HttpResultUtil.buildSuccess();
			}else{
				sysNav.setNavId(UUIDTool.getUUID());
				sysNav.setUuid(UUIDTool.getUUID());
				sysNavDao.insertSelective(sysNav);
				return HttpResultUtil.buildSuccess();
			}


	}

	@Transactional
	public
	HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
			sysNavRoleExample.createCriteria().andNavIdEqualTo(id);
			sysNavRoleDao.deleteByExample(sysNavRoleExample);
			deleteAllRoleNavByPid(id);
			SysNavExample sysNavExample = new SysNavExample();
			sysNavExample.createCriteria().andPidEqualTo(id);
			sysNavDao.deleteByExample(sysNavExample);
			sysNavDao.deleteByPrimaryKey(String.valueOf(id));

		}
		return HttpResultUtil.buildSuccess();
	}

	@Transactional
	public void deleteAllRoleNavByPid(String id){
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andPidEqualTo(id);
		List<SysNav> list = sysNavDao.selectByExample(sysNavExample);
		for (SysNav sysNav : list) {
			SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
			sysNavRoleExample.createCriteria().andNavIdEqualTo(sysNav.getNavId());
			sysNavRoleDao.deleteByExample(sysNavRoleExample);
			deleteAllRoleNavByPid(sysNav.getNavId());
		}
	}
}
