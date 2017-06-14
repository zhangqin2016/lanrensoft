package zhang.lao.build.auto.build;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import zhang.lao.build.auto.AutoConfig;
import zhang.lao.build.auto.build.service.ControllerBuildService;
import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.auto.model.ControllerModel;
import zhang.lao.build.auto.model.ControllerQueryModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import zhang.lao.build.tool.FileTool;
import org.beetl.core.Template;
import zhang.lao.build.tool.date.DateStyle;
import zhang.lao.build.tool.date.DateUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/6/16.
 */
public class ControllerBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        List<ControllerQueryModel> controllerQueryModelList = Lists.newArrayList();

        for (Table table : tables) {

            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setDescription(table.getTableTitle());
            controllerModel.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_CN));
            controllerModel.setAuthor("ZhangQin");
            controllerModel.setBasePackage(AutoConfig.basePage);
            controllerModel.setCaseBeanService(BuildNameTool.getCaseName(tableName)+"Service");
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            controllerModel.setBeanService(BuildNameTool.getName(tableName) + "Service");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            controllerModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            controllerModel.setBaseUrl("/console/" + tableName + "/");
            ControllerQueryModel controllerQueryModel = new ControllerQueryModel();
            controllerQueryModel.setBasePackage(AutoConfig.basePage);
            controllerQueryModel.setTableCaseName(BuildNameTool.getCaseName(tableName));
            controllerQueryModel.setTableName(BuildNameTool.getName(tableName));
            controllerQueryModel.setWhere(ControllerBuildService.getCriteria(table));
            controllerQueryModel.setWhereSql(ControllerBuildService.getSql(table));
            controllerQueryModelList.add(controllerQueryModel);
            String fileSrc = src + BuildNameTool.getName(tableName) + "Controller.java";
            BuildTool.writeFile(controllerModel,fileSrc,"consoleController.temp",isReplace);
        }
    }

    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
