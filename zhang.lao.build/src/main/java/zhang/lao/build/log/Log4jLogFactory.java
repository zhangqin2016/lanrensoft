package zhang.lao.build.log;

/**
 * Created by tech6 on 2016/7/22.
 */
public class Log4jLogFactory implements ILogFactory {

    public Log getLog(Class<?> clazz) {
        return new Log4jLog(clazz);
    }

    public Log getLog(String name) {
        return new Log4jLog(name);
    }
}
