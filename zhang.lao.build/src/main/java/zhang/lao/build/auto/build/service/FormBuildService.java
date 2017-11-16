package zhang.lao.build.auto.build.service;

import com.google.common.collect.Lists;
import zhang.lao.build.auto.model.HtmlBuildFieldModel;
import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.auto.model.FormImageModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import org.beetl.core.Template;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 张钦 on 2016/7/21.
 */
public class FormBuildService {
    public static String getFormCommonField(Table table) {
        StringBuffer html = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        String key = BuildNameTool.getCaseName(table.getKey());
        html.append("<input type='hidden' name='" + key + "' id='" + key + "' value='${" + tableCaseName + "." + key + "!}'>");
        html.append("<input type='hidden' name='common_token' id='common_token' value='${common_token!}'>");
        return html.toString();
    }

    public static String getFormObjectSet(Table table) {
        StringBuffer html = new StringBuffer();
        String key = BuildNameTool.getCaseName(table.getKey());
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());

            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(column.getColumnName())) {
                continue;
            }
            if(column.getRemarks().indexOf(BuildTool.RADIO)!=-1){
                html.append("formObject."+columnCaseName+"=($('input[name=\""+columnCaseName+"\"]:checked').val()==''?null:$('input[name=\""+columnCaseName+"\"]:checked').val()); \r\n ");
            }else {
                html.append("formObject." + columnCaseName + "=$('#" + columnCaseName + "').val()==''?null:$('#" + columnCaseName + "').val(); \r\n ");
            }
        }
        html.append("formObject." + key + "=$('#" + key+"').val()==''?null:$('#" + key+"').val(); \r\n ");
        return html.toString();
    }

    public static HtmlBuildFieldModel getFormField(Table table) {

        String case_table_name = BuildNameTool.getCaseName(table.getTableName());
        StringBuffer html = new StringBuffer();
        StringBuffer js = new StringBuffer();
        List<TableColumn> imageFileColumns = Lists.newArrayList();
        for (TableColumn column : table.getListColumn()) {
            String fieldName = column.getColumnName();
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            String columnTilte = column.getRemarks();
            if (column.isKey() || Arrays.asList(BuildTool.noc).contains(fieldName)) {
                continue;
            }
            if (columnTilte.indexOf(BuildTool.IMAGE) != -1||columnTilte.indexOf(BuildTool.FILE) != -1) {
                imageFileColumns.add(column);
            }  else if (columnTilte.indexOf(BuildTool.RADIO) != -1) {
                StringBuffer htmlRadio = new StringBuffer();
                int t = columnTilte.indexOf(BuildTool.RADIO);
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + BuildTool.RADIO.length(), columnTilte.length());
                htmlRadio.append("<div class=\"form-group\" >\r\n ");
                htmlRadio.append("<label class=\"col-sm-2 col-xs-2 control-label\">" + showLabel + "</label>\r\n ");
                htmlRadio.append("<div class=\"col-sm-6 col-xs-6\">\r\n ");
                //	String checkedType="check-type=\"required\"";
                String[] str = showValue.split("\\|");
                String autoName = case_table_name + "_" + columnCaseName;
                String value = "";
                htmlRadio.append("<div class=\"radio\">\r\n ");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if (value.equals("")) {
                        value = str2[0];
                    }
                    String checked = "";
                    if (value.equals(str2[0])) {
                        checked = "checked='checked'";
                    }
                    if(str2.length==1) {
                        htmlRadio.append("<label><input " + checked + " auto_name='" + autoName + "' type=\"radio\"  name=\"" + columnCaseName + "\" value=\"" + str2[0] + "\"/>" + str2[0] + "</label>\r\n ");
                    }else{
                        htmlRadio.append("<label><input " + checked + " auto_name='" + autoName + "' type=\"radio\"  name=\"" + columnCaseName + "\" value=\"" + str2[0] + "\"/>" + str2[1] + "</label>\r\n ");

                    }
                    }
                htmlRadio.append(" \r\n ");
                htmlRadio.append("</div>\r\n ");
                htmlRadio.append("</div>\r\n ");
                htmlRadio.append(" </div>\r\n ");
                js.append("      $('input[auto_name=\"" + autoName + "\"]').each(function(){\r\n ");
                js.append("      if('${" + case_table_name + "." + columnCaseName + "!}'==this.value){ \r\n ");
                js.append("            $(this).attr('checked','checked');\r\n ");
                js.append("           }\r\n ");
                js.append("          });\r\n ");
                html.append(htmlRadio);
            } else if (columnTilte.indexOf(BuildTool.SELECT) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(BuildTool.SELECT);
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + BuildTool.SELECT.length(), columnTilte.length());
                htmlSelect.append("<div class=\"form-group\">\r\n ");
                htmlSelect.append("<label class=\"control-label col-sm-2 col-xs-2\">" + showLabel + "</label>\r\n ");
                htmlSelect.append("<div class=\"col-sm-6 col-xs-6\">\r\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\"" + columnCaseName + "\"\r\n ");
                htmlSelect.append("		name=\"" + columnCaseName + "\" check-type=\"required\">\r\n ");
                String[] str = showValue.split("\\|");
                String value = "";
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if (value.equals("")) {
                        value = str2[0];
                    }
                    String selected = "";
                    if (value.equals(str2[0])) {
                        selected = "selected='selected'";
                    }
                    if(str2.length==1){
                        htmlSelect.append("	<option " + selected + " value=\"" + str2[0] + "\">" + str2[0] + "</option>\r\n ");
                    }else {
                        htmlSelect.append("	<option " + selected + " value=\"" + str2[0] + "\">" + str2[1] + "</option>\r\n ");
                    }
                }
                htmlSelect.append("</select>\r\n ");
                htmlSelect.append("</div>\r\n ");
                htmlSelect.append("</div>\r\n ");
                js.append("	$(\"#" + columnCaseName + "\").val(\"${" + case_table_name + "." + columnCaseName + "!}\");\r\n ");
                js.append("	if('${" + case_table_name + "." + columnCaseName + "!}'==''){\r\n ");
                js.append("	    $(\"#" + columnCaseName + "\").val('" + value + "');\r\n ");
                js.append("	}\r\n ");
                html.append(htmlSelect);
            } else if (columnTilte.indexOf(BuildTool.DIC) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(BuildTool.DIC);
                String showLabel = columnTilte.substring(0, t);
                String dicCode = columnTilte.substring(t).replace(BuildTool.DIC,"").replace(" ","");
                htmlSelect.append("<div class=\"form-group\">\r\n ");
                htmlSelect.append("<label class=\"control-label col-sm-2 col-xs-2\">" + showLabel + "</label>\r\n ");
                htmlSelect.append("<div class=\"col-sm-6 col-xs-6\">\r\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\"" + columnCaseName + "\"\r\n ");
                htmlSelect.append("		name=\"" + columnCaseName + "\" check-type=\"required\">\r\n ");
                htmlSelect.append("</select>\r\n ");
                htmlSelect.append("</div>\r\n ");
                htmlSelect.append("</div>\r\n ");
                  js.append("   componentSelectInit(      \r\n ");
                  js.append("           {                        \r\n ");
                  js.append("                   ctxPath:'',       \r\n ");
                   js.append("          tableName:\"sys_dictionary\",        \r\n ");
                   js.append("          showValueField:\"name\",             \r\n ");
                   js.append("          valueField:\"value\",                 \r\n ");
                   js.append("selectId:\"" + columnCaseName + "\"  ,      \r\n ");
                   js.append("          where:\" where code ='"+dicCode+"' \"     \r\n ");
                    js.append("                             }              \r\n ");
                    js.append("                             ,function(){   \r\n ");
                    js.append(" });                         \r\n ");
                html.append(htmlSelect);
            }else if (columnTilte.indexOf(BuildTool.DATE) != -1) {

                html.append("<div class=\"form-group\" >\r\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" +  columnTilte.substring(0,columnTilte.indexOf("_date")) + "</label>\r\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\r\n ");
                String checkedType = "check-type=\"required\"";
                if (column.getTypeName().equals("int") || column.getTypeName().equals("decimal") || column.getTypeName().equals("smallint")) {
                    checkedType = "check-type=\"required number\"";
                }
                String focus = "";
                if (columnTilte.indexOf(BuildTool.DATE)!=-1) {

                    String f =  "YYYY-MM-DD hh:mm:ss";
                    if(columnTilte.indexOf("_format")!=-1){
                        f = columnTilte.substring(columnTilte.indexOf("_format")).replace("_format","");
                    }
                    focus = "onclick=\"layui.laydate({elem: this, istime: true, format: '"+f+"'})\"";
                }
                html.append("<input  type=\"text\" " + focus + " name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + checkedType + " value='${" + case_table_name + "." + columnCaseName + "!}' >\r\n ");
                html.append("</div>\r\n ");
                html.append(" </div>\r\n ");
            } else {
                html.append("<div class=\"form-group\" >\r\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" + columnTilte + "</label>\r\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\r\n ");
                String checkedType = "check-type=\"required\"";
                if (column.getTypeName().equals("int") || column.getTypeName().equals("decimal") || column.getTypeName().equals("smallint")) {
                    checkedType = "check-type=\"required number\"";
                }
                html.append("<input  type=\"text\"  name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + checkedType + " value='${" + case_table_name + "." + columnCaseName + "!}' >\r\n ");
                html.append("</div>\r\n ");
                html.append(" </div>\r\n ");
            }
        }
        for (TableColumn imageFileColumn : imageFileColumns) {
            String columnCaseName = BuildNameTool.getCaseName(imageFileColumn.getColumnName());
            String columnTilte = imageFileColumn.getRemarks();
            if (columnTilte.indexOf(BuildTool.IMAGE) != -1) {
                FormImageModel formImageModel = new FormImageModel();
                formImageModel.setCoulumnCaseName(columnCaseName);
                formImageModel.setCoulumnTitle(columnTilte.replace(BuildTool.IMAGE, ""));
                formImageModel.setFormValue("${" + case_table_name + "." + columnCaseName + "!}");
                Template template = BuildTemplate.getTemplate("consoleFormImage.temp");
                template = BuildTemplate.bind(formImageModel, template);
                html.append(template.render());
                js.append(" consoleUploadImg('"+columnCaseName+"','');");
            } else if (columnTilte.indexOf(BuildTool.FILE) != -1) {
                FormImageModel formImageModel = new FormImageModel();
                formImageModel.setCoulumnCaseName(columnCaseName);
                formImageModel.setCoulumnTitle(columnTilte.replace(BuildTool.IMAGE, ""));
                formImageModel.setFormValue("${" + case_table_name + "." + columnCaseName + "!}");
                Template template = BuildTemplate.getTemplate("consoleFormFile.temp");
                template = BuildTemplate.bind(formImageModel, template);
                html.append(template.render());
                js.append(" consoleUploadFile('"+columnCaseName+"','');");
            }
        }
        return new HtmlBuildFieldModel(js.toString(),html.toString());
    }
}
