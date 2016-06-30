package zhang.lao.console.service;

import org.springframework.stereotype.Service;
import zhang.lao.pojo.upload.UploadResp;
import zhang.lao.tool.FileTool;
import zhang.lao.tool.PathKit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tech6 on 2016/6/30.
 */

@Service
public class UploadService {

    public UploadResp uploadLocal(InputStream inputStream,String path,String fileName) throws IOException {
        UploadResp uploadResp = new UploadResp();
        String ext = FileTool.getExtention(fileName);
        String filePath = PathKit.getWebRootPath()+path+File.separator+fileName;
        File f = new File(filePath);
        if(!f.exists()){
            f.getParentFile().mkdirs();
        }
        f.createNewFile();
        FileTool.write(filePath,inputStream);
        uploadResp.setFileType(ext);
        uploadResp.setLocal(true);
        uploadResp.setNewName(fileName);
        uploadResp.setServerFilePath(path);
        File file = new File(filePath);
        uploadResp.setSize(file.length());
        uploadResp.setUrl(path+File.separator+fileName);
        return uploadResp;
    }
}
