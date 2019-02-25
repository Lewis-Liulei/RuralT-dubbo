package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 非空校验注解, 校验所有字段不能全部为空。
 * 校验规则
 *
 * 1、所有字段不能全部为空
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotAllEmpty {

	public abstract String message();

    /**
     * 和当前字段关联的其他字段
     *
     * @return
     */
    public String[] otherFields();

}
