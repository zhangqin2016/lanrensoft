package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 14:07
 **/
public class BigCarFactory extends AbsFactory {

    @Override
    BigCar getColor(Class<? extends BigCar> bigCar) {
        try {
            Object o = Class.forName(bigCar.getName()).newInstance();
            return (BigCar) o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    Car getCar(Class<? extends Car> car) {
       return null;
    }
}
