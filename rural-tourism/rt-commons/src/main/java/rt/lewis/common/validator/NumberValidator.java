package rt.lewis.common.validator;


import rt.lewis.utils.string.StringUtils;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import rt.lewis.common.annotation.Number;

/**
 * 数字校验器
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class NumberValidator implements Validator {

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
        if (value == null) {
            return result;
        }
        // 有负号（-）的话StringUtils.isNumeric会返回false.
        String val = value.toString();
        if (val.startsWith("-")) {
            val = val.substring(1);
        }
        if (!StringUtils.isNumeric(val)) {
            result.add("字段格式不正确，必须为数字");
            return result;
        }
        Number number = (Number) annotation;
        long min = number.min();
        long max = number.max();
        if (new BigDecimal(value.toString()).compareTo(BigDecimal.valueOf(min)) < 0) {
            result.add("字段格式不正确，必须大于等于" + min);
        }

        if (new BigDecimal(value.toString()).compareTo(BigDecimal.valueOf(max)) > 0) {
            result.add("字段格式不正确，必须小于等于" + max);
        }
        return result;
    }
}
