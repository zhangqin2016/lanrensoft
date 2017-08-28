package zhang.lao.build.auto.utils;

import org.beetl.core.Template;
import zhang.lao.build.auto.model.BaseBuildModel;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.auto.template.BuildTemplate;
import zhang.lao.build.tool.FileTool;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/27.
 */
public class BuildTool {
    public static String RADIO="_radio_";
    public static String SELECT="_select_";
    public static String IMAGE="_img";
    public static String DIC="_dic";
    public static String DATE="_date";
    public static String FILE="_file";
    public static String HTML="_html";
    public static String[] not={IMAGE,FILE,HTML};
    public static String[] noc={"uuid","create_time","update_time","update_user","create_user","da_id","app_uuid"};
    /**
     * 获取id列
     * @param list
     * @return
     */
    public static TableColumn getIdColumn(List<TableColumn> list){
        for (TableColumn tableColumn : list) {
            if (tableColumn.isKey())
                return  tableColumn;
        }
        return null;
    }

    public static boolean canSetQuery(String title){
        for (String s : not) {
            if(title.indexOf(s)!=-1){
                return  false;
            }
        }
        return true;
    }

     public static void writeFile(BaseBuildModel formModel, String fileSrc, String templateName, boolean isReplace){
        Template template = BuildTemplate.getTemplate(templateName);
        template = BuildTemplate.bind(formModel, template);
        try {
            File f = new File(fileSrc);
            if(isReplace==true||(!f.exists()&&isReplace==false)) {
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                f.createNewFile();
                FileTool.write(fileSrc, template.render());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
