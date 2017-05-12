package zhang.lao.build.tool;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.File;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:打包工具类
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
public class ZipTool {  
  
    private File zipFile;  
  
    public ZipTool(String finalFile) {  
        zipFile = new File(finalFile);  
    }  
    public void compressExe(String srcPathName) {  
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists()){
            throw new RuntimeException(srcPathName + "不存在！");  
        } 
        Project prj = new Project();
        Zip zip = new Zip();
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        FileSet fileSet = new FileSet();
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        //fileSet.setIncludes("**/*.java"); //包括哪些文件或文件夹 eg:zip.setIncludes("*.java");  
        //fileSet.setExcludes(...); //排除哪些文件或文件夹  
        zip.addFileset(fileSet);  
        zip.execute();  
    }
    public static void main(String[] args) {
    	new ZipTool("d:"+File.separator+"2.zip").compressExe("d:"+File.separator+"center");
	}
} 