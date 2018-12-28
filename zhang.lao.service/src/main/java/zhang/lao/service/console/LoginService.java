package zhang.lao.service.console;


import zhang.lao.pojo.console.login.LoginReq;
import zhang.lao.pojo.console.login.LoginUserModel;

/**
 * <p>
 * title:系统登录服务
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
public interface LoginService {

	public LoginUserModel getLoginUserModel(LoginReq loginReq);
}
