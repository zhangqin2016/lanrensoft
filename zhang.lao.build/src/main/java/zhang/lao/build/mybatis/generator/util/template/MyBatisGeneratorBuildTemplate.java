package zhang.lao.build.mybatis.generator.util.template;


import zhang.lao.build.auto.model.BaseBuildModel;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import zhang.lao.build.tool.PathKit;

import java.io.File;
import java.io.IOException;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class MyBatisGeneratorBuildTemplate {

    static {
        String root = PathKit.getRootClassPath() + File.separator + "mybatis-generator";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gt = new GroupTemplate(resourceLoader, cfg);
    }

    private static final GroupTemplate gt;

    public static Template getTemplate(String name) {
        return gt.getTemplate("/" + name);
    }

    public static Template bind(BaseBuildModel t, Template template) {

        template.binding(t.toMap());
        return template;
    }



}
