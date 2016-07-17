package zhang.lao.mybatis.generator.util;



import org.beetl.core.Template;
import zhang.lao.mybatis.generator.jdbc.WeJdbcTemplate;
import zhang.lao.mybatis.generator.model.Table;
import zhang.lao.mybatis.generator.util.template.MyBatisGeneratorBuildTemplate;
import zhang.lao.tool.FileTool;
import zhang.lao.tool.PathKit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratorConfigXml {
    public static String generate() {
        Map<String, String> cfgMap = PropertiesUtil.readProperties("mybatis-generator"+File.separator+"cfg.properties");
        FilesPath filesPath = new FilesPath();
        String targetProject = filesPath.getProjectPath().replace("\\", "/");
        List<Table> tableList = new ArrayList<>();
        String table_schema = cfgMap.get("jdbc.url").substring(cfgMap.get("jdbc.url").lastIndexOf("/") + 1, cfgMap.get("jdbc.url").length());
        List<Map<String, Object>> tableNameList = WeJdbcTemplate.getAllTableFromDb(table_schema);
        for (Map<String, Object> map : tableNameList) {
            tableList.add(new Table(map.get("table_name").toString()));
        }
        String localDriveDir =  PathKit.getRootClassPath() + File.separator +"mybatis-generator"+File.separator+"mysql";
        String localDrivePath = localDriveDir + File.separator + new File(localDriveDir).listFiles()[0].getName();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("location", localDrivePath);
        dataMap.put("driverClass", cfgMap.get("jdbc.driverClassName"));
        dataMap.put("connectionUrl", cfgMap.get("jdbc.url"));
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
