package zhang.lao.extents.spring.handle;

import java.lang.annotation.*;


@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
/**
 * 用来标注api请求时的参数转换
 */
public @interface ApiData {
    boolean tokenValidate() default true;
}
