package zhang.lao.console.service;


import org.springframework.stereotype.Service;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.mybatis.auto.dao.SysUserMapper;
import zhang.lao.mybatis.auto.model.SysUser;
import zhang.lao.mybatis.auto.model.SysUserExample;
import com.lz.tool.ListUtils;
import com.lz.tool.MD5;

import javax.annotation.Resource;

/**
 * <p>
 * title:系统登录处理
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
@Service
public class LoginServiceImp  implements LoginService{

	@Resource
	private SysUserMapper sysUserService;
	@Override
	public LoginUserModel getLoginUserModel(String user_name,
			String user_password,String login_type) {
		//查询用户表
		SysUserExample sysUserExample = new SysUserExample();

		sysUserExample.createCriteria().andStatusEqualTo((short) 1).andUserNameEqualTo(user_name).andUserPasswordEqualTo(MD5.MD5Encode(user_password))
		;
		SysUser sysUser= ListUtils.getFirst( sysUserService.selectByExample(sysUserExample));

		if(sysUser!=null){
			LoginUserModel loginUserModel=new LoginUserModel();
			loginUserModel.setEmail(sysUser.getEmail());
			loginUserModel.setIs_auth(Integer.valueOf(sysUser.getIsAuth()==null?0:sysUser.getIsAuth()));
			loginUserModel.setPhone(sysUser.getPhone());
			loginUserModel.setUser_id(sysUser.getSuId());
			loginUserModel.setUser_name(sysUser.getUserName());
			loginUserModel.setUser_pic(sysUser.getUserPic());
			loginUserModel.setUser_type(1);
			loginUserModel.setUserNickName(sysUser.getNickName());
			loginUserModel.setVerify_email(Integer.valueOf(sysUser.getVerifyEmail()==null?0:sysUser.getVerifyEmail()));
			loginUserModel.setStatus(Integer.valueOf(sysUser.getStatus()));
			loginUserModel.setCreate_time(sysUser.getCreateTime());
			return loginUserModel;
			}else{
				return null;
			}
	
	}

}
