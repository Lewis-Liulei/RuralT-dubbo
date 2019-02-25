package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 非空校验注解
 * 校验规则
 *
 * 1、非Null
 * 2、trim后不等于空串
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotEmpty {
	public abstract String message();
}
