package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.tool.LzStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;
import zhang.lao.mybatis.sql.dao.SqlSelectMapper;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;
import zhang.lao.pojo.resp.console.BootStrapGridResp;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
public class SysNavController{
	@Resource
	private SysNavMapper modelMapper;

	@RequestMapping("/console/sys_nav/add")
	@RepeatSubmit(isAdd = true)
	public String add(Integer p_id,Short level,ModelMap model){
		SysNav nav=new SysNav();
		nav.setPid(p_id);
		nav.setLevels(level);
		model.put("sysNav", nav);
		return "console/sysNav/sysNav_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_nav/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNav", modelMapper.selectByPrimaryKey(id));
		return "console/sysNav/sysNav_form";
	}

	@RequestMapping("/console/sys_nav/list")
	public String list(Integer p_id,Short level,ModelMap modelMap)
	{
		modelMap.put("p_id",p_id);
		modelMap.put("level",level);
		return "console/sysNav/sysNav_table";
	}

	@Resource
	private SqlSelectMapper sqlSelectMapper;
	@RequestMapping("/console/sys_nav/json/test")
	public @ResponseBody BootStrapGridResp test(){
		Page page = PageHelper.offsetPage(1, 1);
		List<Map<String,Object>> list=sqlSelectMapper.selectListMap("select * from sys_nav");
		return new BootStrapGridResp(page.getTotal(),list);
	}
	@RequestMapping("/console/sys_nav/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysNavExample sysNavExample = new SysNavExample();
        ControllerQueryTool.setSysNavCriteria(bootGridReq.getQuery(),sysNavExample.createCriteria());
		List<SysNav> sysNavList = modelMapper.selectByExample(sysNavExample);
		return new BootStrapGridResp(page.getTotal(),sysNavList);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_nav/save")
	public @ResponseBody HttpResult save(String formObjectJson){
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
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_nav/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
