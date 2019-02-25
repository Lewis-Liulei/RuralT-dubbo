package rt.lewis.common.annotation;

import java.lang.annotation.*;

/**
 *
 * 银行卡号校验注解，用于标记字段是银行卡号格式
 * 校验规则:
 * 1、非空
 * 2、数字
 * 3、长度：15-18
 * Created by cgnb_wangjie on 14-12-8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BankCardNumber {
	public abstract String message();
}
