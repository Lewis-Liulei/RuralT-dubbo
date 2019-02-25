package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 * 身份证号码校验注解，校验身份证号码格式标志
 * 校验规则
 * 1、非空
 * 2、数字或数字加x
 * 3、满足身份证校验位规则
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CertificateNumber {

	public abstract String message();

    public String typeField() default "certificateType";

}
