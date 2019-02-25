package rt.lewis.common.checker;


import rt.lewis.utils.string.StringUtils;

/**
 * Created by cgnb_wangjie on 14-11-20.
 */
public class BankCardChecker {

    /**
     * 银行卡校验
     *
     * @param bankCard
     * @return
     */
    public static boolean check(String bankCard) {
        if (!StringUtils.isNumeric(bankCard)) {
            return false;
        }
        // 校验银行卡
        if (StringUtils.isBlank(bankCard)) {
            return false;
        }
        if (StringUtils.length(bankCard.trim()) > 12
                && StringUtils.length(bankCard.trim()) < 20) {
            return true;
        }
        return false;
    }

}
