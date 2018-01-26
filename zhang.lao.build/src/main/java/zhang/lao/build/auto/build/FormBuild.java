package zhang.lao.build.auto.build;

import zhang.lao.build.auto.build.service.FormBuildService;
import zhang.lao.build.auto.model.BaseBuildModel;
import zhang.lao.build.auto.model.FormModel;
import zhang.lao.build.auto.model.HtmlBuildFieldModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/20.
 */
public class FormBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {


        for (Table table : tables) {
            String tableName = table.getTableName();
            FormModel formModel = new FormModel();
            formModel.setTableTitle(table.getTableTitle());
            formModel.setBaseUrl("/console/" + tableName + "/");
            formModel.setTableName(BuildNameTool.getCaseName(tableName));
            formModel.setFormObjectSet(FormBuildService.getFormObjectSet(table));
            HtmlBuildFieldModel formField = FormBuildService.getFormField(table);
            formModel.setFormFieldJs(formField.getJs());
            formModel.setFormField(formField.getHtml());
            formModel.setFormCommonField(FormBuildService.getFormCommonField(table));
            String fileSrc = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "_form.html";
            String fileSrc2 = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "Form.js";

            BuildTool.writeFile(formModel,fileSrc,"consoleForm.temp",isReplace);
           // BuildTool.writeFile(formModel,fileSrc2,"consoleFormJs.temp",isReplace);
        }
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }


    public static void main(String[] args) {
        String s = "河北省，山西省，辽宁省，吉林省，黑龙江省，江苏省，浙江省，安徽省，福建省，江西，山东省，河南省，湖北省，湖南省，广东省，海南省，四川省，贵州省，云南省，陕西省，甘肃省，青海省，台湾省，内蒙古自治区，广西壮族自治区，西藏自治区，宁夏回族自治区，新疆维吾尔自治区，香港特别行政区，澳门特别行政区";
        for (String s1 : s.split("，")) {
            System.out.println(s1);
        }
    }

}
