package rt.lewis.common.checker;

import rt.lewis.utils.string.StringUtils;

import java.util.Calendar;

/**
 * 身份证号码校验
 *
 * Created by cgnb_wangjie on 14-11-20.
 */
public class IdCardNumberChecker {

    /**
     * 身份证号码格式校验
     *
     * @param certificateNumber
     * @return
     */
    public static boolean checkFormat(String certificateNumber) {
        if (StringUtils.isBlank(certificateNumber)) {
            return false;
        }
        String number = certificateNumber.trim().toUpperCase();
        if (StringUtils.length(number) != 15 && StringUtils.length(number) != 18) {
            return false;
        }

        if (number.length() == 15) {
            return checkInfo15(number) >= 0;
        } else {
            return checkInfo18(number) >= 0;
        }
    }


    public static boolean checkRange(String idCardNumber,int minAge,int maxAge){
        int age = IdCardNumberChecker.getAge(idCardNumber);
        if (age < minAge || age >= maxAge) {
            return false;
        }
        return true;
    }

    /**
     * 通过身份证号获取年龄
     *
     * @param certificateNumber
     * @return
     */
    public static int getAge(String certificateNumber) {
        String number = certificateNumber.trim().toUpperCase();
        if (number.length() == 15) {
            return checkInfo15(number);
        } else {
            return checkInfo18(number);
        }
    }

    /**
     * 校验15位的身份证号码是否正确
     *
     * @param s
     * @return
     */
    public static int checkInfo15(String s) {
        String M = s;
        try {
            Calendar calendar = Calendar.getInstance();
            int now = calendar.get(Calendar.YEAR);
            int y = Integer.parseInt(M.substring(6, 8));
            int m = Integer.parseInt(M.substring(8, 10));
            int d = Integer.parseInt(M.substring(10, 12));
            if (m < 1 || m > 12 || d < 1 || d > 31
                    || ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) ||
                    (m == 2 && (((y + 1900) % 4 > 0 && d > 28) || d > 29))) {
                return -1;
            }
            int age = now - (y + 1900);
            if ((calendar.get(Calendar.MONTH) == (m-1) && calendar.get(Calendar.DATE) < d)
            		|| (calendar.get(Calendar.MONTH) < (m-1))) {
                age--;
            } 
            return age;
        } catch (Exception ex) {
            return -1;
        }
    }

    /**
     * 校验18位身份证号码是否正确
     *
     * @param s
     * @return
     */
    public static int checkInfo18(String s) {
        String M = s;
        int[] xx = {2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7};
        char[] yy = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        try {
            Calendar calendar = Calendar.getInstance();
            int now = calendar.get(Calendar.YEAR);
            int y = Integer.parseInt(M.substring(6, 10));
            int m = Integer.parseInt(M.substring(10, 12));
            int d = Integer.parseInt(M.substring(12, 14));
            int mm = 0;
            int[] gg = new int[18];
            if (y < 1800 || y > now || m < 1 || m > 12 || d < 1 || d > 31
                    || ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) ||
                    (m == 2 && ((y % 4 > 0 && d > 28) || d > 29))) {
                return -1;
            }
            for (int i = 1; i < 18; i++) {
                int j = 17 - i;
                gg[i - 1] = Integer.parseInt(M.substring(j, j + 1));
            }
            for (int i = 0; i < 17; i++) {
                mm += xx[i] * gg[i];
            }
            mm = mm % 11;
            char c = M.charAt(17);
            if (c != yy[mm]) {
                return -1;
            }
            int age = now - y;
            if ((calendar.get(Calendar.MONTH) == (m-1) && calendar.get(Calendar.DATE) < d)
            		|| (calendar.get(Calendar.MONTH) < (m-1))) {
                age--;
            } 
            return age;
        } catch (Exception ex) {
            return -1;
        }
    }

    public static void main(String[] args){
        System.out.println(checkInfo15("130501640101001123"));
    }
}
