package zhang.lao.build.auto.build.service;

import com.google.common.collect.Lists;
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
 * Created by tech6 on 2016/7/21.
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

    public static String getFormField(Table table) {

        String case_table_name = BuildNameTool.getCaseName(table.getTableName());
        StringBuffer html = new StringBuffer();
        StringBuffer htmlText = new StringBuffer();
        StringBuffer htmlImg = new StringBuffer();
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
                htmlRadio.append("<label class=\"col-sm-2 control-label\">" + showLabel + "</label>\r\n ");
                htmlRadio.append("<div class=\"col-sm-6\">\r\n ");
                //	String checkedType="check-type=\"required\"";
                String[] str = showValue.split("\\|");
                String autoName = case_table_name + "_" + columnCaseName;
                String value = "";
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
                htmlRadio.append(" </div>\r\n ");
                htmlRadio.append("	<script type=\"text/javascript\">\r\n ");
                htmlRadio.append("      $(function($){\r\n ");
                htmlRadio.append("      $('input[auto_name=\"" + autoName + "\"]').each(function(){\r\n ");
                htmlRadio.append("      if('${" + case_table_name + "." + columnCaseName + "!}'==this.value){ \r\n ");
                htmlRadio.append("            $(this).attr('checked','checked');\r\n ");
                htmlRadio.append("           }\r\n ");
                htmlRadio.append("          });\r\n ");
                htmlRadio.append("	    });\r\n ");
                htmlRadio.append("	</script> \r\n ");
                html.append(htmlRadio);
            } else if (columnTilte.indexOf(BuildTool.SELECT) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(BuildTool.SELECT);
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + BuildTool.SELECT.length(), columnTilte.length());
                htmlSelect.append("<div class=\"form-group\">\r\n ");
                htmlSelect.append("<label class=\"control-label col-sm-2\">" + showLabel + "</label>\r\n ");
                htmlSelect.append("<div class=\"col-sm-6\">\r\n ");
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
                htmlSelect.append("	<script type=\"text/javascript\">\r\n ");
                htmlSelect.append("  $(function($) {\r\n ");
                htmlSelect.append("	$(\"#" + columnCaseName + "\").val(\"${" + case_table_name + "." + columnCaseName + "!}\");\r\n ");
                htmlSelect.append("	if('${" + case_table_name + "." + columnCaseName + "!}'==''){\r\n ");
                htmlSelect.append("	    $(\"#" + columnCaseName + "\").val('" + value + "');\r\n ");
                htmlSelect.append("	}\r\n ");
                htmlSelect.append("   });\r\n ");
                htmlSelect.append("	</script>\r\n ");
                html.append(htmlSelect);
            } else {
                html.append("<div class=\"form-group\" >\r\n ");
                html.append("<label class=\"col-sm-2 control-label\">" + columnTilte + "</label>\r\n ");
                html.append("<div class=\"col-sm-6\">\r\n ");
                String checkedType = "check-type=\"required\"";
                if (column.getTypeName().equals("int") || column.getTypeName().equals("decimal") || column.getTypeName().equals("smallint")) {
                    checkedType = "check-type=\"required number\"";
                }
                String focus = "";
                if (column.getTypeName().equals("Date")) {
                    focus = "onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input  type=\"text\" " + focus + " name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + checkedType + " value='${" + case_table_name + "." + columnCaseName + "!}' >\r\n ");
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
            } else if (columnTilte.indexOf(BuildTool.FILE) != -1) {
                FormImageModel formImageModel = new FormImageModel();
                formImageModel.setCoulumnCaseName(columnCaseName);
                formImageModel.setCoulumnTitle(columnTilte.replace(BuildTool.IMAGE, ""));
                formImageModel.setFormValue("${" + case_table_name + "." + columnCaseName + "!}");
                Template template = BuildTemplate.getTemplate("consoleFormFile.temp");
                template = BuildTemplate.bind(formImageModel, template);
                html.append(template.render());
            }
        }
        return html.append(htmlText).append(htmlImg).toString();
    }
}
