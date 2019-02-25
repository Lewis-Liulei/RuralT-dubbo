package rt.lewis.common.validator;

import rt.lewis.common.annotation.CertificateNumber;
import rt.lewis.common.checker.IdCardNumberChecker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgnb_wangjie on 14-12-8.
 */
public class CertificateNumberValidator implements Validator {

    @Override
    public <T> List<String> validate(T data, String fieldName, Annotation annotation) {
        List<String> result = new ArrayList<String>();
        if (data == null) {
            return result;
        }
        CertificateNumber certificateNumber = (CertificateNumber) annotation;
        Object value = null;
        Object certifyType = null;
        /*try {
            value = PropertyUtils.getProperty(data, fieldName);
            certifyType = PropertyUtils.getProperty(data, certificateNumber.typeField());
        } catch (Exception e) {
            return result;
        }*/

        if (value == null || certifyType == null) {
            return result;
        }

//        CertificateTypeEnum certificateTypeEnum = CertificateTypeEnum.getEnum(certifyType.toString());
//        switch (certificateTypeEnum){
//            case ID_CARD:
                if (!IdCardNumberChecker.checkFormat(value.toString())) {
                	String message = certificateNumber.message();
                	if (null != message && !"".equals(message.trim())) {
                		result.add(message);
                	} else {
                        result.add("身份证号码格式不正确");
                	}
                }
//            case HOME_VISIT_PERMIT:
//            case PASSPORT:
//            case TAIWAN_COMPATRIOTS_CERTIFICATE:
//                if (!CredentialsUtil.isValidCardNumber(value.toString(), certificateTypeEnum)) {
//                    result.add("证件号码格式不正确");
//                }
//                return result;
//            case CERTIFICATE_OF_OFFICERS:
//            case OFFICERS_CARD:
//            case SOLDIERS:
//                break;
//            default:
//                result.add("不支持的证件类型");
//        }
        return result;
    }
}
