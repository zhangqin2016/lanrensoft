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
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
public interface LoginService {

	public LoginUserModel getLoginUserModel(LoginReq loginReq);
}
