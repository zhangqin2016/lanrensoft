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
import zhang.lao.mybatis.auto.dao.SysRoleMapper;
import zhang.lao.mybatis.auto.model.SysRole;
import zhang.lao.mybatis.auto.model.SysRoleExample;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;
import zhang.lao.pojo.resp.console.BootStrapGridResp;

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
@Controller
public class SysRoleController{
	@Resource
	private SysRoleMapper modelMapper;

	@RequestMapping("/console/sys_role/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysRole/sysRole_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_role/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysRole", modelMapper.selectByPrimaryKey(id));
		return "console/sysRole/sysRole_form";
	}

	@RequestMapping("/console/sys_role/list")
	public String list(){
		return "console/sysRole/sysRole_table";
	}

	@RequestMapping("/console/sys_role/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysRoleExample sysRoleExample = new SysRoleExample();
        ControllerQueryTool.setSysRoleCriteria(bootGridReq.getQuery(),sysRoleExample.createCriteria());
		List<SysRole> sysRoleList = modelMapper.selectByExample(sysRoleExample);
		return new BootStrapGridResp(page.getTotal(),sysRoleList);
	}
	@RequestMapping("/console/sys_role/test")
	private @ResponseBody String test(){
		SysRoleExample sysRoleExample = new SysRoleExample();
		return JSON.toJSONString(modelMapper.selectByExample(sysRoleExample));
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_role/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		try{
		SysRole sysRole= JSON.parseObject(formObjectJson,SysRole.class);
			Integer id=sysRole.getRoleId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysRole);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_role/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}
