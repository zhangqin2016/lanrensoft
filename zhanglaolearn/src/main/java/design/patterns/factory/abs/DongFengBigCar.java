package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 15:01
 **/
public class DongFengBigCar implements BigCar {
    @Override
    public void make() {
        System.out.println("制作了一个东风大卡车");
    }
}
