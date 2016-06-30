package auto.build;

import auto.build.tool.BuildTool;
import auto.model.GridModel;
import auto.model.Table;
import auto.model.TableColumn;
import auto.template.BuildTemplate;
import auto.utils.BuildNameTool;
import org.beetl.core.Template;
import zhang.lao.tool.FileTool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tech6 on 2016/6/20.
 */
public class GridBuild implements BuildService {
    @Override
    public void build(List<Table> tables, String src) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            GridModel gridModel = new GridModel();
            gridModel.setBaseUrl("/sunarvr/console/" + tableName + "/");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            gridModel.setTableIdName(BuildNameTool.getCaseName(keyColumn.getColumnName()));
            gridModel.setTableName(BuildNameTool.getCaseName(tableName));
            gridModel.setTableQuery(getQuery(table));
            gridModel.setTableTh(getTableTh(table));
            gridModel.setTableQuerySet(getQuerySet(table));
            gridModel.setTableFormatter(getTableFormatter(table));
            Template template = BuildTemplate.getTemplate("consoleGrid.temp");
            template = BuildTemplate.bind(gridModel, template);
            try {
                String fileSrc = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "_table.html";
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

    private String getTableFormatter(Table table) {
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.getRemarks().indexOf(BuildTool.IMAGE) != -1) {
                html.append(", \r\n");
                html.append("\"" + columnCaseName + "\":function(column, row) \r\n");
                html.append("{ \r\n");
                html.append("   return '<a href=\"'+row." + columnCaseName + "+'\" target=\"_blank\"target=\"_blank\" > <img style=\"height:50px;\" src=\"'+row." + columnCaseName + "+'\" alt=\"缩略图\"> </a>';\r\n");
                html.append("}\r\n");
            } else if (column.getRemarks().indexOf(BuildTool.SELECT) != -1 || column.getRemarks().indexOf(BuildTool.RADIO) != -1) {
                String columnTilte = column.getRemarks();
                int t = columnTilte.indexOf(BuildTool.RADIO);
                int length = t == -1 ? BuildTool.SELECT.length() : BuildTool.RADIO.length();
                t = t == -1 ? columnTilte.indexOf(BuildTool.SELECT) : t;
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append(", \r\n");
                html.append("\"" + columnCaseName + "\":function(column, row) \r\n");
                html.append("{ \r\n");
                html.append("var value=row." + columnCaseName + "; \r\n");
                html.append("switch(value){\r\n");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    String value = str2[0];
                    String show = str2[0];
                    if (str.length == 2) {
                        show = str2[1];
                    }
                    html.append("case '" + value + "': \r\n");
                    html.append(" value = '" + show + "';\r\n");
                    html.append(" break;\r\n");
                }
                html.append("   return value;\r\n");
                html.append("}\r\n");
            }
        }
        return html.toString();
    }

    private static String getTableTh(Table table) {
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
            }
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.getColumnName().equals(table.getKey())) {
                html.append("<th title='" + remarks + "' data-column-id='" + columnCaseName + "' data-identifier='true' data-type='numeric' data-visible='false'>id</th>\r\n ");
            } else if (column.getRemarks().indexOf(BuildTool.IMAGE) != -1 || column.getRemarks().indexOf(BuildTool.SELECT) != -1 || column.getRemarks().indexOf(BuildTool.RADIO) != -1) {
                html.append("<th title='" + remarks + "' data-column-id='" + columnCaseName + "' data-formatter='" + columnCaseName + "'>" + remarks + "</th>\r\n ");
            } else {
                html.append("<th title='" + remarks + "' data-column-id='" + columnCaseName + "'>" + remarks + "</th>\r\n ");
            }
        }
        html.append(" <th title='操作' data-column-id='" + BuildNameTool.getCaseName(table.getTableName()) + "_operation' data-formatter='" + BuildNameTool.getCaseName(table.getTableName()) + "_operation' data-sortable='false'>操作</th>\r\n ");
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
            if (column.getRemarks().indexOf(BuildTool.RADIO) != -1) {
                html.append("objQuery." + columnCaseName + "=($('#" + tableName + "_form input[name=\"" + columnCaseName + "\"]:checked').val()==''?null:$('#" + tableName + "_form input[name=\"" + columnCaseName + "\"]:checked').val()); \r\n ");
            } else {
                html.append("objQuery." + columnCaseName + "=(" + tableName + "_form." + columnCaseName + ".value==''?null:" + tableName + "_form." + columnCaseName + ".value); \r\n ");
            }
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

    private static String getQuery(Table table) {
        String table_name = BuildNameTool.getName(table.getTableName());
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(column.getColumnName())) {
                continue;
            }
            String columnTilte = column.getRemarks();
            html.append("<div class='form-group col-md-3' style='margin-top: 10px;'>\r\n ");
            if (columnTilte.indexOf(BuildTool.RADIO) != -1 || columnTilte.indexOf(BuildTool.SELECT) != -1) {
                int t = columnTilte.indexOf(BuildTool.RADIO);
                int length = t == -1 ? BuildTool.SELECT.length() : BuildTool.RADIO.length();
                t = t == -1 ? columnTilte.indexOf(BuildTool.SELECT) : t;
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append("<label title='" + showLabel + "' >" + getDianDianDian(showLabel) + "：</label>\r\n ");
                html.append("<select class=\"form-control\" id=\"" + columnCaseName + "\" name=\"" + table_name + "." + columnCaseName + "\">\r\n ");
                html.append("<option  value=\"\">请选择...</option>\r\n ");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    html.append("	<option  value=\"" + str2[0] + "\">" + str2[1] + "</option>\r\n ");
                }
                html.append("</select>\r\n ");
            } else {
                String focus = "";
                html.append("<label title='" + column.getRemarks() + "'  >" + getDianDianDian(column.getRemarks()) + "：</label>\r\n ");
                if (column.getTypeName().equals("datetime")) {
                    focus = "onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input " + focus + " onkeyup='enterToQuery(event);' type='text' class='form-control' id='" + columnCaseName + "' name='" + columnCaseName + "' placeholder=''>\r\n ");
            }
            html.append("</div>\r\n ");
        }
        return html.toString();
    }

}
