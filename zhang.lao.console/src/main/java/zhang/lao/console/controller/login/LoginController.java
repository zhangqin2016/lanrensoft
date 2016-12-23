package zhang.lao.console.controller.login;


import com.lz.mybatis.jdbc.auto.dao.SysNavMapper;
import com.lz.tool.MD5;
import com.lz.tool.des.Des;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.ConsoleReqUrl;
import zhang.lao.console.model.common.ConsoleContext;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.console.service.LoginService;
import zhang.lao.console.skin.SecondSkinTool;
import zhang.lao.console.skin.SkinNav;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class LoginController {

	@Resource(name = "secoundSkin")
	private SkinNav nav;
	@Resource(name = "loginServiceImp")
	private LoginService loginService;
	@Resource
	private SecondSkinTool secondSkinTool;
	@Resource
	private SysNavMapper navMapper;
	@RequestMapping(value = {ConsoleReqUrl.CONSOL})
	public String index(HttpServletRequest request, ConsoleContext consoleContext){
		request.getSession().setAttribute("firstNavHtml",secondSkinTool.getFirstNav(consoleContext.getUserId(),request.getContextPath()));
		return "console/skins/skin_2/main";
	}
	@RequestMapping("/")
	public String main(){
		return "redirect:/console/";
	}
	@RequestMapping(ConsoleReqUrl.CONSOL_LOGIN)
	public String login(ModelMap modelMap ,HttpServletRequest request,String user_account,String user_password,String captcha, HttpServletResponse response){
		if(StringUtils.isBlank(user_account)){
			modelMap.put("message", "用户名、密码不能为空!");
			return "console/skins/skin_2/login";
		}else{
				LoginUserModel sysUser = loginService.getLoginUserModel(user_account, MD5.MD5Encode(user_password), null);
				int islogin = 0;
				if (sysUser != null) {
					if (sysUser.getStatus() == 1) {
						request.getSession().setAttribute("user", sysUser);
						request.getSession().setAttribute("firstNavHtml", secondSkinTool.getFirstNav(Integer.parseInt(sysUser.getUser_id()), request.getContextPath()));
						islogin = 1;
						Cookie cookie = null;
						try {
							cookie = new Cookie("console_user", Des.encode("console_user",sysUser.getUser_id()+""));
							cookie.setMaxAge(-1);
							cookie.setPath("/");
							response.addCookie(cookie);
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						islogin = 3;
					}
				}
				if (islogin == 1) {
					return "redirect:/console/";
				} else if (islogin == 3) {
					modelMap.put("message", "该用户没有权限，请联系管理员!");
					return "console/skins/skin_2/login";
				} else {
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
