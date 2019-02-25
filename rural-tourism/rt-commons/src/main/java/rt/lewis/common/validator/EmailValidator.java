package rt.lewis.common.validator;

import rt.lewis.common.annotation.Email;
import rt.lewis.common.checker.EmailChecker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮箱地址校验器
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class EmailValidator implements Validator {

    @Override
    public <T> List<String> validate(T data, String fieldName, Annotation annotation) {
        List<String> result = new ArrayList<String>();
        if (data == null) {
            return result;
        }
        Object value = null;
       /* try {
            value = PropertyUtils.getProperty(data, fieldName);
        } catch (Exception e) {
            return result;
        }*/
        if (value == null) {
            return result;
        }
        Email email = (Email) annotation;
        int maxLength = email.maxLength();
        if (!EmailChecker.check(value.toString(), maxLength)) {
        	String message = email.message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("邮箱地址格式不正确");
        	}
        }
        return result;
    }
}
