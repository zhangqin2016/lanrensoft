package design.patterns.factory.abs;/**
 * Created by zhangqin on 2017/11/9.
 */

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author
 * @create 2017-11-09 14:25
 **/
public class myMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return o;
    }
}
