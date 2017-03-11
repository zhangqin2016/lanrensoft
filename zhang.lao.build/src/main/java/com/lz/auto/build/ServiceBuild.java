package com.lz.auto.build;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lz.auto.AutoConfig;
import com.lz.auto.build.service.ControllerBuildService;
import com.lz.auto.build.tool.BuildTool;
import com.lz.auto.model.*;
import com.lz.auto.template.BuildTemplate;
import com.lz.auto.utils.BuildNameTool;
import com.lz.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ServiceBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src) {


        for (Table table : tables) {

            String tableName = table.getTableName();
            ServiceModel serviceModel = new ServiceModel();
            serviceModel.setBasePackage(AutoConfig.basePage);
            serviceModel.setCaseBeanDao(BuildNameTool.getCaseName(tableName)+"Dao");
            serviceModel.setBeanName(BuildNameTool.getName(tableName));
            serviceModel.setBeanDao(BuildNameTool.getName(tableName) + "Dao");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            serviceModel.setIdType(keyColumn.getJavaTypeName());
            serviceModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            serviceModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            serviceModel.setBaseUrl("/console/" + tableName + "/");
            Template template = BuildTemplate.getTemplate("consoleService.temp");
            template = BuildTemplate.bind(serviceModel, template);
            try {
                String fileSrc = src + BuildNameTool.getName(tableName) + "Service.java";
                File f = new File(fileSrc);
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                f.createNewFile();
                FileTool.write(fileSrc, template.render());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
