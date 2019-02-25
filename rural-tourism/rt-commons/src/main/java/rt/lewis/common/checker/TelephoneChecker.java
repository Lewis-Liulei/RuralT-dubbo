package rt.lewis.common.checker;


import rt.lewis.utils.string.StringUtils;

/**
 * 手机号码校验器
 *
 * Created by cgnb_wangjie on 14-11-20.
 */
public class TelephoneChecker {

    /**
     * 默认手机号开头
     */
    private static final String HEADERS = "1";

    /**
     * 校验手机号格式是否正确
     *
     * @param telephone 手机号
     * @param headers 开头字符
     * @return
     */
    public static boolean check(String telephone, String headers) {
        // 全数字，不为null，没有空格" "
        if (!StringUtils.isNumeric(telephone)) {
            return false;
        }
        // 长度为11位
        if (telephone.length() != 11) {
            return false;
        }
        // 指定开头字符
        /*String[] mobileHeaderArray = headers.split(":");
        for (String header : mobileHeaderArray) {
            if (StringUtils.startsWith(telephone.trim(), header)) {
                return true;
            }
        }*/
        return false;
    }

    public static boolean check(String telephone) {
        return check(telephone, HEADERS);
    }

}
