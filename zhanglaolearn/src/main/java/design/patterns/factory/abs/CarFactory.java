package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 14:07
 **/
public class CarFactory extends AbsFactory {

    @Override
    BigCar getColor(Class<? extends BigCar> color) {
        return null;
    }

    @Override
    Car getCar(Class<? extends Car> car) {
        try {
            Object o = Class.forName(car.getName()).newInstance();
            return (Car) o;
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
