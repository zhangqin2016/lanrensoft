package zhang.lao.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
