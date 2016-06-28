package auto.build;

import auto.build.tool.BuildTool;
import auto.model.FormModel;
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
public class FormBuild implements  BuildService{
    @Override
    public String build(List<Table> tables) {


        for (Table table : tables) {
            String tableName = table.getTableName();
            FormModel formModel = new FormModel();
            formModel.setBaseUrl("/sunarvr/console/" + tableName + "/");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            formModel.setTableName(BuildNameTool.getModelName(tableName));
            formModel.setFormObjectSet(getFormObjectSet(table));
            formModel.setFormField(getFormField(table));
            Template template = BuildTemplate.getTemplate("consoleForm.temp");
            template = BuildTemplate.bind(formModel,template);
            System.out.print(template.render());
        }
        return "";
    }

    private String getFormObjectSet(Table table){
        StringBuffer html=new StringBuffer();
        String tableName= BuildNameTool.getModelName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName=BuildNameTool.getModelName(column.getColumnName());

            if(column.isKey()||Arrays.asList(BuildTool.noc).contains(columnName)){
                continue;
            }
            if(column.getRemarks().indexOf(BuildTool.RADIO)!=-1){
                html.append("formObject."+columnName+"=($('#"+tableName+"_form input[name=\""+columnName+"\"]:checked').val()==''?null:$('#"+tableName+"_form input[name=\""+columnName+"\"]:checked').val()); \r\n ");
            }else{
                html.append("formObject."+columnName+"=("+tableName+"_form."+columnName+".value==''?null:"+tableName+"_form."+columnName+".value); \r\n ");
            }
        }
        html.append("formObject."+table.getKey()+"=("+tableName+"_form."+table.getKey()+".value==''?null:"+tableName+"_form."+table.getKey()+".value); \r\n ");
        return html.toString();
    }

    private String getFormField(Table table){

        String table_name=BuildNameTool.getModelName(table.getTableName());
        String case_table_name="model";
        StringBuffer html=new StringBuffer();
        StringBuffer htmlText=new StringBuffer();
        StringBuffer htmlImg=new StringBuffer();

        for (TableColumn column : table.getListColumn()) {
            String fieldName = column.getColumnName();
            String columnName=BuildNameTool.getModelName(column.getColumnName());
            String columnTilte=column.getRemarks();
            String typeName=column.getTypeName();
            if(column.isKey()|| Arrays.asList(BuildTool.noc).contains(fieldName)){
                continue;
            }
            if(columnTilte.indexOf(BuildTool.IMAGE)!=-1){
                htmlImg.append("<div class=\"form-group\" >\r\n ");
                htmlImg.append("<label class=\"col-sm-2 control-label\">"+columnTilte.replace(BuildTool.IMAGE, "")+"</label>\r\n ");
                htmlImg.append("<div class=\"col-sm-3\">\r\n ");
                htmlImg.append("<input type=\"file\"id=\""+columnName+"_file\" class=\"form-control\" value='${"+case_table_name+"."+columnName+"!}' >\r\n ");
                htmlImg.append("<input type=\"hidden\" id=\""+columnName+"\"  name=\""+columnName+"\"class=\"form-control\" value='${"+case_table_name+"."+columnName+"!}' > \r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("  	<div class=\"col-sm-4\">\r\n ");
                htmlImg.append("  	<img id=\""+columnName+"_file_show\" src=\"${"+case_table_name+"."+columnName+"!}\" style=\"width:100px;\" alt=\"图片\" class=\"img-rounded\">  \r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("  <script type=\"text/javascript\"> \r\n ");
                htmlImg.append("$(function($){  \r\n ");
                htmlImg.append(" consoleUpload('"+columnName+"','${ctxPath}');\r\n ");
                htmlImg.append("});\r\n ");
                htmlImg.append("</script> \r\n ");
            }else 	if(columnTilte.indexOf(BuildTool.FILE)!=-1){
                htmlImg.append("<div class=\"form-group\" >\r\n ");
                htmlImg.append("<label class=\"col-sm-2 control-label\">"+columnTilte.replace(BuildTool.FILE, "")+"</label>\r\n ");
                htmlImg.append("<div class=\"col-sm-3\">\r\n ");
                htmlImg.append("<input type=\"file\"id=\""+columnName+"_file\" class=\"form-control\" value='${"+case_table_name+"."+columnName+"!}' >\r\n ");
                htmlImg.append("<input type=\"hidden\" id=\""+columnName+"\"  name=\""+columnName+"\"class=\"form-control\" value='${"+case_table_name+"."+columnName+"!}' > \r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("  	<div class=\"col-sm-4\">\r\n ");
                htmlImg.append("  	<a id=\""+columnName+"_file_show\" href=\"${"+case_table_name+"."+columnName+"!}\" style=\"width:100px;\" >${"+case_table_name+"."+columnName+"!} </a> \r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("</div>\r\n ");
                htmlImg.append("  <script type=\"text/javascript\"> \r\n ");
                htmlImg.append("$(document).ready(function()  \r\n ");
                htmlImg.append("{ consoleUpload('"+columnName+"','${ctxPath}');\r\n ");
                htmlImg.append("});\r\n ");
                htmlImg.append("</script> \r\n ");
            }else
            if(typeName.equals("text")){
                htmlText.append("<div class=\"form-group\" >\r\n ");
                htmlText.append("<label class=\"col-sm-2 control-label\">"+columnTilte+"</label>\r\n ");
                htmlText.append("<div class=\"col-sm-8\">\r\n ");
                htmlText.append("<textarea name=\""+columnName+"\" id=\""+columnName+"\" style=\"width: 100%\">${"+case_table_name+"."+columnName+"!}</textarea>\r\n ");
                htmlText.append("<script type=\"text/javascript\">\r\n ");
                htmlText.append(" KindEditor.ready(function(K) {\r\n ");
                htmlText.append("  new common_kind_edit(K).create(\""+columnName+"\");\r\n ");
                htmlText.append("  });\r\n ");
                htmlText.append("</script>\r\n ");
                htmlText.append("</div>\r\n ");
                htmlText.append(" </div>\r\n ");
            }else if(columnTilte.indexOf(BuildTool.RADIO)!=-1){
                StringBuffer htmlRadio=new StringBuffer();
                int t=columnTilte.indexOf(BuildTool.RADIO);
                String showLabel=columnTilte.substring(0,t);
                String showValue=columnTilte.substring(t+BuildTool.RADIO.length(), columnTilte.length());
                htmlRadio.append("<div class=\"form-group\" >\r\n ");
                htmlRadio.append("<label class=\"col-sm-2 control-label\">"+showLabel+"</label>\r\n ");
                htmlRadio.append("<div class=\"col-sm-6\">\r\n ");
                //	String checkedType="check-type=\"required\"";
                String[] str=showValue.split("\\|");
                String autoName= table_name+"_"+columnName;
                String value="";
                for (String string :str) {
                    String[] str2=string.split(":");
                    if(value.equals("")){
                        value=str2[0];
                    }
                    String checked="";
                    if(value.equals(str2[0])){
                        checked="checked='checked'";
                    }
                    htmlRadio.append("<label><input "+checked+" auto_name='"+autoName+"' type=\"radio\"  name=\""+columnName+"\" value=\""+str2[0]+"\"/>"+str2[1]+"</label>\r\n ");
                }
                htmlRadio.append(" \r\n ");
                htmlRadio.append("</div>\r\n ");
                htmlRadio.append(" </div>\r\n ");
                htmlRadio.append("	<script type=\"text/javascript\">\r\n ");
                htmlRadio.append("$(function($){\r\n ");
                htmlRadio.append("$('input[auto_name=\""+autoName+"\"]').each(function(){\r\n ");
                htmlRadio.append("if('${"+case_table_name+"."+columnName+"!}'==this.value){ \r\n ");
                htmlRadio.append("    $(this).attr('checked','checked');\r\n ");
                htmlRadio.append(" }\r\n ");
                htmlRadio.append("});\r\n ");
                htmlRadio.append("	});\r\n ");
                htmlRadio.append("	</script> \r\n ");
                html.append(htmlRadio);
            }else if(columnTilte.indexOf(BuildTool.SELECT)!=-1){
                StringBuffer htmlSelect=new StringBuffer();
                int t=columnTilte.indexOf(BuildTool.SELECT);
                String showLabel=columnTilte.substring(0,t);
                String showValue=columnTilte.substring(t+BuildTool.SELECT.length(), columnTilte.length());
                htmlSelect.append("<div class=\"form-group\">\r\n ");
                htmlSelect.append("<label for=\"cemail\" class=\"control-label col-sm-2\">"+showLabel+"</label>\r\n ");
                htmlSelect.append("<div class=\"col-sm-6\">\r\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\""+columnName+"\"\r\n ");
                htmlSelect.append("		name=\""+columnName+"\" check-type=\"required\">\r\n ");
                String[] str=showValue.split("\\|");
                String value="";
                for (String string :str) {
                    String[] str2=string.split(":");
                    if(value.equals("")){
                        value=str2[0];
                    }
                    String selected="";
                    if(value.equals(str2[0])){
                        selected="selected='selected'";
                    }
                    htmlSelect.append("	<option "+selected+" value=\""+str2[0]+"\">"+str2[1]+"</option>\r\n ");
                }
                htmlSelect.append("</select>\r\n ");
                htmlSelect.append("</div>\r\n ");
                htmlSelect.append("</div>\r\n ");
                htmlSelect.append("	<script type=\"text/javascript\">\r\n ");
                htmlSelect.append("  $(function($) {\r\n ");
                htmlSelect.append("	$(\"#"+columnName+"\").val(\"${"+case_table_name+"."+columnName+"!}\");\r\n ");
                htmlSelect.append("	if('${"+case_table_name+"."+columnName+"!}'==''){\r\n ");
                htmlSelect.append("	    $(\"#"+columnName+"\").val('"+value+"');\r\n ");
                htmlSelect.append("	}\r\n ");
                htmlSelect.append("   });\r\n ");
                htmlSelect.append("	</script>\r\n ");
                html.append(htmlSelect);
            }else
            {
                html.append("<div class=\"form-group\" >\r\n ");
                html.append("<label class=\"col-sm-2 control-label\">"+columnTilte+"</label>\r\n ");
                html.append("<div class=\"col-sm-6\">\r\n ");
                String checkedType="check-type=\"required\"";
                if(column.getTypeName().equals("int")||column.getTypeName().equals("decimal")||column.getTypeName().equals("smallint")){
                    checkedType="check-type=\"required number\"";
                }
                String focus="";
                if(column.getTypeName().equals("datetime")){
                    focus="onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input  type=\"text\" "+focus+" name=\""+columnName+"\" id=\""+columnName+"\" class=\"form-control\" "+checkedType+" value='${"+case_table_name+"."+columnName+"!}' >\r\n ");
                html.append("</div>\r\n ");
                html.append(" </div>\r\n ");
            }
        }
        return html.append(htmlText).append(htmlImg).toString();
    }
    public static void main(String[] args) {
        new FormBuild().build(GetTable.tables());
    }
}
