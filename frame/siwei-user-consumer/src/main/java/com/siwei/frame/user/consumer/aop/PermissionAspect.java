package com.siwei.frame.user.consumer.aop;

import com.siwei.frame.common.utils.annotation.RequirePermission;
import com.siwei.frame.common.utils.annotation.RequireRole;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.exception.CommonException;
import com.siwei.frame.common.utils.util.JWTUtil;
import com.siwei.frame.common.utils.util.JsonUtils;
import com.siwei.frame.common.utils.util.PermissionAnnotationUtil;
import com.siwei.frame.common.utils.util.RoleAndPermissionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class PermissionAspect {

	@Pointcut("execution(public * com.siwei.frame.user.consumer.controller.*.*(..))")
	public void permissionAspect() {
	}

	@Around("permissionAspect()")
	public Object permissionAspectAround(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object target = joinPoint.getTarget();
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			boolean hasAnnotation = PermissionAnnotationUtil.hasAnnotation(target.getClass(), methodSignature.getName(),
					methodSignature.getParameterTypes());
			if (hasAnnotation) {

				RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
				ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
				HttpServletRequest request = servletRequestAttributes.getRequest();
				String token = request.getHeader("token");
				Map<String, Object> claims = JWTUtil.parseJwt(token);
				List<String> rolesList = JsonUtils.jsonToList((String) claims.get("roles"), String.class);
				List<String> permissionsList = JsonUtils.jsonToList((String) claims.get("permissions"), String.class);

				String[] requireRolesOrPermissions = PermissionAnnotationUtil.parseRoleOrPermission(target.getClass(),
						methodSignature.getName(), methodSignature.getParameterTypes(), RequireRole.class);
				if (requireRolesOrPermissions != null && requireRolesOrPermissions.length > 0) {
					boolean hasRole = RoleAndPermissionUtil.hasRoleOrPermission(rolesList, requireRolesOrPermissions,
							target.getClass(), methodSignature.getName(), methodSignature.getParameterTypes(),
							RequireRole.class);
					if (!hasRole)
						throw new CommonException(ExceptionResultEnum.NO_PERMISSION);
				}

				requireRolesOrPermissions = PermissionAnnotationUtil.parseRoleOrPermission(target.getClass(),
						methodSignature.getName(), methodSignature.getParameterTypes(), RequirePermission.class);
				if (requireRolesOrPermissions != null && requireRolesOrPermissions.length > 0) {
					boolean hasPermission = RoleAndPermissionUtil.hasRoleOrPermission(permissionsList,
							requireRolesOrPermissions, target.getClass(), methodSignature.getName(),
							methodSignature.getParameterTypes(), RequirePermission.class);
					if (!hasPermission)
						throw new CommonException(ExceptionResultEnum.NO_PERMISSION);
				}
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new CommonException(ExceptionResultEnum.CLASS_METHOD_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			throw new CommonException(ExceptionResultEnum.ANNOTATION_GET_ERROR);
		}
		Object object = joinPoint.proceed();
		return object;
	}
}
