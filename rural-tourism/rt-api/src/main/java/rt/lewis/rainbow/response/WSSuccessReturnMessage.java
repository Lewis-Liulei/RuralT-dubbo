package rt.lewis.rainbow.response;


import rt.lewis.dict.MvcConstants;
import rt.lewis.utils.BeanUtils;

import java.util.Map;

public class WSSuccessReturnMessage extends ReturnMessage{

	private static final long serialVersionUID = 6177580529758516349L;

	public WSSuccessReturnMessage() {
		super(MvcConstants.MVC_RETURN_TYPE_WS,MvcConstants.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstants.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
	}

	public WSSuccessReturnMessage(Map<String, Object> context) {
		super(MvcConstants.MVC_RETURN_TYPE_WS,MvcConstants.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstants.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
		this.context.putAll(context);
	}
	
	public WSSuccessReturnMessage(Object obj) {
		super(MvcConstants.MVC_RETURN_TYPE_WS,MvcConstants.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstants.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
		if (null != obj) {
			this.context.putAll(BeanUtils.object2Map(obj));
		}
	}	
	
	public WSSuccessReturnMessage(String key,Object obj) {
		super(MvcConstants.MVC_RETURN_TYPE_WS,MvcConstants.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstants.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
		this.context.put(key, obj);
	}	
}
