package design.patterns.factory.single;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 15:48
 **/
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}