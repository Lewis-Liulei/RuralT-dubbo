package rt.lewis.common.validator;


import rt.lewis.common.annotation.BankCardNumber;
import rt.lewis.common.checker.BankCardChecker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgnb_wangjie on 14-12-8.
 */
public class BankCardNumberValidator implements Validator {

    @Override
    public <T> List<String> validate(T data, String fieldName, Annotation annotation) {
        List<String> result = new ArrayList<String>();
        if (data == null) {
            return result;
        }
        Object value = null;
      /*  try {
            value = PropertyUtils.getProperty(data, fieldName);
        } catch (Exception e) {
            return result;
        }
*/
        if (value == null) {
            return result;
        }
        if (!BankCardChecker.check(value.toString())) {
        	String message = ((BankCardNumber)annotation).message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("银行卡号格式不正确");
        	}
        }
        return result;
    }
}
