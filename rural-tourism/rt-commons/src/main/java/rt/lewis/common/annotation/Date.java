package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 日期格式校验，只适用于String类型的属性
 * 校验规则
 *
 * 1、非Null
 * 2、满足指定格式
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Date {
	public abstract String message();

    public String format() default "yyyy-MM-dd HH:mm:ss";

}
