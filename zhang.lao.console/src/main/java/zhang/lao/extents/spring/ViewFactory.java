package zhang.lao.extents.spring;

import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.handle.DomainJsonView;

/**
 * Created by zhangqin on 2017/4/6.
 */
public class ViewFactory {

    public static ModelAndView buildApiJsonpView(Object o,String crossDomain){
        DomainJsonView apiJsonpView = new DomainJsonView();
        apiJsonpView.setDomain(crossDomain);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(apiJsonpView);
        modelAndView.addObject(o);
        return  modelAndView;
    }
    public static ModelAndView buildApiJsonpView(Object o){
        DomainJsonView apiJsonpView = new DomainJsonView();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(apiJsonpView);
        modelAndView.addObject(o);
        return  modelAndView;
    }
}
