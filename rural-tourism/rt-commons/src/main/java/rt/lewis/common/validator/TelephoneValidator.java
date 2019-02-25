package rt.lewis.common.validator;

import rt.lewis.common.annotation.Telephone;
import rt.lewis.common.checker.TelephoneChecker;
import rt.lewis.utils.string.StringUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 手机号码校验器
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class TelephoneValidator implements Validator {

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
        if (value == null || StringUtils.isBlank(value.toString())) {
            return result;
        }
        Telephone telephone = (Telephone) annotation;
        String header = telephone.header();
        if (!TelephoneChecker.check(value.toString(), header)) {
            String message = telephone.message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("手机号码格式不正确.");
        	}
        }
        return result;
    }
}
