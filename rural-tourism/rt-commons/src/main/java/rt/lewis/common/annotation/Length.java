package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 字符串长度校验，只适用于String类型的属性
 * 校验规则
 * 1、非Null
 * 2、长度大于或等于min
 * 3、长度小于或等于max
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Length {
	
	public abstract String message();

    /**
     * 最小长度，默认是0，不算正负号
     * @return
     */
    public int min() default 0;

    /**
     * 最大长度，默认Integer的最大长度，不算正负号
     *
     * @return
     */
    public int max() default Integer.MAX_VALUE;

}
