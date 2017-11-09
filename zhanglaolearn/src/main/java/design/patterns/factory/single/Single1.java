package design.patterns.factory.single;/**
 * Created by zhangqin on 2017/11/9.
 */

import java.security.Signature;

/**
 * @author
 * @create 2017-11-09 15:47
 **/
public class Single1 {

    private static Single1 single1 = new Single1();
    private Single1 (){}
    public static Single1 getInstance() {
        return single1;
    }

}
