package zhang.lao.service.console.base;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.mybatis.jdbc.auto.dao.SysNavMapper;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;
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
@Service
public class SysNavConsoleService{
	@Resource
	private SysNavMapper modelMapper;

	public String add(Integer p_id,Short level,ModelMap model){
		SysNav nav=new SysNav();
		nav.setPid(p_id);
		nav.setLevels(level);
		model.put("sysNav", nav);
		return "console/sysNav/sysNav_form";
	}

	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNav", modelMapper.selectByPrimaryKey(id));
		return "console/sysNav/sysNav_form";
	}

	public String list(Integer p_id,Short level,ModelMap modelMap)
	{
		modelMap.put("p_id",p_id);
		modelMap.put("level",level);
		return "console/sysNav/sysNav_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysNavExample sysNavExample = new SysNavExample();
        ControllerQueryTool.setSysNavCriteria(bootGridReq.getQuery(),sysNavExample.createCriteria());
		List<SysNav> sysNavList = modelMapper.selectByExample(sysNavExample);
		return new BootStrapGridResp(page.getTotal(),sysNavList);
	}

	public 	HttpResult save(String formObjectJson){
		try{
		SysNav sysNav= JSON.parseObject(formObjectJson,SysNav.class);
			Integer id=sysNav.getNavId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysNav);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysNav);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}
}