package com.siwei.frame.common.utils.enums;

/**
 * @Description 登录类型枚举类 
 * @author linxiunan
 * @date 2018年11月5日
 */
public enum LoginTypeEnum {
	
	USERNAME_PASSWORD_TYPE(1, "用户名密码登录"),
	EMAIL_PASSWORD_TYPE(2, "邮箱密码登录"),
	MOBILE_PASSWORD_TYPE(3, "手机号密码登录"),
	WECHART_LOGIN_TYPE(4, "微信登录"),
	QQ_LOGIN_TYPE(5, "QQ登录"),
	;
	
	private Integer code;
	private String message;

	private LoginTypeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
