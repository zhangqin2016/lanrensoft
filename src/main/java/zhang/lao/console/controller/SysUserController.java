package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.apache.commons.lang3.StringUtils;
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

	@RequestMapping("/sunarvr/console/sys_user/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysUser/sysUser_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/sunarvr/console/sys_user/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysUser", modelMapper.selectByPrimaryKey(id));
		return "console/sysUser/sysUser_form";
	}

	@RequestMapping("/sunarvr/console/sys_user/list")
	public String list(){
		return "console/sysUser/sysUser_table";
	}

	@RequestMapping("/sunarvr/console/sys_user/json")
	public @ResponseBody String json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		SysUserExample sysUserExample = new SysUserExample();
        setCriteria(querys,sysUserExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysUser> sysUserList = modelMapper.selectByExample(sysUserExample);
		return CommonResp.objectToJson(new BootGridModel(current, rowCount, sysUserList, page.getTotal()));
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/sunarvr/console/sys_user/save")
	public @ResponseBody String save(String formObjectJson){
		try{
		SysUser sysUser= JSON.parseObject(formObjectJson,SysUser.class);
			Integer id=sysUser.getSuId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysUser);
			return CommonResp.getJson(CommonResp.getSuccess());
		}else{
			modelMapper.insertSelective(sysUser);
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
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getJson(CommonResp.getSuccess());
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
