package zhang.lao.build.auto.build;

import zhang.lao.build.auto.build.service.FormBuildService;
import zhang.lao.build.auto.model.FormModel;
import zhang.lao.build.auto.model.HtmlBuildFieldModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import zhang.lao.build.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/20.
 */
public class FormBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src) {


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
            Template template = BuildTemplate.getTemplate("consoleForm.temp");
            template = BuildTemplate.bind(formModel, template);
            try {
                String fileSrc = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "_form.html";
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


}
