package zhang.lao.console.controller.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.model.login.LoginUserModel;
import zhang.lao.console.skin.SkinNav;
import zhang.lao.mybatis.auto.dao.AppInfoMapper;
import zhang.lao.mybatis.auto.model.AppInfoExample;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:应用服务类。
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
@Controller
public class AppController{
	@Resource(name = "secoundSkin")
	private SkinNav nav;
	private AppInfoMapper appInfoMapper;
	@RequestMapping("/sunarvr/console/app")
	public String  index(HttpServletRequest request){
		LoginUserModel loginUserModel= (LoginUserModel) request.getSession().getAttribute("user");
		Integer user_id= loginUserModel.getUser_id();
	  	if(loginUserModel.getUser_type()==3){
	  			user_id= loginUserModel.getCreate_user_id();
	  	}
		request.getSession().setAttribute("nav", nav.gethtml(2, user_id, request.getContextPath()));
		String app_uuid="f0cbb6f73fc94e89a12da91480803b74";
		AppInfoExample devApp=new AppInfoExample();
		devApp.createCriteria().andUuidEqualTo(app_uuid);
		request.getSession().setAttribute("dev_app", appInfoMapper.selectByExample(devApp));
		return "console/skins/skin_2/index";
	}
}
