package zhang.lao.console.init;/**
 * Created by zhangqin on 2017/8/17.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.SysReqUrlWhiteListMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrl;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroup;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteList;
import zhang.lao.build.tool.ToolClassSearcher;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.dao.base.SysReqUrlDao;
import zhang.lao.dao.base.SysReqUrlGroupDao;
import zhang.lao.dao.base.SysReqUrlWhiteListDao;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

/**
 * 初始化请求权限
 *
 * @author
 * @create 2017-08-17 17:54
 **/
@Component
public class InitReqUrl {

    @Autowired
    private SysReqUrlDao sysReqUrlDao;
    @Autowired
    private SysReqUrlGroupDao sysReqUrlGroupDao;
    @Autowired
    private SysReqUrlWhiteListDao sysReqUrlWhiteListDao;
    private static  final Logger logger = LoggerFactory.getLogger(InitReqUrl.class);
    @PostConstruct
    public void initReq(){
        sysReqUrlGroupDao.deleteByExample(null);
        sysReqUrlDao.deleteByExample(null);

        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>初始化请求授权url<<<<<<<<<<<<<<<<<<<<<<<<<<");
        List<Class<?>> modelClasses = new ToolClassSearcher(null).search(null);
        // 循环处理自动注册映射
        for (Class model : modelClasses) {
            if(model.getAnnotation(Controller.class)!=null||model.getAnnotation(RestController.class)!=null) {
                Method[] method = model.getMethods();
                String classPath= model.getPackage().getName()+"."+model.getName();
                SysReqUrlGroup sysReqUrlGroup = new SysReqUrlGroup();
                sysReqUrlGroup.setDescription(classPath);
                sysReqUrlGroup.setName(classPath);
                sysReqUrlGroup.setId(UUIDTool.getUUID());
                sysReqUrlGroupDao.insertSelective(sysReqUrlGroup);
                for (Method method1 : method) {
                    RequestMapping r =  method1.getAnnotation(RequestMapping.class);
                    if(r!=null){
                        String [] s= r.value();
                        for (String s1 : s) {
                            SysReqUrl sysReqUrl = new SysReqUrl();
                            sysReqUrl.setId(UUIDTool.getUUID());
                            sysReqUrl.setDescription("");
                            sysReqUrl.setUrl(s1);
                            sysReqUrl.setGroupId(sysReqUrlGroup.getId());
                            sysReqUrl.setName(method1.getName());
                            sysReqUrlDao.insertSelective(sysReqUrl);
                        }
                    }
                }
            }

        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>初始化请求授权url 完成<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
