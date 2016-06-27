package auto.build;

import auto.build.tool.BuildTool;
import auto.model.GridModel;
import auto.model.Table;
import auto.model.TableColumn;
import auto.template.BuildTemplate;
import auto.utils.BuildNameTool;
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
            gridModel.setTableQuery("");
            gridModel.setTableTh(getTableTh(table));
            gridModel.setTableQuerySet("");
            Template template = BuildTemplate.getTemplate("ConsoleGrid.temp");
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
                html.append("formObject."+columnName+"=($('#"+tableName + "_form input[name=\"" + columnName + "\"]:checked').val()==''?null:$('#" + tableName + "_form input[name=\"" + columnName + "\"]:checked').val()); \r\n ");
            }else{
                html.append("formObject."+columnName+"=("+tableName+"_form."+columnName+".value==''?null:"+tableName+"_form."+columnName+".value); \r\n ");
            }
        }
        html.append("formObject."+table.getKey()+"=("+tableName+"_form."+table.getKey()+".value==''?null:"+tableName+"_form."+table.getKey()+".value); \r\n ");
        return html.toString();
    }
}
