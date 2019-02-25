package rt.lewis.common.validator;

import rt.lewis.common.annotation.NotEmpty;
import rt.lewis.common.checker.StringChecker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 非空校验器
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
public class NotEmptyValidator implements Validator {

    @Override
    public <T> List<String> validate(T data, String fieldName, Annotation annotation) {
    	
        List<String> result = new ArrayList<String>();
        if (data == null) {
            return result;
        }
        Object value = null;
        /*try {
            value = PropertyUtils.getProperty(data, fieldName);
        } catch (Exception e) {
            return result;
        }*/
        if (value == null || !StringChecker.checkNotEmpty(value.toString())) {
        	String message = ((NotEmpty)annotation).message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("必填字段，不能为空串");
        	}
        }
        return result;
    }
}
