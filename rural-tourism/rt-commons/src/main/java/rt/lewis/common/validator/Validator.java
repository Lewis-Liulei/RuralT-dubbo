package rt.lewis.common.validator;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by cgnb_wangjie on 14-12-8.
 */
public interface Validator {

    /**
     * 执行校验
     *
     * @return
     */
    public <T> List<String> validate(T data, String fieldName, Annotation annotation);

}
