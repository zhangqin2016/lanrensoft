package design.patterns.factory.normal;/**
 * Created by zhangqin on 2017/11/9.
 */

/**
 * @author
 * @create 2017-11-09 14:06
 **/
public class BenChiCar implements Car{
    @Override
    public void make() {
        System.out.println("制作了一个奔驰汽车");
    }
}