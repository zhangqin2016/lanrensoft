package zhang.lao.console.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.common.ConsoleContext;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.service.console.skin.SecondSkinTool;
import zhang.lao.service.console.skin.SkinNav;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/6/30.
 */
@Controller
public class PageTurnController {
    @Resource(name = "secoundSkin")
    private SkinNav skinNav;
    @Resource(name = "secondSkinTool")
    private SecondSkinTool secondSkinTool;

    @RequestMapping("/console/nav/trun/first")
    public String getNavFirstReturn(String nav_id, HttpServletRequest request, ConsoleContext consoleContext) {
        HttpSession httpSession =  request.getSession();
        httpSession.setAttribute("nav", skinNav.gethtml(nav_id,consoleContext.getLoginUserModel(),request.getContextPath()));
        return "console/skins/skin_2/index";
    }

    @RequestMapping("/console/first/nav")
    public @ResponseBody HttpResult firstNav(String nav_id, HttpServletRequest request, ConsoleContext consoleContext) {
        return HttpResultUtil.buildSuccess(secondSkinTool.getFirstNav(consoleContext.getLoginUserModel(),request.getContextPath()));

        }

    @RequestMapping("/console/second/nav")
    public @ResponseBody HttpResult secondNav(String nav_id, HttpServletRequest request, ConsoleContext consoleContext) {
        return HttpResultUtil.buildSuccess(skinNav.gethtml(nav_id,consoleContext.getLoginUserModel(),request.getContextPath()));

    }
}
