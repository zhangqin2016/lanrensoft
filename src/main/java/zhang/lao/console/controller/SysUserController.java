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
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.mybatis.auto.dao.SysUserMapper;
import zhang.lao.mybatis.auto.model.SysUser;
import zhang.lao.mybatis.auto.model.SysUserExample;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;
import com.lz.tool.MD5;

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
	HttpResult dochangepass(String old_password,String new_password,HttpServletRequest httpsRequest){
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
	@RequestMapping("/console/sys_user/list")
	public String list(){
		return "console/sysUser/sysUser_table";
	}

	@RequestMapping("/console/sys_user/json")
	public @ResponseBody BootGridModel json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		rowCount=rowCount==-1?0:rowCount;
		SysUserExample sysUserExample = new SysUserExample();
        setCriteria(querys,sysUserExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysUser> sysUserList = modelMapper.selectByExample(sysUserExample);
		return new BootGridModel(current, rowCount, sysUserList, page.getTotal());
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_user/save")
	public @ResponseBody HttpResult save(String formObjectJson){
		try{
		SysUser sysUser= JSON.parseObject(formObjectJson,SysUser.class);
			Integer id=sysUser.getSuId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysUser);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysUser);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
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

	private SysUserExample.Criteria setCriteria(String querys,SysUserExample.Criteria criteria){
		SysUser sysUser = JSON.parseObject(querys,SysUser.class);
		       if(sysUser.getUserName()!=null){
           criteria.andUserNameEqualTo(sysUser.getUserName());
          }
       if(sysUser.getNickName()!=null){
           criteria.andNickNameEqualTo(sysUser.getNickName());
          }
       if(sysUser.getUserPassword()!=null){
           criteria.andUserPasswordEqualTo(sysUser.getUserPassword());
          }
       if(sysUser.getUserPic()!=null){
           criteria.andUserPicEqualTo(sysUser.getUserPic());
          }
       if(sysUser.getVerifyEmail()!=null){
           criteria.andVerifyEmailEqualTo(sysUser.getVerifyEmail());
          }
       if(sysUser.getPhone()!=null){
           criteria.andPhoneEqualTo(sysUser.getPhone());
          }
       if(sysUser.getEmail()!=null){
           criteria.andEmailEqualTo(sysUser.getEmail());
          }
       if(sysUser.getCreateUserId()!=null){
           criteria.andCreateUserIdEqualTo(sysUser.getCreateUserId());
          }
       if(sysUser.getUpdateUserId()!=null){
           criteria.andUpdateUserIdEqualTo(sysUser.getUpdateUserId());
          }
       if(sysUser.getUserType()!=null){
           criteria.andUserTypeEqualTo(sysUser.getUserType());
          }
       if(sysUser.getIsAuth()!=null){
           criteria.andIsAuthEqualTo(sysUser.getIsAuth());
          }
       if(sysUser.getStatus()!=null){
           criteria.andStatusEqualTo(sysUser.getStatus());
          }

		return criteria;
	}
}
