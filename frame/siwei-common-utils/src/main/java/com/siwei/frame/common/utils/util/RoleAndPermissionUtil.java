package com.siwei.frame.common.utils.util;

import com.siwei.frame.common.utils.enums.Logical;

import java.util.Arrays;
import java.util.List;

public class RoleAndPermissionUtil {

	public static boolean hasRoleOrPermission(List<String> rolesOrPermissionsList, String[] requireRolesOrPermissions, Class<?> targetClass,
			String methodName, Class<?>[] paramterTypes, Class<?> annotationClass) throws NoSuchMethodException, SecurityException {
		if (rolesOrPermissionsList == null || rolesOrPermissionsList.isEmpty()) {
			return false;
		}
		Logical logical = PermissionAnnotationUtil.getRoleOrPermissionLogical(targetClass, methodName, paramterTypes, annotationClass);
		switch (logical) {
		case AND:
			return rolesOrPermissionsList.containsAll(Arrays.asList(requireRolesOrPermissions)) ? true : false;
		case OR:
			rolesOrPermissionsList.retainAll(Arrays.asList(requireRolesOrPermissions));
			return rolesOrPermissionsList.size() > 0 ? true : false;
		default:
			return false;
		}
	}
}
