package auto.build;

import auto.build.tool.BuildTool;
import auto.model.ControllerModel;
import auto.model.Table;
import auto.model.TableColumn;
import auto.template.BuildTemplate;
import auto.utils.BuildNameTool;
import org.beetl.core.Template;
import zhang.lao.tool.FileTool;

import java.io.File;
import java.io.IOException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public class ControllerBuild implements BuildService {

    @Override
    public void build(List<Table> tables, String src) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setBasePackage("zhang.lao");
            controllerModel.setCaseBeanMapper("modelMapper");
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            controllerModel.setBeanMapper(BuildNameTool.getName(tableName) + "Mapper");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            controllerModel.setBaseUrl("/console/" + tableName + "/");
            controllerModel.setCriteria(getCriteria(table));
            controllerModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            Template template = BuildTemplate.getTemplate("comsoleComtroller.temp");
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

    private String getCriteria(Table table) {
        StringBuffer java = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName = BuildNameTool.getName(column.getColumnName());
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(column.getColumnName())) {
                continue;
            }
            if (column.getType() == Types.BLOB || column.getType() == Types.CLOB) {
                continue;
            }
            java.append("       if(" + tableCaseName + ".get" + columnName + "()!=null){\r\n");
            java.append("           criteria.and" + columnName + "EqualTo(" + tableCaseName + ".get" + columnName + "());\r\n");
            java.append("          }\r\n");
        }
        return java.toString();
    }
}
