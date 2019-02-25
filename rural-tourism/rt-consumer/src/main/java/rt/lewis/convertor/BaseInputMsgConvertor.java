package rt.lewis.convertor;

import org.springframework.stereotype.Component;
import rt.lewis.rainbow.request.BaseInputMsg;

/**
 * 基本请求参数转换(适用于无特殊业务参数请求，BaseInputMsg已满足请求参数要求)
 * @author cgnb_wangjie
 *
 */
@Component(value = "baseInputMsgConvertor")
public class BaseInputMsgConvertor extends AbstractConvertor {

	@Override
	protected BaseInputMsg createInputMsg() {
		return new BaseInputMsg();
	}
	
}
