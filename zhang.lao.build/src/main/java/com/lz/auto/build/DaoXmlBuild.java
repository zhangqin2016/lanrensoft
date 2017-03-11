package com.lz.auto.build;

import com.lz.auto.model.DaoModel;
import com.lz.auto.model.Table;
import com.lz.auto.template.BuildTemplate;
import com.lz.auto.utils.BuildNameTool;
import com.lz.tool.FileTool;
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
