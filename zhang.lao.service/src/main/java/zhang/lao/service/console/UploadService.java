package zhang.lao.service.console;

import aliupload.MediaUploadClient;
import com.alibaba.media.upload.UploadResponse;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.SysFileMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.build.tool.FileTool;
import zhang.lao.build.tool.PathKit;
import zhang.lao.build.tool.UUIDTool;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/30.
 */

@Service
public class UploadService {
    private    static final   Map<String,String> map  = Maps.newHashMap();
    static{
        map.put(".png","1");
        map.put(".jpg","1");
        map.put(".bmp","1");
        map.put(".gif","1");
    }

    public boolean isImageType(String type){
        return map.get(type)==null?false:true;
    }
    @Resource
    private SysFileMapper sysFileMapper;

    public SysFile uploadToDb(InputStream inputStream, String path, String fileName) throws IOException {
        String ext = FileTool.getExtention(fileName);
        String filePath = PathKit.getWebRootPath()+path+File.separator+fileName;
        File f = new File(filePath);
        if(!f.exists()){
            f.getParentFile().mkdirs();
        }
        f.createNewFile();
        FileTool.write(filePath,inputStream);
        File file = new File(filePath);
        SysFile sysFile = new SysFile();
        sysFile.setFileSize(Integer.parseInt(file.length()+""));
        sysFile.setFileName(fileName);
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setFileMd5(FileTool.getMd5ByFile(file));
        sysFile.setLocal(1);
        sysFile.setFileUrl((path+File.separator+fileName).replace("\\","/"));
        sysFile.setFileType(ext);
        if(isImageType(ext)){
            BufferedImage bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            sysFile.setFileHeight(height);
            sysFile.setFileWidth(width);
        }
        sysFileMapper.insertSelective(sysFile);
        return sysFile;

    }
    public SysFile uploadToAli(MultipartFile file) throws IOException {
        String filePath = PathKit.getWebRootPath()+File.separator+"temp"+File.separator+System.nanoTime()+file.getOriginalFilename();
        File f = new File(filePath);
        if(!f.exists()){
            f.getParentFile().mkdirs();
        }
        f.createNewFile();
        Path fpath= Paths.get(filePath);
        Files.write(fpath, file.getBytes());
        File fileTemp = new File(filePath);
        String fileName = file.getOriginalFilename();
        String ext = FileTool.getExtention(fileName);
        SysFile sysFile = new SysFile();
        sysFile.setFileSize(Integer.parseInt(file.getSize()+""));
        sysFile.setFileName(fileName);
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        sysFile.setFileMd5(FileTool.getMd5ByFile(fileTemp));
        String ufn = System.nanoTime()+ext;
        UploadResponse uploadResponse = null;
        if(isImageType(ext)){
            uploadResponse = MediaUploadClient.uploadImg(fileTemp,ufn);
        }else {
            uploadResponse = MediaUploadClient.uploadFile(fileTemp,ufn);
        }

        if(uploadResponse==null){
            throw  new IOException("上传阿里云失败");
        }else{
            sysFile.setFileUrl(uploadResponse.getUrl());
        }
        sysFile.setFileType(ext);
        if(isImageType(ext)){
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            sysFile.setFileHeight(height);
            sysFile.setFileWidth(width);
        }
        sysFileMapper.insertSelective(sysFile);
        fileTemp.delete();
        return sysFile;

    }

    public SysFile uploadToAli(File file) throws IOException {

        String ext = FileTool.getExtention(file.getName());
        SysFile sysFile = new SysFile();
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        String ufn = System.nanoTime()+ext;
        UploadResponse uploadResponse = null;
        if(isImageType(ext)){
            uploadResponse = MediaUploadClient.uploadImg(file,ufn);
        }else {
            uploadResponse = MediaUploadClient.uploadFile(file,ufn);
        }

        if(uploadResponse==null){
            throw  new IOException("上传阿里云失败");
        }else{
            sysFile.setFileName(uploadResponse.getName());
            sysFile.setFileUrl(uploadResponse.getUrl());
            sysFile.setFileSize(Integer.valueOf(uploadResponse.getFileSize()+""));
        }
        sysFile.setFileType(ext);
        if(isImageType(ext)){
            BufferedImage bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            sysFile.setFileHeight(height);
            sysFile.setFileWidth(width);
        }
        sysFileMapper.insertSelective(sysFile);
        return sysFile;

    }
    public SysFile uploadToAli(InputStream inputStream, String ext, Long s) throws IOException {

        SysFile sysFile = new SysFile();
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        String ufn =System.nanoTime()+ext;
        UploadResponse uploadResponse = null;
        if(isImageType(ext)){
            uploadResponse = MediaUploadClient.uploadImg(inputStream,ufn,s);
        }else {
            uploadResponse = MediaUploadClient.uploadFile(inputStream,ufn,s);
        }

        if(uploadResponse==null){
            throw  new IOException("上传阿里云失败");
        }else{
            sysFile.setFileName(uploadResponse.getName());
            sysFile.setFileUrl(uploadResponse.getUrl());
            sysFile.setFileSize(Integer.valueOf(uploadResponse.getFileSize()+""));
            sysFile.setFileType(ext);
            sysFile.setFileHeight(0);
            sysFile.setFileWidth(0);
        }

        sysFileMapper.insertSelective(sysFile);
        return sysFile;

    }

    public String getUrlByFileId(String uuid){
        SysFile sysFile =  sysFileMapper.selectByPrimaryKey(uuid);
        if(sysFile!=null){
            return "";
        }else{
            return  PropKit.use("three-app.properties").get("sys.serverUrl")+sysFile.getFileUrl();
        }
    }
    public String getUrlByUrl(String url){
        return  PropKit.use("three-app.properties").get("sys.serverUrl")+url;
    }
}
