package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 14:12
 **/
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = (CarFactory) FactoryProducer.getFactory(CarFactory.class);

        BenChiCar benChiCar = (BenChiCar) carFactory.getCar(BenChiCar.class);
        AoDiCar aoDiCar =  (AoDiCar) carFactory.getCar(AoDiCar.class);
        BaoMaCar baoMaCar =  (BaoMaCar) carFactory.getCar(BaoMaCar.class);
        benChiCar.make();
        aoDiCar.make();
        baoMaCar.make();

        BigCarFactory bigCarFactory = (BigCarFactory) FactoryProducer.getFactory(BigCarFactory.class);
        DongFengBigCar bigCar = (DongFengBigCar) bigCarFactory.getColor(DongFengBigCar.class);
        bigCar.make();
    }

}
