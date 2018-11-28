package com.siwei.frame.user.provider.aop;

import com.siwei.frame.user.provider.client.SiweiServiceProviderClient;
import com.siwei.frame.common.utils.entity.BaseEntity;
import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.util.ClassUtil;
import com.siwei.frame.common.utils.util.JWTUtil;
import com.siwei.frame.common.utils.util.JsonUtils;
import com.siwei.frame.common.utils.util.RequestUtil;
import io.swagger.annotations.ApiModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	private SiweiServiceProviderClient siweiServiceProviderClient;
	
	private static final String SAVE_CODE = "新建";
	private static final String UPDATE_CODE = "修改";

	@Pointcut("execution(public * com.siwei.frame.user.provider.service.impl.*.insert*(..))")
	public void savePoint() {
	}
	
	@Pointcut("execution(public * com.siwei.frame.user.provider.service.impl.*.update*(..))")
	public void updatePoint() {
	}
	
	@AfterReturning("savePoint()")
	public void saveAround(JoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		Arrays.stream(args).filter(e -> e instanceof BaseEntity).forEach(e -> createLog(e, request, SAVE_CODE));
	}
	
	@AfterReturning("updatePoint()")
	public void updateAround(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		Arrays.stream(args).filter(e -> e instanceof BaseEntity).forEach(e -> createLog(e, request, UPDATE_CODE));
	}
	
	private <T> void createLog(T entity, HttpServletRequest request, String operation){
		ApiModel apiModel = entity.getClass().getAnnotation(ApiModel.class);
		if(apiModel != null) {
			try {
				String entityPropertity = apiModel.value();
				Class<?> entityClass = entity.getClass();
				Field[] fields = entityClass.getDeclaredFields();
				String log = ClassUtil.getEntityLog(entity, fields, operation, entityPropertity);
				
				BaseLog logEntity = new BaseLog();
				logEntity.setIp(RequestUtil.getIpAddress(request));
				logEntity.setOperation(operation);
				logEntity.setChangeJson(JsonUtils.objectToJson(entity));
				logEntity.setEntityId(operation.equals(SAVE_CODE) ? null : ClassUtil.getEntityId(entity, fields));
				logEntity.setLog(log);
				logEntity.setOperatorId(JWTUtil.getUserId(request.getHeader("token")));
				logEntity.setTableName(ClassUtil.getLogTableName(entity));
				// 保存日志 
				siweiServiceProviderClient.insertLog(logEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
