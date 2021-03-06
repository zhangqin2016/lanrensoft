package zhang.lao.build.mybatis.generator.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.generator.jdbc.WeJdbcTemplate;
import zhang.lao.build.mybatis.generator.model.Table;
import zhang.lao.build.mybatis.generator.util.template.MyBatisGeneratorBuildTemplate;
import zhang.lao.build.tool.FileTool;
import zhang.lao.build.tool.PathKit;
import org.beetl.core.Template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GeneratorConfigXml {
    public static String generate() {
        Prop cfgMap = PropKit.use("mybatis-generator" + File.separator + "cfg.properties");
        Prop jdbcMap = PropKit.use("sys.properties");
        cfgMap.AddProp(jdbcMap);
        FilesPath filesPath = new FilesPath();
        String targetProject = filesPath.getProjectPath().replace("\\", "/");
        List<Table> tableList = Lists.newArrayList();
        String table_schema = cfgMap.get("jdbc.database");
        List<Map<String, Object>> tableNameList = WeJdbcTemplate.getAllTableFromDb(table_schema);
        for (Map<String, Object> map : tableNameList) {
            tableList.add(new Table(map.get("table_name").toString()));
        }
        String localDriveDir =  PathKit.getRootClassPath() + File.separator +"mybatis-generator"+File.separator+cfgMap.get("jdbc.type");
        String localDrivePath = localDriveDir + File.separator + new File(localDriveDir).listFiles()[0].getName();

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("location", localDrivePath);
        dataMap.put("driverClass", cfgMap.get("jdbc.driver"));
        dataMap.put("connectionUrl", cfgMap.get("jdbc.url").replace("&","&amp;"));
        dataMap.put("userId", cfgMap.get("jdbc.username"));
        dataMap.put("password", cfgMap.get("jdbc.password"));
        dataMap.put("modelTargetPackage", cfgMap.get("modelPoPath"));
        dataMap.put("sqlMapTargetPackage", cfgMap.get("mapperPath"));
        dataMap.put("javaClientTargetPackage", cfgMap.get("daoImplPath"));
        dataMap.put("targetProject", targetProject);
        dataMap.put("tablesList", tableList);

        String generatorConfigPath = "generatorConfig.xml";
//        String generatorConfigPath=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + File.separator + "generatorConfig.xml";
        String outPath =  PathKit.getRootClassPath() + File.separator + generatorConfigPath;
        try {
            Template template = MyBatisGeneratorBuildTemplate.getTemplate("generatorConfigTemplate.temp");
            template.binding(dataMap);
            FileTool.write(outPath, template.render());
            System.out.println("generatorConfig.xml 文件生成完毕");
            return outPath.replace(File.separatorChar, '/');
        } catch (IOException e) {
            System.out.println("generatorConfig.xml 文件生成失败");
            e.printStackTrace();
            return outPath.replace(File.separatorChar, '/');
        }
    }
}
