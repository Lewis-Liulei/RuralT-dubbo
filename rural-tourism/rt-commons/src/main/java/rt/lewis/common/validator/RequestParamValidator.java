package rt.lewis.common.validator;


import rt.lewis.common.annotation.*;

import java.lang.Number;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 请求参数校验辅助类，执行校验并返回校验结果
 *
 * Created by cgnb_wangjie on 14-12-8.
 */
public class RequestParamValidator {

    private static final Map<String, Validator> VALIDATORS = new HashMap<String, Validator>();

    static {
        initValidators();
    }

    /**
     * 初始化校验器
     */
    private static void initValidators() {
        VALIDATORS.clear();
        VALIDATORS.put(BankCardNumber.class.getName(), new BankCardNumberValidator());
        VALIDATORS.put(NotEmpty.class.getName(), new NotEmptyValidator());
        VALIDATORS.put(NotAllEmpty.class.getName(), new NotAllEmptyValidator());
        VALIDATORS.put(Date.class.getName(), new DateValidator());
        VALIDATORS.put(Email.class.getName(), new EmailValidator());
        VALIDATORS.put(Length.class.getName(), new LengthValidator());
        VALIDATORS.put(Number.class.getName(), new NumberValidator());
        VALIDATORS.put(Telephone.class.getName(), new TelephoneValidator());
    }

    /**
     * 添加新的校验器
     *
     * @param validateAnnotation
     * @param validator
     * @param <T>
     */
    public static <T extends Validator> void addValidator(Class validateAnnotation, T validator) {
        if (!VALIDATORS.containsKey(validateAnnotation.getName())) {
            VALIDATORS.put(validateAnnotation.getName(), validator);
        }
    }

    /**
     * 执行请求参数校验
     *
     * @param data 待校验的数据对象
     * @param <T>  数据对象的类型
     * @return 校验后所有错误字段的错误信息
     */
    public static <T> Map<String, Object> validate(T data) {
        if (data == null) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> result = new HashMap<String, Object>();
        Field[] fields = data.getClass().getDeclaredFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                Annotation[] annotations = field.getAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                List<String> fieldErrors = new ArrayList<String>();
                for (Annotation annotation : annotations) {
                    Validator validator = getValidator(annotation);
                    if (validator != null) {
                        // 校验参数
                        List<String> annotationErrors = validator.validate(data, field.getName(), annotation);
                        if (annotationErrors != null && !annotationErrors.isEmpty()) {
                            fieldErrors.addAll(annotationErrors);
                        }
                    }
                }
                // 添加字段的错误信息
                if (fieldErrors != null && !fieldErrors.isEmpty()) {
                    result.put(field.getName(), fieldErrors);
                    break;
                }
            }
        }
        //父类字段校验
        if (data.getClass().getSuperclass() == null) {
        	return result;
        }
        fields = data.getClass().getSuperclass().getDeclaredFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                Annotation[] annotations = field.getAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                List<String> fieldErrors = new ArrayList<String>();
                for (Annotation annotation : annotations) {
                    Validator validator = getValidator(annotation);
                    if (validator != null) {
                        // 校验参数
                        List<String> annotationErrors = validator.validate(data, field.getName(), annotation);
                        if (annotationErrors != null && !annotationErrors.isEmpty()) {
                            fieldErrors.addAll(annotationErrors);
                        }
                    }
                }
                // 添加字段的错误信息
                if (fieldErrors != null && !fieldErrors.isEmpty()) {
                    result.put(field.getName(), fieldErrors);
                    break;
                }
            }
        }
        
        return result;
    }

    /**
     * 根据注解获取对应的校验类
     *
     * @param annotation
     * @return
     */
    public static Validator getValidator(Annotation annotation) {
        if (VALIDATORS.isEmpty()) {
            initValidators();
        }
        return VALIDATORS.get(annotation.annotationType().getName());
    }

}
