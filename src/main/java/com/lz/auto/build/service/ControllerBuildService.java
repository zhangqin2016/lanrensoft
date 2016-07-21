package com.lz.auto.build.service;

import com.lz.auto.build.tool.BuildTool;
import com.lz.auto.model.Table;
import com.lz.auto.model.TableColumn;
import com.lz.auto.utils.BuildNameTool;

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
