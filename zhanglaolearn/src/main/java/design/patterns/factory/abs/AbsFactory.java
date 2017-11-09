package design.patterns.factory.abs;

/**
 * Created by zhangqin on 2017/11/9.
 */
public abstract class AbsFactory {
        abstract BigCar getColor(Class<? extends BigCar> color);
        abstract Car getCar(Class<? extends Car> shape) ;
}
