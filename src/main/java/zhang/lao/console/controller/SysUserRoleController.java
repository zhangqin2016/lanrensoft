package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootgrid.BootGridModel;
import zhang.lao.mybatis.auto.dao.SysUserRoleMapper;
import zhang.lao.mybatis.auto.model.SysUserRole;
import zhang.lao.mybatis.auto.model.SysUserRoleExample;
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
public class SysUserRoleController{
	@Resource
	private SysUserRoleMapper modelMapper;

	@RequestMapping("/console/sys_user_role/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysUserRole/sysUserRole_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_user_role/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysUserRole", modelMapper.selectByPrimaryKey(id));
		return "console/sysUserRole/sysUserRole_form";
	}

	@RequestMapping("/console/sys_user_role/list")
	public String list(){
		return "console/sysUserRole/sysUserRole_table";
	}

	@RequestMapping("/console/sys_user_role/json")
	public @ResponseBody BootGridModel json(BootGridReq bootGridReq){
		int rowCount = bootGridReq.getRowCount();
		int current = bootGridReq.getCurrent();
		rowCount=rowCount==-1?0:rowCount;
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        setCriteria(bootGridReq.getQuerys(),sysUserRoleExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysUserRole> sysUserRoleList = modelMapper.selectByExample(sysUserRoleExample);
		return new BootGridModel(current, rowCount, sysUserRoleList, page.getTotal());
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_user_role/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		try{
		SysUserRole sysUserRole= JSON.parseObject(formObjectJson,SysUserRole.class);
			Integer id=sysUserRole.getSnrId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysUserRole);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysUserRole);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_user_role/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}

	private SysUserRoleExample.Criteria setCriteria(String querys,SysUserRoleExample.Criteria criteria){
		SysUserRole sysUserRole = JSON.parseObject(querys,SysUserRole.class);
		       if(sysUserRole.getSuId()!=null){
           criteria.andSuIdEqualTo(sysUserRole.getSuId());
          }
       if(sysUserRole.getRoleId()!=null){
           criteria.andRoleIdEqualTo(sysUserRole.getRoleId());
          }

		return criteria;
	}
}
