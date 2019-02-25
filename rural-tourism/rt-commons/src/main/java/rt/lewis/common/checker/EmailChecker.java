package rt.lewis.common.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮件地址校验器
 *
 * Created by cgnb_wangjie on 14-11-20.
 */
public class EmailChecker {

    /**
     * 默认手机号开头
     */
    public static final String EMAIL_ADDRESS_PATTERN = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

    /**
     * 邮箱最大长度
     */
    public static final int DEFAULT_MAX_EMAIL_LENGTH = 100;

    /**
     * 校验邮箱地址格式是否正确, 长度能超过100个字符
     *
     * @param email 邮箱地址
     * @return
     */
    public static boolean check(String email) {
        return check(email, DEFAULT_MAX_EMAIL_LENGTH);
    }

    /**
     * 校验邮箱地址格式是否正确
     *
     * @param email 邮箱地址
     * @param maxLength 最大长度
     * @return
     */
    public static boolean check(String email, Integer maxLength) {
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN, Pattern.CASE_INSENSITIVE);
        String compare = email.trim();
        Matcher matcher = pattern.matcher(compare);
        if (matcher.matches() && email.length() <= maxLength) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
