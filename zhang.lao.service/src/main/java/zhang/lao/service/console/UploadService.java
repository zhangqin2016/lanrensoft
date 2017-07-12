package zhang.lao.service.console;

import aliupload.MediaUploadClient;
import com.alibaba.media.upload.UploadResponse;
import com.google.common.collect.Maps;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.SysFileMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.build.tool.FileTool;
import zhang.lao.build.tool.PathKit;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.pojo.upload.UploadResp;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 * Created by tech6 on 2016/6/30.
 */

@Service
public class UploadService {

    @Resource
    private SysFileMapper sysFileMapper;
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
    public UploadResp uploadLocal(InputStream inputStream, String path, String fileName) throws IOException {
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
    public SysFile uploadToDb(String txt,String path,String fileName) throws IOException {
        String ext = FileTool.getExtention(fileName);
        String filePath = PathKit.getWebRootPath()+path+File.separator+fileName;
        File f = new File(filePath);
        if(!f.exists()){
            f.getParentFile().mkdirs();
        }
        f.createNewFile();
        FileTool.write(filePath, new ByteArrayInputStream(txt.getBytes()));
        File file = new File(filePath);
        SysFile sysFile = new SysFile();
        sysFile.setFileSize(Integer.parseInt(file.length()+""));
        sysFile.setFileName(fileName);
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
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

        String fileName = file.getOriginalFilename();
        String ext = FileTool.getExtention(fileName);
        SysFile sysFile = new SysFile();
        sysFile.setFileSize(Integer.parseInt(file.getSize()+""));
        sysFile.setFileName(fileName);
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        String ufn = System.nanoTime()+ext;
        UploadResponse uploadResponse = null;
        if(isImageType(ext)){
            uploadResponse = MediaUploadClient.uploadImg(file.getInputStream(),ufn,file.getSize());
        }else {
            uploadResponse = MediaUploadClient.uploadFile(file.getInputStream(),ufn,file.getSize());
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
        return sysFile;

    }

    public SysFile uploadToAli(File file) throws IOException {

        String ext = FileTool.getExtention(file.getName());
        SysFile sysFile = new SysFile();
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        String ufn =System.nanoTime()+ext;
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
    public SysFile uploadToAli(InputStream inputStream,String ext,Long s) throws IOException {

        SysFile sysFile = new SysFile();
        sysFile.setCreateTime(new Date());
        sysFile.setFileId(UUIDTool.getUUID());
        sysFile.setLocal(0);
        String ufn = System.nanoTime()+ext;
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
            return  PropKit.use("sys.properties").get("sys.serverUrl")+sysFile.getFileUrl();
        }
    }
    public String getUrlByUrl(String url){
        return  PropKit.use("sys.properties").get("sys.serverUrl")+url;
    }
}
