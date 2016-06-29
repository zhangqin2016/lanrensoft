package auto.build;

import auto.model.Table;
import auto.utils.BuildNameTool;
import zhang.lao.tool.FileTool;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/29.
 */
public class BuildAutoTables implements BuildService{
    @Override
    public void build(List<Table> tables, String src) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Table table : tables) {
            stringBuilder.append("<table modelType=\"flat\" tableName=\""+table.getTableName()+"\" domainObjectName=\""+ BuildNameTool.getName(table.getTableName())+"\" enableCountByExample=\"true\" enableUpdateByExample=\"true\" enableDeleteByExample=\"true\" enableSelectByExample=\"true\" selectByExampleQueryId=\"true\"></table> \r\n");
        }
        try {
            String fileSrc=src+"database_tables.xml";
            File f=new File(fileSrc);
            if (!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            f.createNewFile();
            FileTool.write(fileSrc, stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
