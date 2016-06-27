package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootgrid.BootGridModel;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.mybatis.auto.dao.SysUserMapper;
import zhang.lao.mybatis.auto.model.SysUser;
import zhang.lao.mybatis.auto.model.SysUserExample;
import zhang.lao.pojo.resault.CommonResp;
import zhang.lao.tool.MD5;
import zhang.lao.tool.UUIDTool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * title:用户角色
 * </p>
 * <p>
 * description:
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
@Controller
public class SysUserController{
	@Resource
	private SysUserMapper sysUserMapper;

	@RequestMapping("/sunarvr/console/sys_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sys_user/sys_user_form";
	}

	@RequestMapping("/sunarvr/console/sys_user/base")
	public String base(){
		return "console/sys_user/sys_user_base";
	}

	@RequestMapping("/sunarvr/console/sys_user/changepass")
	public String changepass(){
		return "console/sys_user/sys_user_change_pass";
	}

	@RequestMapping("/sunarvr/console/sys_user/dochangepass")
	public @ResponseBody
	String dochangepass(String old_password,String new_password,HttpServletRequest request){
		LoginUserModel loginUserModel= (LoginUserModel) request.getSession().getAttribute("user");
		if(loginUserModel.getUser_type()!=3){
			SysUserExample sysUserQuery=new SysUserExample();
			sysUserQuery.createCriteria().andStatusEqualTo((short) 1).andUserPasswordEqualTo(MD5.MD5Encode(old_password)).andSuIdEqualTo(loginUserModel.getUser_id());
			if(sysUserMapper.countByExample(sysUserQuery)>0){
				SysUser sysUser=sysUserMapper.selectByPrimaryKey(loginUserModel.getUser_id());
				sysUser.setUserPassword(MD5.MD5Encode(new_password));
				sysUserMapper.updateByPrimaryKey(sysUser);
				return CommonResp.getJson(CommonResp.getSuccess());
			}else{
				return CommonResp.getJson(CommonResp.getError("原始密码不正确"));
			}
		}else{
			return CommonResp.getJson(CommonResp.getError("暂时不支持应用账户修改密码"));
		}
		
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/sunarvr/console/sys_user/edit")
	public String edit(ModelMap modelMap,int id){
			modelMap.put("sys_user", sysUserMapper.selectByPrimaryKey(id));
		return "console/sys_user/sys_user_form";
	}

	@RequestMapping("/sunarvr/console/sys_user/read")
	public String read(ModelMap modelMap,int id){
		modelMap.put("sys_user", sysUserMapper.selectByPrimaryKey(id));
		return "console/sys_user/sys_user_readolny_form";
	}

	@RequestMapping("/sunarvr/console/sys_user/list")
	public String list(){
		return "console/sys_user/sys_user_table";
	}

	@RequestMapping("/sunarvr/console/sys_user/json")
	@ResponseBody
	public String json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		SysUserExample sysUserExample = new SysUserExample();
		getCriteria(querys,sysUserExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		sysUserMapper.selectByExample(sysUserExample);
		List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
		return CommonResp.objectToJson(new BootGridModel(current, rowCount, sysUserList, page.getTotal()));
	}                                                                                                                      

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/sunarvr/console/sys_user/save")
	public @ResponseBody String save(String formObjectJson){
		try{
		SysUser sys_user= JSON.parseObject(formObjectJson,SysUser.class);
			Integer id=sys_user.getSuId();
		if (id!=null) {
			sysUserMapper.updateByPrimaryKeySelective(sys_user);
			return CommonResp.getJson(CommonResp.getSuccess());
		}else{
			sys_user.setCreateTime(new Date());
			sys_user.setUpdateTime(new Date());
			sys_user.setUserPassword(MD5.MD5Encode("123456"));
			sys_user.setUuid(UUIDTool.getUUID());
			sysUserMapper.insertSelective(sys_user);
			return CommonResp.getJson(CommonResp.getSuccess());
		}                                                                                                                  
		}catch(Exception e){                                                                                               
			e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
		}                                                                                                                  
		                                                                                                                   
	}

	@RequestMapping("/sunarvr/console/sys_user/delete")
	public @ResponseBody String delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			SysUser sysUser= sysUserMapper.selectByPrimaryKey(Integer.parseInt(id.toString()));
			sysUser.setStatus((short) 0);
				sysUserMapper.updateByPrimaryKey(sysUser);
		}
		return CommonResp.getJson(CommonResp.getSuccess());
	}

	private SysUserExample.Criteria getCriteria(String querys,SysUserExample.Criteria criteria){
		SysUser sysUser = JSON.parseObject(querys,SysUser.class);
		if(sysUser.getUserName()!=null&& StringUtil.isNotEmpty(sysUser.getUserName())){
			criteria.andUserNameEqualTo(sysUser.getUserName());
		}
		return criteria;
	}
}  
