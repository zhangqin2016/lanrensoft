package auto.build;

import auto.build.tool.BuildTool;
import auto.model.ControllerModel;
import auto.model.Table;
import auto.model.TableColumn;
import auto.template.BuildTemplate;
import auto.utils.BuildNameTool;
import auto.utils.GetTable;
import org.beetl.core.Template;

import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public class ControllerBuild implements BuildService {

    @Override
    public String build(List<Table> tables) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setBasePackage("zhang.lao");
            controllerModel.setCaseBeanMapper("modelMapper");
            controllerModel.setBeanName(BuildNameTool.getModelName(tableName));
            controllerModel.setBeanMapper(BuildNameTool.getModelName(tableName) + "Mapper");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setCaseBeanName("model");
            controllerModel.setBaseUrl("/sunarvr/console/"+tableName+"/");
            controllerModel.setCriteria("");
            controllerModel.setIdName(BuildNameTool.getModelName(keyColumn.getColumnName()));
            Template template = BuildTemplate.getTemplate("comsoleComtroller.temp");
            template = BuildTemplate.bind(controllerModel,template);
            System.out.print(template.render());
        }
        return "";
    }
    public static void main(String[] args) {
        new ControllerBuild().build(GetTable.tables());
    }
}
