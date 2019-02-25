package rt.lewis.common.validator;

import rt.lewis.common.annotation.Length;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串长度校验器,校验字符个数
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class LengthValidator implements Validator {

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
        Length length = (Length) annotation;
        int min = length.min();
        int max = length.max();
        int dataLength = value.toString().toCharArray().length;
        if (dataLength > max || dataLength < min) {
        	String message = length.message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("字段长度不正确，字段必须大于或等于" + min + "个字符， 小于或等于" + max + "个字符");
        	}
        }
        return result;
    }
}
