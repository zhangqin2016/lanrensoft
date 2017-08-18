package zhang.lao.console.init;/**
 * Created by zhangqin on 2017/8/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.SysReqUrlWhiteListMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrl;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteList;
import zhang.lao.build.tool.ToolClassSearcher;
import zhang.lao.dao.base.SysReqUrlDao;
import zhang.lao.dao.base.SysReqUrlWhiteListDao;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;

/**
 * 初始化请求权限
 *
 * @author
 * @create 2017-08-17 17:54
 **/
public class InitReqUrl {

    @Autowired
    private SysReqUrlDao sysReqUrlDao;
    @Autowired
    private SysReqUrlWhiteListDao sysReqUrlWhiteListDao;

    @PostConstruct
    public void initReq(){

        List<Class<?>> modelClasses = new ToolClassSearcher(null).search(null);
        // 循环处理自动注册映射
        for (Class model : modelClasses) {
            if(model.getAnnotation(Controller.class)!=null) {
                Method[] method = model.getMethods();
                for (Method method1 : method) {
                    RequestMapping r =  method1.getAnnotation(RequestMapping.class);
                    if(r!=null){
                        String [] s= r.value();
                        for (String s1 : s) {

                        }
                    }
                }
            }
        }
    }
}
