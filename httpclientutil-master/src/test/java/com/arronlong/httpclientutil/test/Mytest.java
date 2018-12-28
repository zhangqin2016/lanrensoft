package com.arronlong.httpclientutil.test;/**
 * Created by zhangqin on 2017/10/27.
 */

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;

/**
 * @author
 * @create 2017-10-27 17:40
 **/
public class Mytest {

    public static void main(String[] args) throws HttpProcessException {
        Header[] headers 	= HttpHeader.custom() .build();
        HttpConfig config = HttpConfig.custom()
                .headers(headers)	//设置headers，不需要时则无需设置
                .url("http://localhost:9200/wn_lnglat_gt06/_search")					//设置请求的url
                .encoding("utf-8") //设置请求和返回编码，默认就是Charset.defaultCharset()
                //.client(client)														//如果只是简单使用，无需设置，会自动获取默认的一个client对象
                //.inenc("utf-8") 													//设置请求编码，如果请求返回一直，不需要再单独设置
                //.inenc("utf-8")													//设置返回编码，如果请求返回一直，不需要再单独设置
                .json("{\n" +
                        "\t\"query\": {\n" +
                        "    \"bool\": {\n" +
                        "      \"must\": [\n" +
                        "        { \"match\": { \"device_id\": \"1\" } } \n" +
                        "      ],\n" +
                        "         \"filter\": {\n" +
                        "        \"range\": {\n" +
                        "          \"create_time\": {\n" +
                        "         \t\t\"gt\":\"2017-9-16 00:11:11\",\n" +
                        "\t\t\t\t\"lte\":\"2017-11-27 11:11:11\"\n" +
                        "          }\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  },\n" +
                        " \n" +
                        "\t\"sort\":[{\n" +
                        "\t\t\"create_time\":{\"order\":\"asc\"}\n" +
                        "\t}]\n" +
                        "}")												//json方式请求的话，就不用设置map方法，当然二者可以共用。
                //.context(HttpCookies.custom().getContext()) 		//设置cookie，用于完成携带cookie的操作
                //.out(new FileOutputStream("保存地址"))			 	//下载的话，设置这个方法,否则不要设置
                //.files(new String[]{"d:/1.txt","d:/2.txt"})					//上传的话，传递文件路径，一般还需map配置，设置服务器保存路径
                ;
        String post = HttpClientUtil.post(config);
        System.out.println(post);
    }
}
