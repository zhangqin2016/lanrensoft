package com.lz.auto.build;

import com.lz.auto.AutoConfig;
import com.lz.auto.build.service.ControllerBuildService;
import com.lz.auto.build.tool.BuildTool;
import com.lz.auto.model.ControllerModel;
import com.lz.auto.model.Table;
import com.lz.auto.model.TableColumn;
import com.lz.auto.template.BuildTemplate;
import com.lz.auto.utils.BuildNameTool;
import com.lz.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public class ControllerBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setBasePackage(AutoConfig.basePage);
            controllerModel.setCaseBeanMapper("modelMapper");
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            controllerModel.setBeanMapper(BuildNameTool.getName(tableName) + "Mapper");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            controllerModel.setBaseUrl("/console/" + tableName + "/");
            controllerModel.setCriteria(ControllerBuildService.getCriteria(table));
            controllerModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            Template template = BuildTemplate.getTemplate("consoleController.temp");
            template = BuildTemplate.bind(controllerModel, template);
            try {
                String fileSrc = src + BuildNameTool.getName(tableName) + "Controller.java";
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
