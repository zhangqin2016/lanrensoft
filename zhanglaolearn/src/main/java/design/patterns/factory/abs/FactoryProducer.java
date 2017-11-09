package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 15:17
 **/
public class FactoryProducer {

    public static AbsFactory getFactory(Class<? extends AbsFactory> a){
        try {
            Object o = Class.forName(a.getName()).newInstance();
            return (AbsFactory) o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
