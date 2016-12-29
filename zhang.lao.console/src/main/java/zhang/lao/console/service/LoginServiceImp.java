package zhang.lao.console.service;


import com.lz.mybatis.jdbc.auto.dao.SysUserMapper;
import com.lz.mybatis.jdbc.auto.model.SysUser;
import com.lz.mybatis.jdbc.auto.model.SysUserExample;
import com.lz.tool.ListUtils;
import org.springframework.stereotype.Service;
import zhang.lao.console.model.login.LoginUserModel;

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
@Service("loginServiceImp")
public class LoginServiceImp implements LoginService {

	@Resource
	private SysUserMapper sysUserService;
	@Override
	public LoginUserModel getLoginUserModel(String user_name,
											String user_password, String login_type) {
		//查询用户表
		SysUserExample sysUserExample = new SysUserExample();

		sysUserExample.createCriteria().andStatusEqualTo((short) 1).andUserNameEqualTo(user_name).andUserPasswordEqualTo(user_password)
		;
		SysUser sysUser= ListUtils.getFirst( sysUserService.selectByExample(sysUserExample));

		if(sysUser!=null){
			LoginUserModel loginUserModel=new LoginUserModel();
			loginUserModel.setEmail(sysUser.getEmail());
			loginUserModel.setIs_auth(Integer.valueOf(sysUser.getIsAuth()==null?0:sysUser.getIsAuth()));
			loginUserModel.setPhone(sysUser.getPhone());
			loginUserModel.setUser_id(sysUser.getSuId().toString());
			loginUserModel.setUser_name(sysUser.getUserName());
			loginUserModel.setUser_pic(sysUser.getUserPic());
			loginUserModel.setUser_type(LoginUserModel.loginTypeSys);
			loginUserModel.setUserNickName(sysUser.getNickName());
			loginUserModel.setVerify_email(Integer.valueOf(sysUser.getVerifyEmail()==null?0:sysUser.getVerifyEmail()));
			loginUserModel.setStatus(Integer.valueOf(sysUser.getStatus()));
			return loginUserModel;
			}else{
				return null;
			}
	
	}

}