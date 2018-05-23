package zhang.lao.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @create 2018-05-22 16:17
 **/
@Service
public class Monitor implements Runnable {


    @Override
    public void run() {
        CopyOnWriteArraySet<Map<String, MachineSocketRun>> webSocketSet = MachineSocketRun.webSocketSet;
        if(webSocketSet.isEmpty()){
        }else{
            for (Map<String, MachineSocketRun> stringMachineSocketRunMap : webSocketSet) {
                for (Map.Entry<String, MachineSocketRun> stringMachineSocketRunEntry : stringMachineSocketRunMap.entrySet()) {
                    String key = stringMachineSocketRunEntry.getKey();
                    MachineSocketRun value = stringMachineSocketRunEntry.getValue();
                    if(value.getLat()<1){
                        value.setLat(40.1375327225);
                        value.setLng(116.3620649885);
                    }
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("respType","1");
                    jsonObject.put("machineNumber","1");
                    jsonObject.put("lng",value.getLng()+0.000000001);
                    jsonObject.put("lat",value.getLat());
                    jsonObject.put("degree",200);
                    value.setLng(value.getLng()+0.000000001);
                    value.sendMsg( JSON.toJSONString(jsonObject),key);
                }
            }
        }
    }

    @PostConstruct
    public void sendMsg() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 5, TimeUnit.SECONDS);

    }
}
