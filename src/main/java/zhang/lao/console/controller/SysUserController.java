package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.tool.LzStringUtils;
import com.lz.tool.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.mybatis.auto.dao.SysUserMapper;
import zhang.lao.mybatis.auto.model.SysUser;
import zhang.lao.mybatis.auto.model.SysUserExample;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.console.CommonResp;
import zhang.lao.pojo.resp.console.HttpResult;
import zhang.lao.pojo.resp.console.BootStrapGridResp;

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
public class SysUserController {
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

	@RequestMapping("/console/sys_user/list")
	public String list(){
		return "console/sysUser/sysUser_table";
	}

	@RequestMapping("/console/sys_user/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
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
			sysUser.setUserName(null);
			modelMapper.updateByPrimaryKeySelective(sysUser);
			return CommonResp.getSuccess();
		}else{
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
	public @ResponseBody
	HttpResult delete(String ids){
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
	HttpResult dochangepass(String old_password, String new_password, HttpServletRequest httpsRequest){
		LoginUserModel loginUserModel= (LoginUserModel) httpsRequest.getSession().getAttribute("user");
		if(loginUserModel.getUser_type()!=3){
			SysUserExample sysUserExample=new SysUserExample();
			sysUserExample.createCriteria().andSuIdEqualTo(loginUserModel.getUser_id()).andUserPasswordEqualTo(MD5.MD5Encode(old_password));
			if(modelMapper.countByExample(sysUserExample)>0){
				SysUser sysUser=modelMapper.selectByPrimaryKey(loginUserModel.getUser_id());
				sysUser.setUserPassword(MD5.MD5Encode(new_password));
				modelMapper.updateByPrimaryKeySelective(sysUser);
				return CommonResp.getSuccess();
			}else{
				return CommonResp.getError("原始密码不正确");
			}
		}else{
			return CommonResp.getError("暂时不支持应用账户修改密码");
		}

	}
}
