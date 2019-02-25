package rt.lewis.common.validator;


import rt.lewis.common.annotation.NotAllEmpty;
import rt.lewis.common.checker.StringChecker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 非空校验器
 * <p/>
 * Created by cgnb_wangjie on 14-12-8.
 */
public class NotAllEmptyValidator implements Validator {

    @Override
    public <T> List<String> validate(T data, String fieldName, Annotation annotation) {
        List<String> result = new ArrayList<String>();
        if (data == null) {
            return result;
        }
        // 校验当前字段是否为空
        Object value = null;
       /* try {
            value = PropertyUtils.getProperty(data, fieldName);
        } catch (Exception e) {
            return result;
        }*/
        if (value != null && StringChecker.checkNotEmpty(value.toString())) {
            return result;
        }
        NotAllEmpty notAllEmpty = (NotAllEmpty) annotation;
        String[] fields = notAllEmpty.otherFields();
        if (fields == null || fields.length < 1) {
            throw new RuntimeException("组合字段不能全部非空校验，必须指定关联字段。");
        }
        Object[] otherValues = new Object[fields.length];
        StringBuffer fieldNames = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
           /* try {
                otherValues[i] = PropertyUtils.getProperty(data, field);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            fieldNames.append(field);
            if (i != fields.length - 1) {
                fieldNames.append(",");
            }
        }
        for (Object otherValue : otherValues) {
            if (otherValue != null && StringChecker.checkNotEmpty(otherValue.toString())) {
                return result;
            }
        }
        result.add("当前字段与[" + fieldNames.toString() + "]不能全部为空。");
        return result;
    }
}
