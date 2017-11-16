package zhang.lao.build.auto.build;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import zhang.lao.build.auto.AutoConfig;
import zhang.lao.build.auto.build.service.ControllerBuildService;
import zhang.lao.build.auto.model.ControllerQueryModel;
import zhang.lao.build.auto.model.ControllerQueryToolModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
import zhang.lao.build.auto.utils.BuildTool;
import zhang.lao.build.tool.FileTool;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class ControllerToolBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        List<ControllerQueryModel> controllerQueryModelList = Lists.newArrayList();
        for (Table table : tables) {
            String tableName = table.getTableName();
            ControllerQueryModel controllerQueryModel = new ControllerQueryModel();
            controllerQueryModel.setBasePackage(AutoConfig.basePage);
            controllerQueryModel.setTableCaseName(BuildNameTool.getCaseName(tableName));
            controllerQueryModel.setTableName(BuildNameTool.getName(tableName));
            controllerQueryModel.setWhere(ControllerBuildService.getCriteria(table));
            controllerQueryModel.setWhereSql(ControllerBuildService.getSql(table));
            controllerQueryModelList.add(controllerQueryModel);
        }
                ControllerQueryToolModel controllerQueryToolModel = new ControllerQueryToolModel();
                controllerQueryToolModel.setBasePackage( AutoConfig.basePage);
                controllerQueryToolModel.setCriterias(controllerQueryModelList);
                String fileSrc2 = src +"ControllerQueryTool.java";
                BuildTool.writeFile(controllerQueryToolModel,fileSrc2,"ControllerQuery.temp",isReplace);
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
