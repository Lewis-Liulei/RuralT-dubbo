package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 手机号码校验注解
 * 校验规则
 * 1、非空
 * 2、数字
 * 3、10:11:12:13:14:15:16:17:18:19开头
 * 4、11位
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Telephone {
	public abstract String message();

    /**
     * 手机号码开头数字
     *
     * @return
     */
    public String header() default "10:11:12:13:14:15:16:17:18:19";

}
