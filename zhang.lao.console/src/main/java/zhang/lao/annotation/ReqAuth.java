package zhang.lao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 张钦 on 2016/6/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqAuth {
    /**
     * 请求地址
     * @return
     */
    String url();

    /**
     *描述
     * @return
     */
    String description()default "";

    /**
     * 1 是json
     * 2 是页面
     * @return
     */
    int returnType() default 1;


}
