package auto.build;

import auto.build.tool.BuildTool;
import auto.model.GridModel;
import auto.model.Table;
import auto.model.TableColumn;
import auto.template.BuildTemplate;
import auto.utils.BuildNameTool;
import auto.utils.GetTable;
import org.beetl.core.Template;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tech6 on 2016/6/20.
 */
public class GridBuild implements  BuildService{
    @Override
    public String build(List<Table> tables) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            GridModel gridModel = new GridModel();
            gridModel.setBaseUrl("/sunarvr/console/" + tableName + "/");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            gridModel.setTableIdName(BuildNameTool.getModelName(keyColumn.getColumnName()));
            gridModel.setTableName(BuildNameTool.getModelName(tableName));
            gridModel.setTableQuery(getQuery(table));
            gridModel.setTableTh(getTableTh(table));
            gridModel.setTableQuerySet(getQuerySet(table));
            Template template = BuildTemplate.getTemplate("consoleGrid.temp");
            template = BuildTemplate.bind(gridModel,template);
            System.out.print(template.render());
        }
        return "";
    }
    private static String getTableTh(Table table){
        StringBuffer html=new StringBuffer();

        for (TableColumn column : table.getListColumn()) {
            String remarks=column.getRemarks();
            if(remarks.indexOf(BuildTool.RADIO)!=-1){
                int t=remarks.indexOf(BuildTool.RADIO);
                remarks=remarks.substring(0,t);
            }else if(remarks.indexOf(BuildTool.SELECT)!=-1){
                int t=remarks.indexOf(BuildTool.SELECT);
                remarks=remarks.substring(0,t);
            }else if(remarks.indexOf(BuildTool.IMAGE)!=-1){
                remarks=remarks.replace(BuildTool.IMAGE, "");
            }
            if(column.getColumnName().equals(table.getKey())){
                html.append("<th title='"+remarks+"' data-column-id='"+BuildNameTool.getModelName(column.getColumnName())+"' data-identifier='true' data-type='numeric' data-visible='false'>id</th>\r\n ");
            }else{
                html.append("<th title='"+remarks+"' data-column-id='"+BuildNameTool.getModelName(column.getColumnName())+"'>"+remarks+"</th>\r\n ");
            }
        }
        html.append(" <th title='操作' data-column-id='"+BuildNameTool.getModelName(table.getTableName())+"_operation' data-formatter='"+BuildNameTool.getModelName(table.getTableName())+"_operation' data-sortable='false'>操作</th>\r\n ");
        return html.toString();
    }
    public static String  getQuerySet(Table table){
        StringBuffer html=new StringBuffer();
        String tableName =BuildNameTool.getModelName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName=BuildNameTool.getModelName(column.getColumnName());
            if(column.isKey()|| Arrays.asList(BuildTool.noc).contains(column.getColumnName())){
                continue;
            }
            if(column.getRemarks().indexOf(BuildTool.RADIO)!=-1){
                html.append("objQuery."+columnName+"=($('#"+tableName + "_form input[name=\"" + columnName + "\"]:checked').val()==''?null:$('#" + tableName + "_form input[name=\"" + columnName + "\"]:checked').val()); \r\n ");
            }else{
                html.append("objQuery."+columnName+"=("+tableName+"_form."+columnName+".value==''?null:"+tableName+"_form."+columnName+".value); \r\n ");
            }
        }
        html.append("objQuery."+table.getKey()+"=("+tableName+"_form."+table.getKey()+".value==''?null:"+tableName+"_form."+table.getKey()+".value); \r\n ");
        return html.toString();
    }

    public static String getDianDianDian(String src){
        src=src==null?"":src;
        if(src.length()<5){
            return src;
        }else{
            src=src.substring(0, 4)+"...";
        }
        return src;
    }
    private static String getQuery(Table table){
        String	table_name=BuildNameTool.getModelName(table.getTableName());
        StringBuffer html=new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String	columnName=BuildNameTool.getModelName(column.getColumnName());
            if(column.isKey()|| Arrays.asList(BuildTool.noc).contains(column.getColumnName())){
                continue;
            }
            String columnTilte=column.getRemarks();
            html.append("<div class='form-group col-md-3' style='margin-top: 10px;'>\r\n ");
            if(columnTilte.indexOf(BuildTool.RADIO)!=-1||columnTilte.indexOf(BuildTool.SELECT)!=-1){
                int t=columnTilte.indexOf(BuildTool.RADIO);
                int length=t==-1?BuildTool.SELECT.length():BuildTool.RADIO.length();
                t=t==-1?columnTilte.indexOf(BuildTool.SELECT):t;
                String showLabel=columnTilte.substring(0,t);
                String showValue=columnTilte.substring(t+length, columnTilte.length());
                String[] str=showValue.split("\\|");
                html.append("<label title='"+showLabel+"'  for='"+column.getColumnName()+"'>"+getDianDianDian(showLabel)+"：</label>\r\n ");
                html.append("<select class=\"form-control\" id=\""+columnName+"\" name=\""+table_name+"."+columnName+"\">\r\n ");
                html.append("<option  value=\"\">请选择...</option>\r\n ");
                for (String string :str) {
                    String[] str2=string.split(":");
                    html.append("	<option  value=\""+str2[0]+"\">"+str2[1]+"</option>\r\n ");
                }
                html.append("</select>\r\n ");
            }
            else{
                String focus="";
                html.append("<label title='"+column.getRemarks()+"'   for='"+column.getColumnName()+"'>"+getDianDianDian(column.getRemarks())+"：</label>\r\n ");
                if(column.getTypeName().equals("datetime")){
                    focus="onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input "+focus+" onkeyup='enterToQuery(event);' type='text' class='form-control' id='"+column.getColumnName()+"' name='"+column.getColumnName()+"' placeholder=''>\r\n ");
            }
            html.append("</div>\r\n ");
        }
        return html.toString();
    }
    public static void main(String[] args) {
        new GridBuild().build(GetTable.tables());
    }
}
