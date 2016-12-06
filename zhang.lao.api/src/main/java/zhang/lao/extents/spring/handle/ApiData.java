package zhang.lao.extents.spring.handle;

import java.lang.annotation.*;


@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ApiData {
    boolean tokenValidate() default true;
}
