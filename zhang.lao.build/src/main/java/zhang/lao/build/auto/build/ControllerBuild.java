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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/6/16.
 */
public class ControllerBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src) {
        List<ControllerQueryModel> controllerQueryModelList = Lists.newArrayList();

        for (Table table : tables) {

            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setBasePackage(AutoConfig.basePage);
            controllerModel.setCaseBeanService(BuildNameTool.getCaseName(tableName)+"Service");
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            controllerModel.setBeanService(BuildNameTool.getName(tableName) + "Service");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            controllerModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            controllerModel.setBaseUrl("/console/" + tableName + "/");
            Template template = BuildTemplate.getTemplate("consoleController.temp");
            template = BuildTemplate.bind(controllerModel, template);
            ControllerQueryModel controllerQueryModel = new ControllerQueryModel();
            controllerQueryModel.setBasePackage(AutoConfig.basePage);
            controllerQueryModel.setTableCaseName(BuildNameTool.getCaseName(tableName));
            controllerQueryModel.setTableName(BuildNameTool.getName(tableName));
            controllerQueryModel.setWhere(ControllerBuildService.getCriteria(table));
            controllerQueryModel.setWhereSql(ControllerBuildService.getSql(table));
            controllerQueryModelList.add(controllerQueryModel);
            try {
                String fileSrc = src + BuildNameTool.getName(tableName) + "Controller.java";
                File f = new File(fileSrc);
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                f.createNewFile();
                FileTool.write(fileSrc, template.render());


                Template template2 = BuildTemplate.getTemplate("ControllerQuery.temp");
                Map<String,Object> map  = Maps.newHashMap();
                map.put("criterias",controllerQueryModelList);
                map.put("basePackage", AutoConfig.basePage);
                template2.binding(map);
                String fileSrc2 = src +"ControllerQueryTool.java";
                File f2 = new File(fileSrc2);
                if (!f2.getParentFile().exists()) {
                    f2.getParentFile().mkdirs();
                }
                f2.createNewFile();
                FileTool.write(fileSrc2, template2.render());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
