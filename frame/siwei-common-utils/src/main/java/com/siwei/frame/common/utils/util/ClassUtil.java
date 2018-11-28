package com.siwei.frame.common.utils.util;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassUtil {
	
	public static Integer getEntityId(Object object, Field[] fields) throws Exception {
		Class<?> classes = object.getClass();
		Integer entityId = null;
		for (Field field : fields) {
			if (field.getName().equals("id")) {
				Method method = classes.getMethod("get" + getMethodName(field.getName()));
				entityId = (Integer) method.invoke(object);
			}
		}
		return entityId;
	}

	public static String getEntityLog(Object object, Field[] fields, String operation, String entityPropertity)
			throws Exception {
		StringBuffer log = new StringBuffer();
		Class<?> classes = object.getClass();
		log.append(operation + entityPropertity + ":: ");
		for (Field field : fields) {
			ApiModelProperty propertyAnno = field.getAnnotation(ApiModelProperty.class);
			if (propertyAnno != null && StringUtils.isNotBlank(propertyAnno.value())) {
				if (field.getGenericType().toString().equals("class java.lang.String")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					String value = (String) method.invoke(object);
					if (StringUtils.isNotBlank(value)) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("class java.lang.Integer")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					Integer value = (Integer) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("class java.lang.Double")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					Double value = (Double) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("double")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					Double value = (Double) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("class java.lang.Boolean")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					Boolean value = (Boolean) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("boolean")) {
					Method method = classes.getMethod("is" + getMethodName(field.getName()));
					Boolean value = (Boolean) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(value).append("; ");
					}
				}
				if (field.getGenericType().toString().equals("class java.util.Date")) {
					Method method = classes.getMethod("get" + getMethodName(field.getName()));
					Date value = (Date) method.invoke(object);
					if (value != null) {
						log.append(propertyAnno.value()).append(": ").append(DateUtil.dateToLongString(value))
								.append("; ");
					}
				}
			}
		}
		return log.toString();
	}

	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public static <T> String getLogTableName(T entity) {
		String className = entity.getClass().getName();
		StringBuffer logTableName = new StringBuffer();
		if(StringUtils.isNotBlank(className)) {
			if (className.contains(".")) {
				int last = className.lastIndexOf(".");
				className = className.substring(last + 1, className.length());
			}
			
			className = String.valueOf(className.charAt(0)).toLowerCase().concat(className.substring(1));
			Pattern pattern = Pattern.compile("[A-Z]");
			Matcher matcher = pattern.matcher(className);
			while(matcher.find()) {
				matcher.appendReplacement(logTableName, "_" + matcher.group(0).toLowerCase());
			}
			matcher.appendTail(logTableName);
			logTableName.append("_log");
		}
		return StringUtils.isBlank(logTableName) ? null : logTableName.toString();
	}
}
