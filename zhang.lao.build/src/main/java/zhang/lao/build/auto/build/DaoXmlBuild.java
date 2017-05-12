package zhang.lao.build.auto.build;

import zhang.lao.build.auto.model.DaoModel;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.auto.utils.BuildNameTool;
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
    public void build(List<Table> tables, String src) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            DaoModel controllerModel = new DaoModel();
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            Template template = BuildTemplate.getTemplate("consoleDaoXml.temp");
            template = BuildTemplate.bind(controllerModel, template);
            try {
                String fileSrc = src + BuildNameTool.getName(tableName) + "Dao.xml";
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
