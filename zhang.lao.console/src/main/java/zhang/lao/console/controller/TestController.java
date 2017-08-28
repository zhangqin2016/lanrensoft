package zhang.lao.console.controller;/**
 * Created by zhangqin on 2017/8/21.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

/**
 * 测试controller
 *
 * @author
 * @create 2017-08-21 15:04
 **/
@RestController
public class TestController {

    @RequestMapping("/img_upload")
    public JSONObject img_upload(String data)
    {
        System.out.println(data);
        return  getSuccessResult("http://wwww.baidu.com");
    }
    @RequestMapping("/body_upload")
    public JSONObject body_upload(String data){
        System.out.println(data);
        return  getSuccessResult();
    }
    private JSONObject getSuccessResult(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",1);
        jsonObject.put("errorCode","");
        jsonObject.put("errorMsg","");
        return jsonObject;
    }
    private JSONObject getSuccessResult(String pic){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",1);
        jsonObject.put("errorCode","");
        jsonObject.put("errorMsg","");
        JSONObject jsonObjectBody = new JSONObject();
        jsonObjectBody.put("picUrl",pic);
        jsonObject.put("data",jsonObjectBody);
        return jsonObject;
    }

    private JSONObject getErrorResult(String code , String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",0);
        jsonObject.put("errorCode",code);
        jsonObject.put("errorMsg",message);
        return jsonObject;
    }
}
