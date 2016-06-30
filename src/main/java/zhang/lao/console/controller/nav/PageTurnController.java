package zhang.lao.console.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.skin.SkinNav;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/6/30.
 */
@Controller
public class PageTurnController {
    @Resource(name = "secoundSkin")
    private SkinNav nav;
    @RequestMapping("/console/nav/trun/first")
    public String getNavFirstReturn(int nav_id, HttpServletRequest request) {
        HttpSession httpSession =  request.getSession();
        httpSession.setAttribute("nav", nav.gethtml(nav_id,Integer.parseInt(httpSession.getAttribute("user_id").toString()),request.getContextPath()));
        return "console/skins/skin_2/index";
    }
}
