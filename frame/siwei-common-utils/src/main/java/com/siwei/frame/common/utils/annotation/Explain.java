package com.siwei.frame.common.utils.annotation;

import java.lang.annotation.*;

/**
 * @Description 信息注解
 * @author linxiunan
 * @date 2018年10月23日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Explain {

	String value() default "";  // 字段或类本身的名称
	
	String[] filedExplain();   // 字段值解释   以"1,禁用"的形式存储
	
	String secret() default ""; //开发者备注
}
