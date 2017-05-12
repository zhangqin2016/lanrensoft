package zhang.lao.build.kit;


import com.google.common.collect.Lists;
import com.squareup.okhttp.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * HttpKit
 */
public class HttpKit {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static OkHttpClient client;
    static {
        client = new OkHttpClient();
    }


    /**
     * 发送json提交
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String postJson(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);

        }

    }

    public static String upload(String url, List<File> files) throws IOException {
        //多个图片文件列表
        //多文件表单上传构造器
        MultipartBuilder multipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
        //添加一个文本表单参数
        multipartBuilder.addFormDataPart("method", "upload上传").addFormDataPart("token","5E8A4878C85149D345B88227E93E9A69489237156E1E8C03BEB5F394CED39EEF").addFormDataPart("openid","zhangqin");
        for(File file : files) {
            if(file.exists()) {
                multipartBuilder.addFormDataPart("file1", "file1", RequestBody.create(MediaType.parse("image/png"), file));
            }
        }
        //构造文件上传时的请求对象Request
        Request request = new Request.Builder().url(url).post(multipartBuilder.build()).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);

        }
    }
    public static void main(String[] args) throws IOException {
        String json ="{\n" +
                "    \"head\": {\n" +
                "        \"openid\": \"zhangqin\",\n" +
                " \"client\": \"iOS\", \n" +
                "\"versionCode\":\"1\",\n" +
                "        \"token\": \"5E8A4878C85149D345B88227E93E9A69489237156E1E8C03BEB5F394CED39EEF\"\n" +
                "    },\n" +
                "\"body\":{\n" +
                "tag:\"标签1\",\n" +
                "pageNumber:1\n" +
                "\n" +
                "}\n" +
                "}\n";
       String jsons =  HttpKit.postJson("http://10.10.1.199:9999/sunarvr/api/topic/list",json);
        System.out.println(jsons);
        List<File> list = Lists.newArrayList();
        list.add(new File("D:"+File.separator+"11.jpg"));
        String u = HttpKit.upload("http://10.10.1.199:9999/sunarvr/api/common/upload",list);
        System.out.println(u);
    }
}






