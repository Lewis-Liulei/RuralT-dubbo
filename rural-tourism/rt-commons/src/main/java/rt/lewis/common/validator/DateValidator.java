package rt.lewis.common.validator;

import rt.lewis.common.annotation.Date;
import rt.lewis.utils.date.DateUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 日期校验器
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class DateValidator implements Validator {

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

        Date date = (Date) annotation;
        String format = date.format();
        java.util.Date time = null;
        // 尝试进行日期转换，如果失败，则格式不正确
        try {
            time = DateUtil.formatStr2Date(value.toString(), format);
        } catch (Exception e) {
        }
        // 转换失败，或者长度不一致，则校验不通过
        if (time == null || value.toString().length() != format.length()) {
        	String message = date.message();
        	if (null != message && !"".equals(message.trim())) {
        		result.add(message);
        	} else {
                result.add("字段格式不正确，正确格式：" + format);
        	}
        }
        return result;
    }
}
