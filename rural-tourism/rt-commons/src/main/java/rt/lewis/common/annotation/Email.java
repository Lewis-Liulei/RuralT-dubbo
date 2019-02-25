package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * Email地址校验注解
 * 校验规则
 * 1、非空
 * 2、Email正则:"\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b"
 * 3、小于最大长度
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Email {
	public abstract String message();

    /**
     * 最大长度
     *
     * @return
     */
    public int maxLength() default 100;

}
