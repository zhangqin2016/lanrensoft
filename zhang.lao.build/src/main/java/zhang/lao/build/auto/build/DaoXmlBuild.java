package zhang.lao.build.auto.build;

import zhang.lao.build.auto.model.DaoModel;
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
 * Created by Administrator on 2017/3/11.
 */
public class DaoXmlBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            DaoModel controllerModel = new DaoModel();
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
                String fileSrc = src + BuildNameTool.getName(tableName) + "Dao.xml";
            BuildTool.writeFile(controllerModel,fileSrc,"consoleDaoXml.temp",isReplace);
        }
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
