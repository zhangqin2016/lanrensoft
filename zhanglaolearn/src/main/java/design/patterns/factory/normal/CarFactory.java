package design.patterns.factory.normal;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 14:07
 **/
public class CarFactory {

    public Object make(Class<? extends Car> classes){
        try {
            Object o = Class.forName(classes.getName()).newInstance();
            return o;
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
