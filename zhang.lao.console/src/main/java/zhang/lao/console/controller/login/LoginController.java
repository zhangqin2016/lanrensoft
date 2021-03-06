package zhang.lao.console.controller.login;


import zhang.lao.build.tool.MD5;
import zhang.lao.build.tool.UserPassqwordEncrypt;
import zhang.lao.build.tool.des.Des;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.constant.ConsoleUserConstant;
import zhang.lao.pojo.console.ConsoleReqUrl;
import zhang.lao.pojo.console.common.ConsoleContext;
import zhang.lao.pojo.console.login.LoginReq;
import zhang.lao.pojo.console.login.LoginUserModel;
import zhang.lao.service.console.LoginService;
import zhang.lao.service.console.skin.SecondSkinTool;

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
 * @author 张钦
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
@Controller
public class LoginController {

	@Resource(name = "loginServiceImp")
	private LoginService loginService;
	@Resource
	private SecondSkinTool secondSkinTool;
	@RequestMapping(value = {ConsoleReqUrl.CONSOL})
	public String index(HttpServletRequest request, ConsoleContext consoleContext){
		return "console/skins/skin_2/index";
	}
	@RequestMapping(ConsoleReqUrl.CONSOL_LOGIN)
	public String login(ModelMap modelMap , HttpServletRequest request, HttpServletResponse response, @Validated LoginReq loginReq, BindingResult result){

		if(result.hasErrors()){
			modelMap.put("login",loginReq);
			modelMap.put("message",result.getAllErrors().get(0).getDefaultMessage());
			return "console/skins/skin_2/login";
		}else
			if(request.getSession().getAttribute("loginCaptcha")==null
					||!request.getSession()
					.getAttribute("loginCaptcha").toString().toLowerCase()
					.equals(loginReq.getCaptcha().toLowerCase())){
				modelMap.put("message", "验证码不正确!");
				modelMap.put("login",loginReq);
				return "console/skins/skin_2/login";
			}
			else{
				LoginUserModel loginUserModel =null;
				if(loginReq.getLoginSource().equals("sysUser")){
					loginUserModel = loginService.getLoginUserModel(loginReq);
				}else{
					modelMap.put("login",loginReq);
					modelMap.put("message", "不支持该类型登录!");
					return "console/skins/skin_2/login";
				}
				if(loginUserModel==null){
					modelMap.put("login",loginReq);
					modelMap.put("message", "账号或密码不正确!");
					return "console/skins/skin_2/login";
				}

				int islogin = 0;
				if (loginUserModel != null) {
					if (loginUserModel.getStatus() == 1) {
						request.getSession().setAttribute(ConsoleUserConstant.SESSION_USER, loginUserModel);
						request.getSession().setAttribute(ConsoleUserConstant.SESSION_USER_FIRST_NAV, secondSkinTool.getFirstNav(loginUserModel, request.getContextPath()));
						islogin = 1;
						Cookie cookie = null;
						try {
							cookie = new Cookie(ConsoleUserConstant.COOKIE_USER_NAME, Des.encode(ConsoleUserConstant.COOKIE_USER_DES_KEY,loginUserModel.getUser_id()+""));
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
					modelMap.put("login",loginReq);
					modelMap.put("message", "该用户没有权限，请联系管理员!");
					return "console/skins/skin_2/login";
				} else {
					modelMap.put("login",loginReq);
					modelMap.put("message", "用户名或密码错误!");
					return "console/skins/skin_2/login";
				}
		}
	}

	@RequestMapping(ConsoleReqUrl.CONSOL_LOGOUT)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/console/login/";
	}

}
