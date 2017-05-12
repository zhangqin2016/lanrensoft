package zhang.lao.build.auto.build.service;

import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.utils.BuildNameTool;

import java.util.Arrays;

/**
 * Created by tech6 on 2016/7/21.
 */
public class GridBuildService {

    public static  String getTableFormatter(Table table) {
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            String fmv = BuildNameTool.getCaseName(table.getTableName())+column.getColumnName()+"Formatter";
            if (column.getRemarks().indexOf(BuildTool.IMAGE) != -1) {
                html.append("       function " + fmv + "(value) \r\n");
                html.append("       { \r\n");
                html.append("         return '<a href=\"'+value+'\" target=\"_blank\" > <img style=\"height:50px;\" src=\"'+value+'\" alt=\"缩略图\"> </a>';\r\n");
                html.append("       }\r\n");
            } else if (column.getRemarks().indexOf(BuildTool.SELECT) != -1 || column.getRemarks().indexOf(BuildTool.RADIO) != -1) {
                String columnTilte = column.getRemarks();
                int t = columnTilte.indexOf(BuildTool.RADIO);
                int length = t == -1 ? BuildTool.SELECT.length() : BuildTool.RADIO.length();
                t = t == -1 ? columnTilte.indexOf(BuildTool.SELECT) : t;
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append(" function "+fmv+"(value) \r\n");
                html.append("   { \r\n");
                html.append("       var showValue=''; \r\n");
                html.append("       switch(value+''){\r\n");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    String value = str2[0];
                    String show = str2[1];
                    if (str.length == 2) {
                        show = str2[1];
                    }
                    html.append("       case '" + value + "': \r\n");
                    html.append("       showValue = '" + show + "';\r\n");
                    html.append("       break;\r\n");
                }
                html.append("       }\r\n");
                html.append("    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    \r\n");
                html.append("       return '<span class=\"label label-warning\">'+showValue+'</span>';\r\n");
                html.append("   }else{\r\n");
                html.append("       return '<span class=\"label label-info\">'+showValue+'</span>';\r\n");
                html.append("   }\r\n");
                html.append("   }\r\n");
            }
        }
        return html.toString();
    }

    public static String getTableTh(Table table) {
        StringBuffer html = new StringBuffer();

        for (TableColumn column : table.getListColumn()) {
            String remarks = column.getRemarks();
            if (remarks.indexOf(BuildTool.RADIO) != -1) {
                int t = remarks.indexOf(BuildTool.RADIO);
                remarks = remarks.substring(0, t);
            } else if (remarks.indexOf(BuildTool.SELECT) != -1) {
                int t = remarks.indexOf(BuildTool.SELECT);
                remarks = remarks.substring(0, t);
            } else if (remarks.indexOf(BuildTool.IMAGE) != -1) {
                remarks = remarks.replace(BuildTool.IMAGE, "");
            } else if (remarks.indexOf(BuildTool.FILE) != -1) {
                remarks = remarks.replace(BuildTool.FILE, "");
            }
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.getColumnName().equals(table.getKey())) {
                html.append(" <th data-field='" + columnCaseName + "' data-visible='false'>ID</th>\r\n ");
            } else if (column.getRemarks().indexOf(BuildTool.IMAGE) != -1 || column.getRemarks().indexOf(BuildTool.SELECT) != -1 || column.getRemarks().indexOf(BuildTool.RADIO) != -1) {
                html.append(" <th data-field='" + columnCaseName + "' data-sortable='true' data-formatter='" + BuildNameTool.getCaseName(table.getTableName())+column.getColumnName() + "Formatter'>" + remarks + "</th>\r\n ");
            } else {
                html.append(" <th data-sortable='true' data-field='" + columnCaseName + "'>" + remarks + "</th>\r\n ");
            }
        }
        html.append(" <th data-field='" + BuildNameTool.getCaseName(table.getKey()) + "' data-formatter='" + BuildNameTool.getCaseName(table.getTableName()) + "TableOperate'>操作</th>\r\n ");
        return html.toString();
    }

    public static String getQuerySet(Table table) {
        StringBuffer html = new StringBuffer();
        String tableName = BuildNameTool.getCaseName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(column.getColumnName())) {
                continue;
            }
            if(!BuildTool.canSetQuery(column.getRemarks())){
                continue;
            }
            html.append("    objQuery." + columnCaseName + "=$('#" + columnCaseName + "').val()==''?null:$('#" + columnCaseName + "').val(); \r\n ");
        }
        return html.toString();
    }

    public static String getDianDianDian(String src) {
        src = src == null ? "" : src;
        if (src.length() < 5) {
            return src;
        } else {
            src = src.substring(0, 4) + "...";
        }
        return src;
    }

    public static String getQuery(Table table) {
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(column.getColumnName())) {
                continue;
            }

            String columnTilte = column.getRemarks();
            if(!BuildTool.canSetQuery(columnTilte)){
                continue;
            }
            html.append("<div class='form-group col-md-3' style='margin-top: 10px;'>\r\n ");
            if (columnTilte.indexOf(BuildTool.RADIO) != -1 || columnTilte.indexOf(BuildTool.SELECT) != -1) {
                int t = columnTilte.indexOf(BuildTool.RADIO);
                int length = t == -1 ? BuildTool.SELECT.length() : BuildTool.RADIO.length();
                t = t == -1 ? columnTilte.indexOf(BuildTool.SELECT) : t;
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append("<label title='" + showLabel + "' >" + getDianDianDian(showLabel) + "：</label>\r\n ");
                html.append("<select class=\"form-control\" id=\"" + columnCaseName + "\" name=\""+ columnCaseName + "\">\r\n ");
                html.append("<option  value=\"\">请选择...</option>\r\n ");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if(str2.length==1){
                        html.append("	<option  value=\"" + str2[0] + "\">" + str2[0] + "</option>\r\n ");
                    }else {
                        html.append("	<option  value=\"" + str2[0] + "\">" + str2[1] + "</option>\r\n ");
                    }
                }
                html.append("</select>\r\n ");
            } else {
                String focus = "";
                html.append("<label title='" + column.getRemarks() + "'  >" + getDianDianDian(column.getRemarks()) + "：</label>\r\n ");
                if (column.getTypeName().equals("datetime")) {
                    focus = "onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input " + focus + " onkeyup='"+tableCaseName+"ConsoleGrid.enterToQuery(event);' type='text' class='form-control' id='" + columnCaseName + "' name='" + columnCaseName + "' placeholder=''>\r\n ");
            }
            html.append("</div>\r\n ");
        }
        return html.toString();
    }
}
