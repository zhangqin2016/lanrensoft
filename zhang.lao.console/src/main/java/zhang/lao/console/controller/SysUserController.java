package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.mybatis.jdbc.auto.dao.SysUserMapper;
import com.lz.mybatis.jdbc.auto.model.SysUser;
import com.lz.mybatis.jdbc.auto.model.SysUserExample;
import com.lz.tool.LzStringUtils;
import com.lz.tool.MD5;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.console.common.ConsoleContext;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class SysUserController{
	@Resource
	private SysUserMapper modelMapper;

	@RequestMapping("/console/sys_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysUser/sysUser_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_user/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysUser", modelMapper.selectByPrimaryKey(id));
		return "console/sysUser/sysUser_form";
	}
	@RequestMapping("/console/sys_user/list/select")
	public String select(){
		return "console/sysUser/sysUserSelect_table";
	}
	@RequestMapping("/console/sys_user/list")
	public String list(){
		return "console/sysUser/sysUser_table";
	}

	@RequestMapping("/console/sys_user/json")
	public @ResponseBody BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysUserExample sysUserExample = new SysUserExample();
        ControllerQueryTool.setSysUserCriteria(bootGridReq.getQuery(),sysUserExample.createCriteria());
		List<SysUser> sysUserList = modelMapper.selectByExample(sysUserExample);
		return new BootStrapGridResp(page.getTotal(),sysUserList);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_user/save")
	public @ResponseBody
	HttpResult save(String formObjectJson, HttpServletRequest request){
		try{
		SysUser sysUser= JSON.parseObject(formObjectJson,SysUser.class);
			Integer id=sysUser.getSuId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysUser);
			return CommonResp.getSuccess();
		}else{
			sysUser.setUserType((short) 2);
			sysUser.setUserPassword(MD5.MD5Encode("123456"));
			modelMapper.insertSelective(sysUser);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_user/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}

	@RequestMapping("/console/sys_user/base")
	public String base(){
		return "console/sysUser/sys_user_base";
	}

	@RequestMapping("/console/sys_user/changepass")
	public String changepass(){
		return "console/sysUser/sys_user_change_pass";
	}

	@RequestMapping("/console/sys_user/dochangepass")
	public @ResponseBody
	HttpResult dochangepass(String old_password, String new_password, HttpServletRequest httpsRequest, ConsoleContext consoleContext){
			SysUserExample sysUserExample=new SysUserExample();
			sysUserExample.createCriteria().andSuIdEqualTo(consoleContext.getUserId()).andUserPasswordEqualTo(MD5.MD5Encode(old_password));
			if(modelMapper.countByExample(sysUserExample)>0){
				SysUser sysUser=modelMapper.selectByPrimaryKey(consoleContext.getUserId());
				sysUser.setUserPassword(MD5.MD5Encode(new_password));
				modelMapper.updateByPrimaryKeySelective(sysUser);
				return CommonResp.getSuccess();
			}else{
				return CommonResp.getError("原始密码不正确");
			}
	}
}
