package zhang.lao.build.auto.build;

import zhang.lao.build.auto.build.service.GridBuildService;
import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.auto.model.GridModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import zhang.lao.build.kit.LogKit;
import zhang.lao.build.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/20.
 */
public class GridBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            GridModel gridModel = new GridModel();
            gridModel.setBaseUrl("/console/" + tableName + "/");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            gridModel.setTableIdName(BuildNameTool.getCaseName(keyColumn.getColumnName()));
            gridModel.setTableName(BuildNameTool.getCaseName(tableName));
            gridModel.setTableQuery(GridBuildService.getQuery(table));
            gridModel.setTableTh(GridBuildService.getTableTh(table));
            gridModel.setTableQuerySet(GridBuildService.getQuerySet(table));
            gridModel.setTableFormatter(GridBuildService.getTableFormatter(table));
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
                LogKit.error(e.getMessage(),e);
            }
        }
    }


}
