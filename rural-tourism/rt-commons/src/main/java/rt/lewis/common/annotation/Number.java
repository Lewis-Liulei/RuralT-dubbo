package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 数字校验注解
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Number {
	public abstract String message();

    // 最小值, 包含
    public long min() default Long.MIN_VALUE;

    // 最大值，包含
    public long max() default Long.MAX_VALUE;

}
