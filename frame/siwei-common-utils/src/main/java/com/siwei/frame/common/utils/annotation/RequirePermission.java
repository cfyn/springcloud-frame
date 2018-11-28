package com.siwei.frame.common.utils.annotation;

import com.siwei.frame.common.utils.enums.Logical;

import java.lang.annotation.*;

/**
 * @Description 所需权限注解 
 * @author linxiunan
 * @date 2018年10月23日
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePermission {

	String[] value();
	
	Logical logical() default Logical.AND;
}
