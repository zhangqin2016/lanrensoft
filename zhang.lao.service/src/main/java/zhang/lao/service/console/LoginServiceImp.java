package zhang.lao.service.console;


import zhang.lao.build.mybatis.jdbc.auto.model.SysUser;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserExample;
import zhang.lao.build.tool.ListUtils;
import org.springframework.stereotype.Service;
import zhang.lao.dao.base.SysUserDao;
import zhang.lao.pojo.console.login.LoginReq;
import zhang.lao.pojo.console.login.LoginUserModel;

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

	/**
	 *
	 */
	@Resource
	private SysUserDao sysUserDao;
	@Override
	public LoginUserModel getLoginUserModel(LoginReq loginReq) {
		//查询用户表
		SysUserExample sysUserExample = new SysUserExample();

		sysUserExample.or().andStatusEqualTo((short) 1).andPhoneEqualTo(loginReq.getPhone()).andUserPasswordEqualTo(loginReq.getPassword());
		sysUserExample.or().andStatusEqualTo((short) 1).andEmailEqualTo(loginReq.getPhone()).andUserPasswordEqualTo(loginReq.getPassword());
		sysUserExample.or().andStatusEqualTo((short) 1).andUserAccountEqualTo(loginReq.getPhone()).andUserPasswordEqualTo(loginReq.getPassword());
		SysUser sysUser= ListUtils.getFirst( sysUserDao.selectByExample(sysUserExample));

		if(sysUser!=null){
			LoginUserModel loginUserModel=new LoginUserModel();
			loginUserModel.setUser_type(sysUser.getUserType());
			loginUserModel.setEmail(sysUser.getEmail());
			loginUserModel.setPhone(sysUser.getPhone());
			loginUserModel.setUserAccount(sysUser.getUserAccount());
			loginUserModel.setUser_id(sysUser.getSuId().toString());
			loginUserModel.setUser_pic(sysUser.getUserPic());
			loginUserModel.setUserNickName(sysUser.getNickName());
			loginUserModel.setStatus(Integer.valueOf(sysUser.getStatus()));
			return loginUserModel;
			}else{
				return null;
			}
	
	}

}
