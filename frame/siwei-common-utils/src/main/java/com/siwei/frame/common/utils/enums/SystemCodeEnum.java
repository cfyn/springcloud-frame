package com.siwei.frame.common.utils.enums;

/**
 * @Description 系统码枚举类 
 * @author linxiunan
 * @date 2018年11月5日
 */
public enum SystemCodeEnum {
	
	ASTACK_ADMIN_SYSTEM(1, "A栈后台"),
	ASTACK_AGENT_SYSTEM(2, "A栈APP"),
	ASTACK_WEBAPP_SYSTEM(3, "A栈WebApp"),
	ASTACK_STATISTICAL_SYSTEM(4, "A栈统计系统"),
	ASTACK_AGENT_SMALL_PROGRAM_SYSTEM(5, "代理人小程序"),
	ASTACK_TOC_SMALL_PROGRAM_SYSTEM(6, "c端用户小程序"),
	
	LIFE_INSURANCE_SYSTEM(11, "寿险"),
	
	DAFENG_STATISTICAL_SYSTEM(21, "大蜂统计系统"),
	;
	
	private Integer code;
	private String message;

	private SystemCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	public static SystemCodeEnum getSystemCodeEnum(Integer code) {
		for (SystemCodeEnum systemCode : SystemCodeEnum.values()) {  
            if (systemCode.getCode() == code) {  
                return systemCode;  
            }
        }
		return null;
	}
}
