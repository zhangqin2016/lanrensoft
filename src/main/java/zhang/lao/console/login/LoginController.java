package zhang.lao.console.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.ConsoleReqUrl;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.console.service.LoginService;
import zhang.lao.console.skin.SkinNav;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * title:用户登录处理
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
public class LoginController{

	@Resource(name = "secoundSkin")
	private SkinNav nav;
	@Resource
	private LoginService loginService;


	@RequestMapping(ConsoleReqUrl.CONSOL)
	public String index(HttpServletRequest request){
		request.getSession().setAttribute("nav", nav.gethtml(1, (Integer) request.getSession().getAttribute("user_id"),request.getContextPath()));
		return "console/skins/skin_2/index";
	}
	@RequestMapping(ConsoleReqUrl.CONSOL_LOGIN)
	public String login(ModelMap modelMap ,HttpServletRequest request,String user_account,String user_password){
		if(user_account==null||user_password==null){
			return "console/skins/skin_2/login";
		}else{
			LoginUserModel sysUser= loginService.getLoginUserModel(user_account, user_password, null);
			int islogin=0;
			if(sysUser!=null){
				if(sysUser.getStatus()==1){
					request.getSession().setAttribute("user", sysUser);
					request.getSession().setAttribute("user_id", sysUser.getUser_id());
					islogin=1;
				}else{
					islogin=3;	
				}
			}
			if(islogin==1){
				return "redirect:/console";
			}else if(islogin==3){
				modelMap.put("message", "该用户没有权限，请联系管理员!");
				return "console/skins/skin_2/login";
			}else{
				modelMap.put("message", "用户名或密码错误!");
				return "console/skins/skin_2/login";
			}
		}
	}

	@RequestMapping(ConsoleReqUrl.CONSOL_LOGOUT)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/console/login";
	}

}
