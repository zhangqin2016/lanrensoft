package zhang.lao.build.auto.build.service;

import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.utils.BuildNameTool;

import java.sql.Types;
import java.util.Arrays;

/**
 * Created by tech6 on 2016/7/21.
 */
public class ControllerBuildService {
    public static String getCriteria(Table table) {
        StringBuffer java = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName = BuildNameTool.getName(column.getColumnName());
            String myBatisColumnName = BuildNameTool.getMyBatisColumnName(column.getColumnName());
            if (!column.isCanQuery()||column.isKey()) {
                continue;
            }
            java.append("       if(" + tableCaseName + ".get" + myBatisColumnName + "()!=null){\r\n");
            java.append("           criteria.and" + columnName + "EqualTo(" + tableCaseName + ".get" + myBatisColumnName + "());\r\n");
            java.append("          }\r\n");
        }
        return java.toString();
    }

    public static String getSql(Table table) {
        StringBuffer java = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        System.out.println(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName = BuildNameTool.getName(column.getColumnName());
            if (!column.isCanQuery()||column.isKey()) {
                continue;
            }
            java.append("       if(" + tableCaseName + ".get" + columnName + "()!=null){\r\n");
            java.append("           sql.append(\" and \").append(alias).append(\"."+column.getColumnName()+"\").append(\" = '\").append(" + tableCaseName + ".get" + columnName + "()).append(\" ' \");\r\n");
            java.append("          }\r\n");
        }
        return java.toString();
    }
}
