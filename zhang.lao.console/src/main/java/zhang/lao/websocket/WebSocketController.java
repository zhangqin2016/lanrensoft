package zhang.lao.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author
 * @create 2018-05-22 16:10
 **/
@Controller
public class WebSocketController {

    @RequestMapping("/websocket/test")
    public String getTest(){
        return "websocket/test";
    }

    @RequestMapping("/machine/run")
    public String machine(){
        return "machineMonitoring/run";
    }
    @RequestMapping("/machine/run/test")
    public @ResponseBody
    HttpResult test(){
        CopyOnWriteArraySet< MachineSocketRun > webSocketSet = MachineSocketRun.webSocketSet;
        if (webSocketSet.isEmpty()) {
        } else {
            for (MachineSocketRun value : webSocketSet) {
                    if (value.getLat() < 1) {
                        value.setLat(40.1375327225);
                        value.setLng(116.3620649885);
                    }
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("respType", "1");
                    jsonObject.put("machineNumber", "1");
                    jsonObject.put("lng", value.getLng() + 0.001);
                    jsonObject.put("lat", value.getLat());
                    jsonObject.put("degree", 200);
                    value.setLng(value.getLng() + 0.001);
                    value.sendMsg(JSON.toJSONString(jsonObject), value);
            }
        }
        return HttpResultUtil.buildSuccess();
    }
}
