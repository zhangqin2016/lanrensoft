package zhang.lao.service.console;


import zhang.lao.build.mybatis.jdbc.auto.model.SysUser;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserExample;
import zhang.lao.build.tool.ListUtils;
import org.springframework.stereotype.Service;
import zhang.lao.build.tool.UserPassqwordEncrypt;
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
 * @author 张钦
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
		loginReq.setPassword(UserPassqwordEncrypt.encryptLoginPassword(loginReq.getPassword()));
		//查询用户表
		SysUserExample sysUserExample = new SysUserExample();
		String pass =loginReq.getPassword() ;
		sysUserExample.or().andStatusEqualTo((short) 1).andPhoneEqualTo(loginReq.getUserAccount()).andUserPasswordEqualTo(pass);
		sysUserExample.or().andStatusEqualTo((short) 1).andEmailEqualTo(loginReq.getUserAccount()).andUserPasswordEqualTo(pass);
		sysUserExample.or().andStatusEqualTo((short) 1).andUserAccountEqualTo(loginReq.getUserAccount()).andUserPasswordEqualTo(pass);
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
