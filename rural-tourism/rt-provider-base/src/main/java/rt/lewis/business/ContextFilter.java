package rt.lewis.business;

import cn.cgnb.common.ProcessContext;
import cn.cgnb.dao.exception.DBException;
import cn.cgnb.gateway.transport.exception.GatewayThrowable;
import cn.cgnb.gateway.transport.exception.TransportException;
import cn.cgnb.utils.logger.LogUtil;
import com.alibaba.dubbo.rpc.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rt.lewis.common.exception.ZSBusinessException;
import rt.lewis.rainbow.request.BaseInputMsg;
import rt.lewis.rainbow.response.ReturnMessage;

import java.util.Map;

//import net.dubboclub.catmonitor.constants.CatConstants;
//import com.dianping.cat.Cat;
//import com.dianping.cat.message.Transaction;

/**
 * dubbo拦截器
 * 
 * @author cgnb_wangjie
 *
 */
public class ContextFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(ContextFilter.class);

	private CommonFilter filterUtil;

	public static final String LOG_ID = "ServiceId";
/*
	private TransLogProcessService transLogProcessService;

	private SysErrorCodeItemService sysErrorCodeItemService;

	private AppInvokeService appInvokeService;

	private TransCommonContextService transCommonContextService;
	
	private ActivitySendMsg activitySendMsg;*/

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		ReturnMessage returnMessage = new ReturnMessage();
		Result result = null;
		return result;
		// Transaction t = null;
		/*
		 * try { t = Cat.newTransaction(CatConstants.CROSS_SERVER,
		 * invocation.getMethodName());
		 * Cat.logMetricForCount(invocation.getMethodName()); } catch (Exception
		 * e) { LogUtil.error(logger, "Cat监控异常", new Object[]{}); }
		 */
		/*try {
			// 校验参数
			Object obj = invocation.getArguments()[0];
			if (obj == null) {
				LogUtil.error(logger, "接口调用参数为null, 调用方法: {}", invocation.getMethodName());
				throw new ZSBusinessException("P01", "参数错误");
			}
			if (obj instanceof BaseInputMsg) {
				BaseInputMsg inputMsg = null;
				inputMsg = (BaseInputMsg) obj;*/
				
				/*
				 * try { Cat.logEvent("invoke.param",
				 * RpcContext.getContext().getAttachment(LOG_ID) + " param:" +
				 * JsonUtil.toJSON(inputMsg));
				 * Cat.logMetricForCount(inputMsg.getUrl()); } catch (Exception
				 * e) { LogUtil.error(logger, "Cat监控异常", new Object[]{}); }
				 */
				/*transCommonContextService.setLocalTransName(
						inputMsg.getProcessContext(),
						invocation.getMethodName());
				transCommonContextService.loadContext(inputMsg);
				String transDesc = transCommonContextService.getTransConfig(
						inputMsg.getProcessContext()).getTransDesc();
				LogUtil.debug(logger, "{}{}方法请求开始,请求参数:{}", new Object[] {
						transDesc, invocation.getMethodName(), obj });*/
				
				//检查版本
				/*returnMessage = filterUtil.checkAppVersion(inputMsg);
				if (!"00".equals(returnMessage.getCode())) {
					LogUtil.error(logger, "版本检查需要更新, 更新地址: {}",
							new Object[] { returnMessage.getContext().get("updateUrl")});
					result = new RpcResult(returnMessage);
					return result;*/
				//}
				
				/*// 参数校验
				Map<String, Object> check = RequestParamValidator.validate(obj);
				if (!check.isEmpty()) {
					LogUtil.error(logger, "接口调用参数错误, 调用方法: {}, check:{}",
							new Object[] { invocation.getMethodName(), check });
					returnMessage.setContext(check);
					throw new ZSBusinessException("P01", "参数错误");*/
				//}

				// 调用权限检查
				// checkInvokeRight(inputMsg.getProcessContext());

				// 登陆检查
				/*returnMessage = filterUtil.loginInfoCheck(inputMsg,
						returnMessage);
				if (returnMessage.hasError()) {
					LogUtil.info(logger, "登录检查失败");
					throw new ZSBusinessException(returnMessage.getCode(),
							returnMessage.getMessage());
				}
				// 记录流水
				boolean preJnl = transLogProcessService.beforeHandler(
						inputMsg.getProcessContext(), invocation);
				// 调用服务
				result = invoker.invoke(invocation);
				
				// 更新流水
				if (preJnl) {
					transLogProcessService.afterHandler(
							inputMsg.getProcessContext(), invocation,
							result.getException());
				}
				// 如果服务调用发生异常，则转换成对应的错误编码返回
				if (result.hasException()) {
					Throwable exception = result.getException();
					*//*
					 * try { t.setStatus(exception); } catch (Exception e) {
					 * LogUtil.error(logger, "Cat监控异常", new Object[]{}); }
					 *//*

					// 如果是BizException异常，直接处理
					if (exception instanceof ZSBusinessException) {
						*//*
						 * if (exception instanceof
						 * ZSTransactionTimeOutCatchedException || exception
						 * instanceof ZSTransactionTimeOutException) { try {
						 * Cat.logEvent("GATEWAY_TIME_OUT",
						 * invocation.getMethodName(), "timeout", null); } catch
						 * (Exception e) { LogUtil.error(logger, "Cat监控异常", new
						 * Object[]{}); } }
						 *//*
						ZSBusinessException bizException = (ZSBusinessException) exception;
						returnMessage.setCode(bizException.getErrorCode());
						returnMessage.setMessage(bizException.getMessage());
						LogUtil.error(
								logger,
								"业务处理失败[异常来自业务层]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
								new Object[] { invocation.getMethodName(),
										returnMessage.getCode(),
										returnMessage.getMessage(), exception });
					} else if (exception instanceof GatewayThrowable) {
						GatewayThrowable gatewayThrowable = (GatewayThrowable) exception;
						LogUtil.error(
								logger,
								"业务处理失败[异常来自gateway]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
								new Object[] { invocation.getMethodName(),
										returnMessage.getCode(),
										returnMessage.getMessage(), exception });
						*//*
						 * if (exception instanceof ReturnTimeoutException) { try {
						 * Cat.logEvent("GATEWAY_TIME_OUT",
						 * invocation.getMethodName(), "timeout",
						 * "transcode:"+gatewayThrowable
						 * .getHostTrsCode()+"jnlno:"+gatewayThrowable.getJnlno());
						 * } catch (Exception e) { LogUtil.error(logger,
						 * "Cat监控异常", new Object[]{}); } }
						 *//*
						try {
							sysErrorCodeItemService.logSysCodeItem(
									gatewayThrowable, ContextUtil.getUser(inputMsg
											.getProcessContext()), inputMsg
											.getProcessContext());
						} catch (Exception e1) {
							LogUtil.error(
									logger,
									"从第三方系统获取错误编码和错误信息插入数据库发生错误,HostTrsCode={},返回码={},返回信息={}",
									new Object[] {
											gatewayThrowable.getHostTrsCode(),
											gatewayThrowable.getErrorCode(),
											gatewayThrowable.getErrorDescription(),
											e1 });
						}
						returnMessage.setCode(gatewayThrowable.getErrorCode());
						returnMessage.setMessage(gatewayThrowable
								.getErrorDescription());
					} else if (exception instanceof TransportException) {
						TransportException transportException = (TransportException) exception;
						returnMessage.setCode(transportException.getErrorCode());
						returnMessage.setMessage(transportException
								.getErrorDescription());
						LogUtil.error(
								logger,
								"外围系统连接异常[异常来自gateway]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
								new Object[] { invocation.getMethodName(),
										returnMessage.getCode(),
										returnMessage.getMessage(), exception });
					} else if (exception instanceof DBException) {
						returnMessage.setCode("DBERROR");
						returnMessage.setMessage("服务异常");
						LogUtil.error(
								logger,
								"业务处理失败[异常来自DB]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
								new Object[] { invocation.getMethodName(),
										returnMessage.getCode(),
										returnMessage.getMessage(), exception });
					} else {
						returnMessage.setCode("C98");
						returnMessage.setMessage("业务处理繁忙，请稍后再试");
						LogUtil.error(logger, "业务处理发生未知异常。调用方法： {}，异常信息:",
								new Object[] { invocation.getMethodName(),
										exception });
					}
					result = new RpcResult(returnMessage);
				}
				activitySendMsg.sendMsg(new ActivityUrlEvent(inputMsg, (ReturnMessage) result.getValue()));
			} 
			else if (obj instanceof PaysdkBaseParams) {
					PaysdkBaseParams paysdkBaseParams = null;
					paysdkBaseParams = (PaysdkBaseParams) obj;
					// 调用服务
					result = invoker.invoke(invocation);
					// 如果服务调用发生异常，则转换成对应的错误编码返回
					if (result.hasException()) {
						Throwable exception = result.getException();
						// 如果是BizException异常，直接处理
						if (exception instanceof ZSBusinessException) {
							ZSBusinessException bizException = (ZSBusinessException) exception;
							returnMessage.setCode(bizException.getErrorCode());
							returnMessage.setMessage(bizException.getMessage());
							LogUtil.error(
									logger,
									"业务处理失败[异常来自业务层]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
									new Object[] { invocation.getMethodName(),
											returnMessage.getCode(),
											returnMessage.getMessage(), exception });
						} else if (exception instanceof GatewayThrowable) {
							GatewayThrowable gatewayThrowable = (GatewayThrowable) exception;
							LogUtil.error(
									logger,
									"业务处理失败[异常来自gateway]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
									new Object[] { invocation.getMethodName(),
											returnMessage.getCode(),
											returnMessage.getMessage(), exception });
							*//*
							 * if (exception instanceof ReturnTimeoutException) { try {
							 * Cat.logEvent("GATEWAY_TIME_OUT",
							 * invocation.getMethodName(), "timeout",
							 * "transcode:"+gatewayThrowable
							 * .getHostTrsCode()+"jnlno:"+gatewayThrowable.getJnlno());
							 * } catch (Exception e) { LogUtil.error(logger,
							 * "Cat监控异常", new Object[]{}); } }
							 *//*
							try {
								sysErrorCodeItemService.logSysCodeItem(
										gatewayThrowable, ContextUtil.getUser(paysdkBaseParams
												.getProcessContext()), paysdkBaseParams
												.getProcessContext());
							} catch (Exception e1) {
								LogUtil.error(
										logger,
										"从第三方系统获取错误编码和错误信息插入数据库发生错误,HostTrsCode={},返回码={},返回信息={}",
										new Object[] {
												gatewayThrowable.getHostTrsCode(),
												gatewayThrowable.getErrorCode(),
												gatewayThrowable.getErrorDescription(),
												e1 });
							}
							returnMessage.setCode(gatewayThrowable.getErrorCode());
							returnMessage.setMessage(gatewayThrowable
									.getErrorDescription());
						} else if (exception instanceof TransportException) {
							TransportException transportException = (TransportException) exception;
							returnMessage.setCode(transportException.getErrorCode());
							returnMessage.setMessage(transportException
									.getErrorDescription());
							LogUtil.error(
									logger,
									"外围系统连接异常[异常来自gateway]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
									new Object[] { invocation.getMethodName(),
											returnMessage.getCode(),
											returnMessage.getMessage(), exception });
						} else if (exception instanceof DBException) {
							returnMessage.setCode("DBERROR");
							returnMessage.setMessage("服务异常");
							LogUtil.error(
									logger,
									"业务处理失败[异常来自DB]。调用方法： {}，响应消息：ErrorCode:{}，Message:{}",
									new Object[] { invocation.getMethodName(),
											returnMessage.getCode(),
											returnMessage.getMessage(), exception });
						} else {
							returnMessage.setCode("C98");
							returnMessage.setMessage("业务处理繁忙，请稍后再试");
							LogUtil.error(logger, "业务处理发生未知异常。调用方法： {}，异常信息:",
									new Object[] { invocation.getMethodName(),
											exception });
						}
						result = new RpcResult(returnMessage);
					}
				}
			*//*
			 * else { try { t.setStatus(Transaction.SUCCESS); } catch (Exception
			 * e) { LogUtil.error(logger, "Cat监控异常", new Object[]{}); } }
			 *//*
			((ReturnMessage)result.getValue()).setAtoken(returnMessage.getAtoken());//设置Atoken
			
			return result;
		} catch (Throwable ex) {
			*//*
			 * try { t.setStatus(ex); } catch (Exception e) {
			 * LogUtil.error(logger, "Cat监控异常", new Object[]{}); }
			 *//*

			LogUtil.error(logger, "服务调用发生异常。调用方法： {}，异常信息：", new Object[] {
					invocation.getMethodName(), ex });
			if (ex instanceof ZSBusinessException) {
				returnMessage
						.setCode(((ZSBusinessException) ex).getErrorCode());
				returnMessage.setMessage(ex.getMessage());
			} else {
				returnMessage.setCode("C99");
				returnMessage.setMessage("服务繁忙，请稍后再试");
			}
			result = new RpcResult(returnMessage);
			return result;
		} finally {
			LogUtil.debug(logger, "{}方法请求结束,返回结果:{}", new Object[] {
					invocation.getMethodName(), result });
			*//*
			 * try { t.complete(); } catch (Exception e) {
			 * LogUtil.error(logger, "Cat监控异常", new Object[]{}); }
			 *//*
		}*/
	}

	private void checkInvokeRight(ProcessContext context) {
		/*String appID = transCommonContextService.getAppID(context);
		String appSecret = transCommonContextService.getAppSecret(context);
		if (StringUtil.isBlank(appID) || StringUtil.isBlank(appSecret)) {
			LogUtil.error(logger, "appID或appSecret不能为空");
			throw new ZSBusinessException("P01", "appID或appSecret不能为空");
		}
		String transCode = transCommonContextService.getTransConfig(context)
				.getTransCode();
		appInvokeService.checkAppInvokeRight(appID, appSecret, transCode);*/
	}

	// 注意:filter只支持setter方式注入bean
	public void setFilterUtil(CommonFilter filterUtil) {
		this.filterUtil = filterUtil;
	}

/*
	public void setTransLogProcessService(
			TransLogProcessService transLogProcessService) {
		this.transLogProcessService = transLogProcessService;
	}

	public void setSysErrorCodeItemService(
			SysErrorCodeItemService sysErrorCodeItemService) {
		this.sysErrorCodeItemService = sysErrorCodeItemService;
	}

	public void setAppInvokeService(AppInvokeService appInvokeService) {
		this.appInvokeService = appInvokeService;
	}

	public void setTransCommonContextService(
			TransCommonContextService transCommonContextService) {
		this.transCommonContextService = transCommonContextService;
	}

	public void setActivitySendMsg(ActivitySendMsg activitySendMsg) {
		this.activitySendMsg = activitySendMsg;
	}*/
	
	

}
