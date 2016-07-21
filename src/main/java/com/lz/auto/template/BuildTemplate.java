package com.lz.auto.template;


import com.lz.auto.model.BaseBuildModel;
import com.lz.auto.model.ControllerModel;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import com.lz.tool.PathKit;

import java.io.File;
import java.io.IOException;

/**
 * Created by tech6 on 2016/6/16.
 */
public class BuildTemplate {

    static {
        String root = PathKit.getRootClassPath() + File.separator + "template";
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

    public static void main(String[] args) {
        ControllerModel controllerModel = new ControllerModel();
        controllerModel.setBasePackage("1");
        controllerModel.setBaseUrl("1");
        controllerModel.setBeanMapper("1");
        controllerModel.setBeanName("q");
        controllerModel.setCaseBeanMapper("1");
        controllerModel.toMap();
        Template t = getTemplate("comsoleComtroller.temp");
        t = bind(controllerModel, t);
        String str = t.render();
        System.out.print(str);
    }


}