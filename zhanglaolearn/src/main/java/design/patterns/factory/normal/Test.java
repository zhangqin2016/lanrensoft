package design.patterns.factory.normal;/**
 * Created by zhangqin on 2017/11/9.
 */

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author
 * @create 2017-11-09 14:12
 **/
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        BenChiCar benChiCar = (BenChiCar) carFactory.make(BenChiCar.class);
        AoDiCar aoDiCar =  (AoDiCar) carFactory.make(AoDiCar.class);
        BaoMaCar baoMaCar =  (BaoMaCar) carFactory.make(BaoMaCar.class);
        benChiCar.make();
        aoDiCar.make();
        baoMaCar.make();
    }

}
