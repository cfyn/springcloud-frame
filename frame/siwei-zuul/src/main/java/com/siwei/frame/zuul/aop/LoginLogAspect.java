package com.siwei.frame.zuul.aop;

import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.util.ClassUtil;
import com.siwei.frame.common.utils.util.DateUtil;
import com.siwei.frame.common.utils.util.RequestUtil;
import com.siwei.frame.zuul.client.SiweiServiceProviderClient;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LoginLogAspect {

	@Autowired
	private SiweiServiceProviderClient siweiServiceProviderClient;
	
	private static final Logger log = LoggerFactory.getLogger(LoginLogAspect.class);
	private static final String LOGIN = "登录";
	private static final String LOGOUT = "退出";

	@Pointcut("execution(public * com.siwei.frame.zuul.service.impl.*.baseLogin*(..))")
	public void baseLoginLog() {
	}

	@Pointcut("execution(public * com.siwei.frame.zuul.service.impl.*.logout*(..))")
	public void logoutLog() {
	}

	@Before("baseLoginLog()")
	public void beforeLoginLog(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		if (args == null)
			return;
		Arrays.stream(args).filter(e -> e instanceof UserLogin).forEach(
				e -> log.info("用户:" + ((UserLogin) e).getIdentifier() + ",于" + DateUtil.dateToLongString(new Date()) + "尝试" + LOGIN));
	}
	
	@AfterReturning("baseLoginLog()")
	public void afterReturnLogoutLog(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		Arrays.stream(args).filter(e -> e instanceof UserLogin).forEach(e -> createLoginLog((UserLogin) e, request));
	}
	
	@Before("logoutLog()")
	public void beforeLogoutLog(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		if (args == null)
			return;
		Arrays.stream(args).filter(e -> e instanceof Integer).forEach(
				e -> log.info("用户id:" + e + ",于" + DateUtil.dateToLongString(new Date()) + "尝试" + LOGOUT));
	}

	@AfterReturning("logoutLog()")
	public void afterReturnLoginLog(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		Arrays.stream(args).filter(e -> e instanceof Integer).forEach(e -> createLogoutLog((Integer) e, request));
	}
	
	@Transactional
	private void createLoginLog(UserLogin userLogin, HttpServletRequest request) {
		if (StringUtils.isNotBlank(userLogin.getCredential())) {
			BaseLog loginLog = new BaseLog();
			loginLog.setIp(RequestUtil.getIpAddress(request));
			loginLog.setOperation(LOGIN);
			loginLog.setLog(userLogin.getIdentifier() + LOGIN);
			loginLog.setOperatorId(userLogin.getUserId() == null ? null : userLogin.getUserId());
			loginLog.setTableName(ClassUtil.getLogTableName(userLogin));
			siweiServiceProviderClient.insertLog(loginLog);
		}
	}
	
	@Transactional
	private void createLogoutLog(Integer userId, HttpServletRequest request) {
		BaseLog loginLog = new BaseLog();
		loginLog.setIp(RequestUtil.getIpAddress(request));
		loginLog.setOperation(LOGOUT);
		loginLog.setLog("用户id:" + userId + "," +  LOGOUT);
		loginLog.setTableName(ClassUtil.getLogTableName(new UserLogin()));
		loginLog.setOperatorId(userId);
		siweiServiceProviderClient.insertLog(loginLog);
	}
}
