package zhang.lao.interceptor;

import com.lz.kit.LogKit;
import com.lz.mybatis.jdbc.auto.dao.SysUserMapper;
import com.lz.mybatis.jdbc.auto.model.SysUser;
import com.lz.tool.des.Des;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.dao.base.SysUserDao;
import zhang.lao.pojo.console.login.LoginReq;
import zhang.lao.pojo.console.login.LoginUserModel;
import zhang.lao.service.console.LoginService;
import zhang.lao.service.console.base.SysUserService;
import zhang.lao.service.console.skin.SecondSkinTool;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tech6 on 2016/6/15.
 */
public class LoginInterceptor  implements HandlerInterceptor {
//private List<String> unCheckedUrl;

    @Resource(name = "loginServiceImp")
    private LoginService loginService;
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SecondSkinTool secondSkinTool;
    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)  {
        try {

            //if(!getUnCheckedUrl().contains(request.getRequestURI())) {
            LoginUserModel user = (LoginUserModel) request.getSession().getAttribute("user");

            if (user != null) {
                return true;
            } else {
                Cookie[] cookie = request.getCookies();
                if (cookie != null) {
                    for (Cookie cookie1 : cookie) {
                        if (cookie1.getName().equals("console_user")) {
                            SysUser sysUser = sysUserDao.selectByPrimaryKey(Integer.parseInt(Des.decodeValue("console_user", cookie1.getValue())));
                            LoginReq loginReq = new LoginReq();
                            loginReq.setPassword(sysUser.getUserPassword());
                            loginReq.setPhone(sysUser.getPhone());
                            request.getSession().setAttribute("user", loginService.getLoginUserModel(loginReq));
                            request.getSession().setAttribute("firstNavHtml", secondSkinTool.getFirstNav(sysUser.getSuId(), request.getContextPath()));
                            return true;
                        }
                    }
                }
                response.sendRedirect("/console/login");
                return false;
            }
        }catch (Exception e){
            LogKit.error(e.getMessage(),e);
            return false;
        }
       // }
       // return true;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

 /*   public List<String> getUnCheckedUrl() {
        return unCheckedUrl;
    }

    public void setUnCheckedUrl(List<String> unCheckedUrl) {
        this.unCheckedUrl = unCheckedUrl;
    }*/
}
