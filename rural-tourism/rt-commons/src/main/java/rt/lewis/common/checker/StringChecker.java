package rt.lewis.common.checker;


import rt.lewis.utils.string.StringUtils;

/**
 * Created by cgnb_wangjie on 14-11-20.
 */
public class StringChecker {

    /**
     * 校验是否为Null或空串
     *
     * @param val
     * @return
     */
    public static boolean checkNotEmpty(String val) {
        return val != null && !StringUtils.isEmpty(val.trim());
    }

    /**
     * 校验是否为全部空白字符
     *
     * @param val
     * @return
     */
    public static boolean checkNotBlank(String val) {
        return !StringUtils.isBlank(val);
    }

    /**
     * 校验字符串字节长度，不包括空格
     *
     * @param val
     * @param min
     * @param max
     * @return
     */
    public static boolean checkLength(String val, int min, int max) {
        if (val == null) {
            return false;
        }
        byte[] bytes = val.trim().getBytes();
        return bytes.length >= min && bytes.length <= max;
    }

    /**
     * 校验字符串字符个数，不包括空格
     *
     * @param val
     * @param min
     * @param max
     * @return
     */
    public static boolean checkCount(String val, int min, int max) {
        if (val == null) {
            return false;
        }
        char[] chars = val.trim().toCharArray();
        return chars.length >= min && chars.length <= max;
    }

    /**
     * 校验字符串是否全中文
     *
     * @param val
     * @return
     */
    public static boolean checkChinese(String val) {
        if (val == null) {
            return false;
        }
        for (char c : val.trim().toCharArray()) {
            // 19968--171941是unicode对汉字编码的范围
            if (c <= 19968 || c >= 171941) {
                return false;
            }
        }
        return true;
    }


}
