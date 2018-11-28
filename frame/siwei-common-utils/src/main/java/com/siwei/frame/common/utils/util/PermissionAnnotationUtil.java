package com.siwei.frame.common.utils.util;

import com.siwei.frame.common.utils.annotation.RequirePermission;
import com.siwei.frame.common.utils.annotation.RequireRole;
import com.siwei.frame.common.utils.enums.Logical;

import java.lang.reflect.Method;

public class PermissionAnnotationUtil {

	public static String[] parseRoleOrPermission(Class<?> targetClass, String methodName, Class<?>[] paramterTypes, Class<?> annotationClass) throws NoSuchMethodException, SecurityException {
		Method method = getMethod(targetClass, methodName, paramterTypes);
		
		if (annotationClass.equals(RequireRole.class)) {
			RequireRole requireRole = method.getAnnotation(RequireRole.class);
			return requireRole == null ? null : requireRole.value();
		} else {
			RequirePermission requirePermission = method.getAnnotation(RequirePermission.class);
			return requirePermission == null ? null : requirePermission.value();
		}
	}
	
	public static Logical getRoleOrPermissionLogical(Class<?> targetClass, String methodName, Class<?>[] paramterTypes, Class<?> annotationClass) throws NoSuchMethodException, SecurityException {
		Method method = getMethod(targetClass, methodName, paramterTypes);
		
		if (annotationClass.equals(RequireRole.class)) {
			RequireRole requireRole = method.getAnnotation(RequireRole.class);
			return requireRole == null ? null : requireRole.logical();
		} else {
			RequirePermission requirePermission = method.getAnnotation(RequirePermission.class);
			return requirePermission == null ? null : requirePermission.logical();
		}
	}
	
	public static boolean AssertPermissionAnnotation(Class<?> targetClass, String methodName, Class<?>[] paramterTypes) throws NoSuchMethodException, SecurityException {
		Method method = getMethod(targetClass, methodName, paramterTypes);
		if (method.isAnnotationPresent(RequirePermission.class)) {
			return true;
		}
		return false;
	}
	
	public static boolean AsserRoleAnnotation(Class<?> targetClass, String methodName, Class<?>[] paramterTypes) throws NoSuchMethodException, SecurityException {
		Method method = getMethod(targetClass, methodName, paramterTypes);
		if (method.isAnnotationPresent(RequireRole.class)) {
			return true;
		}
		return false;
	}
	
	private static Method getMethod(Class<?> targetClass, String methodName, Class<?>[] paramterTypes) throws NoSuchMethodException, SecurityException {
		Method method = targetClass.getMethod(methodName, paramterTypes);
		return method;
	}
	
	public static boolean hasAnnotation(Class<?> targetClass, String methodName, Class<?>[] paramterTypes) throws NoSuchMethodException, SecurityException {
		return (AssertPermissionAnnotation(targetClass, methodName, paramterTypes) | AsserRoleAnnotation(targetClass, methodName, paramterTypes));
	}
	
}
