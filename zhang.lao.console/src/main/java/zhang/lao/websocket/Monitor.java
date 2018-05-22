package zhang.lao.websocket;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
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
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.sendMsg("当前时间:" + new Date());
    }

    @PostConstruct
    public void sendMsg() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 5, TimeUnit.SECONDS);

    }
}
