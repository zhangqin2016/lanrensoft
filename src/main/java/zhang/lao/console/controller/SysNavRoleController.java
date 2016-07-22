package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.log.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootgrid.BootGridModel;
import zhang.lao.mybatis.auto.dao.SysNavRoleMapper;
import zhang.lao.mybatis.auto.model.SysNavRole;
import zhang.lao.mybatis.auto.model.SysNavRoleExample;
import zhang.lao.pojo.req.console.BootGridReq;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;

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
public class SysNavRoleController{
	@Resource
	private SysNavRoleMapper modelMapper;

	@RequestMapping("/console/sys_nav_role/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysNavRole/sysNavRole_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_nav_role/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNavRole", modelMapper.selectByPrimaryKey(id));
		return "console/sysNavRole/sysNavRole_form";
	}

	@RequestMapping("/console/sys_nav_role/list")
	public String list(){
		return "console/sysNavRole/sysNavRole_table";
	}

	@RequestMapping("/console/sys_nav_role/json")
	public @ResponseBody
	BootGridModel json(BootGridReq bootGridReq){
		int rowCount = bootGridReq.getRowCount();
		int current = bootGridReq.getCurrent();
		rowCount=rowCount==-1?0:rowCount;
		SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
        setCriteria(bootGridReq.getQuerys(),sysNavRoleExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysNavRole> sysNavRoleList = modelMapper.selectByExample(sysNavRoleExample);
		return new BootGridModel(current, rowCount, sysNavRoleList, page.getTotal());
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_nav_role/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		try{
		SysNavRole sysNavRole= JSON.parseObject(formObjectJson,SysNavRole.class);
			Integer id=sysNavRole.getSnrId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysNavRole);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysNavRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_nav_role/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}

	private SysNavRoleExample.Criteria setCriteria(String querys,SysNavRoleExample.Criteria criteria){
		SysNavRole sysNavRole = JSON.parseObject(querys,SysNavRole.class);
		       if(sysNavRole.getNavId()!=null){
           criteria.andNavIdEqualTo(sysNavRole.getNavId());
          }
       if(sysNavRole.getRoleId()!=null){
           criteria.andRoleIdEqualTo(sysNavRole.getRoleId());
          }

		return criteria;
	}
}
