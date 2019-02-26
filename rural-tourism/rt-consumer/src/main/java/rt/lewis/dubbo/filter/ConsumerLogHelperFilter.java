package rt.lewis.dubbo.filter;

import cn.cgnb.utils.IDGenerator;
import cn.cgnb.utils.logger.Logger;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rt.lewis.rainbow.request.InputMsg;
import rt.lewis.utils.string.StringUtils;
import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@Activate(group = { "provider", "consumer" }, order = 10)
public class ConsumerLogHelperFilter implements Filter {
	public static final String LOG_ID = "ServiceId";
	public static final String CHANNEL_CODE = "CHANNEL_CODE";

	Logger logger = new Logger(getClass());
	
	@Value("#{invokerconfig}")
	private Map<String,String> invokerconfig;

	public Map<String, String> getInvokerconfig() {
		return invokerconfig;
	}

	public void setInvokerconfig(Map<String, String> invokerconfig) {
		this.invokerconfig = invokerconfig;
	}

	@PostConstruct
	public void init(){
		logger.info("ConsumerLogHelperFilter的init方法调用");
	}
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {

		if (null == invokerconfig || StringUtils.isBlank(invokerconfig.get(CHANNEL_CODE))) {
			logger.error("invokerconfig.properties配置信息有误！");
			throw new RpcException("invokerconfig.properties配置信息有误！");
		}

		boolean isClient = isClient(invoker.getUrl());
		String logId = RpcContext.getContext().getAttachment(LOG_ID);

		if (isClient) {
			if (logId == null) 
			{
				StringBuilder sb=new StringBuilder();
				Object obj = invocation.getArguments()[0];
				if(obj instanceof InputMsg){
					InputMsg msg=(InputMsg) obj;
					if(!StringUtils.isBlank(msg.getImei())){
						sb.append(msg.getImei());
					}
				}
				
				sb.append(invokerconfig.get(CHANNEL_CODE)).append(String.valueOf(IDGenerator.createId()));
				logId=sb.toString();
				
				RpcContext.getContext().setAttachment(LOG_ID, logId);
				RpcContext.getContext().setAttachment(CHANNEL_CODE, invokerconfig.get(CHANNEL_CODE));
				MDC.put(LOG_ID, logId);
			}
		} else {
			Logger.accessStart();
			if (logId != null) {
				MDC.put(LOG_ID, logId);
			}
		}
		try {
			if (!StringUtils.isBlank(logId) && logger.isDebugEnabled()) {
				logger.debug("ConsumerLogHelperFilter.logId:{}", logId);
			}
			Result localResult = invoker.invoke(invocation);

			return localResult;
		} finally {
			if (!isClient) {
				MDC.remove(LOG_ID);
			}
		}
	}

	private boolean isClient(URL url) {
		return "consumer".equals(url.getParameter("side"));
	}
}