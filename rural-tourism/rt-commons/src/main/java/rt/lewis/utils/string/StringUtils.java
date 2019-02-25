package rt.lewis.utils.string;

public class StringUtils {

    public static boolean isBlankContainNull(String s) {
        return s == null || s.trim().equalsIgnoreCase("")
                || "null".equalsIgnoreCase(s) || "\"null\"".equalsIgnoreCase(s);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

  /*  public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }*/

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /*public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }*/


    public static boolean isNumeric(CharSequence cs) {
        if (cs != null && cs.length() != 0) {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

   /* public static boolean startsWith(CharSequence str, CharSequence prefix) {
        return startsWith(str, prefix, false);
    }

    private static boolean startsWith(CharSequence str, CharSequence prefix, boolean ignoreCase) {
        if (str != null && prefix != null) {
            return prefix.length() > str.length() ? false : CharSequenceUtils.regionMatches(str, ignoreCase, 0, prefix, 0, prefix.length());
        } else {
            return str == null && prefix == null;
        }
    }*/

}
